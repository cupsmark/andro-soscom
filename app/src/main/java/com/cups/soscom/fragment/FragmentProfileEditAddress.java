package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;

/**
 * Created by ekobudiarto on 6/11/17.
 */

public class FragmentProfileEditAddress extends BaseFragment{

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    private static final String TAG_FRAGMENT_PROFILE_EDIT_ADDRESS = "tag:fragment_profile_edit_address";

    ImageButton imageButtonClose, imageButtonApply;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_profile_edit_address, container, false);
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
        setTAG(TAG_FRAGMENT_PROFILE_EDIT_ADDRESS);
    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
        imageButtonApply = (ImageButton) mainView.findViewById(R.id.frg_profile_edit_address_btn_apply);
        imageButtonClose = (ImageButton) mainView.findViewById(R.id.frg_profile_edit_address_btn_cancel);

        imageButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
        imageButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    @Override
    public void onLoadData() {
        super.onLoadData();
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_PROFILE_EDIT_ADDRESS;
    }
}
