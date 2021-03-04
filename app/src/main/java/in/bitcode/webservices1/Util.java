package in.bitcode.webservices1;

import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class Util {

    public static ArrayList<Place> getPlaces() {

        try {
            String strUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500&type=restaurant&keyword=cruise&key=AIzaSyAkFMmA6Qr2tGmZhTYtFxsUq0XeXcVJemE";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strUrl).openConnection();

            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() != 200) {
                return null;
            }

            InputStream in = httpURLConnection.getInputStream();

            byte [] data = new byte[1024 * 4];
            int count;
            StringBuilder response = new StringBuilder();

            while( (count = in.read(data)) != -1) {
                response.append( new String(data, 0, count) );
            }

            mt(response.toString());

            in.close();
            httpURLConnection.disconnect();

            JSONObject jResponse = new JSONObject(response.toString());
            mt("status ---> " + jResponse.getString("status"));

            ArrayList<Place> places = new ArrayList<>();
            JSONArray jPlaces = jResponse.getJSONArray("results");

            for(int i = 0; i < jPlaces.length(); i++) {
                JSONObject jPlace = jPlaces.getJSONObject(i);

                String name = jPlace.getString("name");
                String vicinity = jPlace.getString("vicinity");
                float rating = (float) jPlace.getDouble("rating");

                JSONObject jLoc = jPlace.getJSONObject("geometry").getJSONObject("location");
                double lat = jLoc.getDouble("lat");
                double lng = jLoc.getDouble("lng");


                places.add( new Place(name, vicinity, rating, lat, lng) );
            }

            return places;


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void reqResDemo() {

        try {

            URL url = new URL("https://bitcode.in");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.setRequestMethod("POST");

            //httpURLConnection.getOutputStream()

            httpURLConnection.connect();
            mt( "res code: " + httpURLConnection.getResponseCode() );
            mt( "res msg: " + httpURLConnection.getResponseMessage() );
            mt( "res len: " + httpURLConnection.getContentLength() );
            mt("res type: " + httpURLConnection.getContentType());
            mt("req method: " + httpURLConnection.getRequestMethod());

            InputStream in = httpURLConnection.getInputStream();

            byte [] data = new byte[1024 * 4];
            int count;

            StringBuilder response = new StringBuilder();

            while( (count = in.read(data)) != -1) {
                //mt( new String(data, 0, count));
                response.append( new String(data, 0, count) );
            }

            mt(response.toString());

            in.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void downloadImage(File dir) {

        try {

            URL url = new URL("https://bitcode.in/images/gallery/bitcode_galary_iphone_app_development_thumbnail_1.jpg");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();

            InputStream in = httpURLConnection.getInputStream();

            byte [] data = new byte[1024 * 4];
            int count;


            File imageFile =
                    new File(
                            //Environment.getExternalStorageDirectory(),
                            dir,
                            "myimage.jpg"
                    );
            imageFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(imageFile);


            while( (count = in.read(data)) != -1) {
                fout.write(data, 0, count);
            }

            in.close();
            fout.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void mt(String text) {
        Log.e("tag", text);
    }
}
