package android.example.com.visualizerpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        https://stackoverflow.com/questions/22812669/why-is-the-up-button-present-without-setdisplayhomeasupenabled
//        You have both android:parentActivityName=".MyActivityand this getActionBar().setDisplayHomeAsUpEnabled(true);"
//                - back button appears and it works;
//        You only have this android:parentActivityName=".MyActivity "
//                - back button appears and it works, the same as above;
//        You only have this getActionBar().setDisplayHomeAsUpEnabled(true);,
//                - back button appears but clicking on it doesn't go anywhere;
//        You have set the parameter to false in this getActionBar().setDisplayHomeAsUpEnabled(false);,
//                even though you have this android:parentActivityName=".MyActivity"
//                in the manifest, the back button doesn't show up.
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_settings);
    }
}
