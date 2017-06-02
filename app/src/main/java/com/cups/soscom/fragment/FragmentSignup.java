package com.cups.soscom.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class FragmentSignup extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    private static final String TAG_FRAGMENT_SIGNUP = "tag:fragment_signup";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_signup, container, false);
        }
        onInit();
        onInitComponent();
        return mainView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context != null)
        {
            this.activity = (BaseActivity) context;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onInit() {
        super.onInit();
        setTAG(TAG_FRAGMENT_SIGNUP);
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
    }

    @Override
    public void onLoadData() {
        super.onLoadData();
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_SIGNUP;
    }
}
