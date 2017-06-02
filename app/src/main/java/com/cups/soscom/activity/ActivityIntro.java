package com.cups.soscom.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.R;

public class ActivityIntro extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLaunch();
    }

    private void onLaunch()
    {
        new AsyncTask<Void, Integer, String>()
        {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Void... voids) {
                return "";
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Intent intent = new Intent(ActivityIntro.this, ActivityAuth.class);
                startActivity(intent);
                finish();
            }
        }.execute();
    }

}
