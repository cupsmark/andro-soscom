package com.cups.soscom.fragment;

import android.app.Activity;
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
 * Created by ekobudiarto on 6/6/17.
 */

public class FragmentLove extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_LOVE = "tag:fragment_love";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_love, container, false);
        }
        onInit();
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity != null)
        {
            this.activity = (BaseActivity) activity;
            interfaceFragment = (HelperGlobal.InterfaceFragment) this.activity;
        }
    }

    @Override
    public void onInit() {
        super.onInit();
        setTAG(TAG_FRAGMENT_LOVE);
    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
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
        return TAG_FRAGMENT_LOVE;
    }
}
