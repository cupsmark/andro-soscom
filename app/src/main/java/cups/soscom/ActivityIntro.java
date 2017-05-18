package cups.soscom;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class ActivityIntro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(Build.VERSION.SDK_INT < 21)
        {
            init();
        }
        else {
            getReadPhoneStatePermission();
        }
    }

    private void init()
    {
        new AsyncTask<Void, Integer, String>()
        {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            protected String doInBackground(Void... params) {
                SystemClock.sleep(3000);
                return "";
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                launchHome();
            }
        }.execute();
    }

    private void launchHome()
    {
        Intent intent = new Intent(ActivityIntro.this, ActivityMain.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case 112: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    init();
                } else {
                    Toast.makeText(ActivityIntro.this, "No Permission to Read Phone State.", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                }
            }
        }
    }

    private void getReadPhoneStatePermission() {

        if (Build.VERSION.SDK_INT >= 23) {
            if(ContextCompat.checkSelfPermission(ActivityIntro.this, Manifest.permission.READ_PHONE_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                init();
            } else {
                ActivityCompat.requestPermissions(ActivityIntro.this, new String[]{Manifest.permission.READ_PHONE_STATE}, 112);
            }
        }
        else
        {
            init();
        }
    }
}
