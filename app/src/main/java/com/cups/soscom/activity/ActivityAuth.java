package com.cups.soscom.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;

import java.util.Map;

public class ActivityAuth extends BaseActivity implements HelperGlobal.InterfaceFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    @Override
    public void onAttachFragment(BaseFragment src, Map<String, String> parameter) {
        if(!src.isAdded())
        {
            src.setParameter(parameter);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(src.getTAG());
            ft.add(R.id.act_fragment_auth, src);
            ft.commit();
        }
    }
}
