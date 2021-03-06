package com.cups.soscom.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class FragmentProfile extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    final String TAG_FRAGMENT_PROFILE = "tag:fragment_profile";

    RelativeLayout relativeItemDelivery;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_profile, container, false);
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
        setTAG(TAG_FRAGMENT_PROFILE);
    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
        relativeItemDelivery = (RelativeLayout) mainView.findViewById(R.id.frg_profile_item_address);

        relativeItemDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEditAddress();
            }
        });
    }

    private void openEditAddress()
    {
        FragmentProfileEditAddress address = new FragmentProfileEditAddress();
        Map<String, String> param = new HashMap<String, String>();
        interfaceFragment.onAttachFragment(address, param);
    }

    @Override
    public void onLoadData() {
        super.onLoadData();
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_PROFILE;
    }
}
