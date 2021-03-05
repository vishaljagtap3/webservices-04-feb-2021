package in.bitcode.webservices1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<Object, Object, ArrayList<Place>>() {
            @Override
            protected ArrayList<Place> doInBackground(Object... objects) {
                //Util.reqResDemo();
                //return Util.getPlaces();
                //Util.downloadImage( getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                Util.getPlaces1();
                return null;
            }

            @Override
            protected void onPostExecute(ArrayList<Place> places) {
                super.onPostExecute(places);
                /*for(Place place : places) {
                    Log.e("tag", place.toString());
                }*/
            }
        }
        .execute((Object[])null);
    }
}