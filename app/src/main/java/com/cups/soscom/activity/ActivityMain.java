package com.cups.soscom.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;

import com.crashlytics.android.Crashlytics;
import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;

import java.util.Map;

import io.fabric.sdk.android.Fabric;

public class ActivityMain extends BaseActivity implements HelperGlobal.InterfaceFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onAttachFragment(BaseFragment src, Map<String, String> parameter) {
        if(!src.isAdded())
        {
            src.setParameter(parameter);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(src.getTAG());
            ft.add(R.id.act_fragment_main, src);
            ft.commit();
        }
    }
}
