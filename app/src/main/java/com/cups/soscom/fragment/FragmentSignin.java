package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.activity.ActivityAuth;
import com.cups.soscom.activity.ActivityMain;
import com.cups.soscom.helper.HelperGlobal;
import com.cups.soscom.ui.UIButton;
import com.cups.soscom.ui.UIEditText;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class FragmentSignin extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    public static final String TAG_FRAGMENT_SIGNIN = "tag:fragment_signin";

    UIEditText editTextUsername, editTextPassword;
    UIButton buttonForgot, buttonSignup;
    ImageButton imgbtnSignin, imgbtnFb, imgbtnTwitter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = inflater.inflate(R.layout.fragment_signin, container, false);
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
        setTAG(TAG_FRAGMENT_SIGNIN);
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
        editTextUsername = (UIEditText) mainView.findViewById(R.id.frg_signin_username);
        editTextPassword = (UIEditText) mainView.findViewById(R.id.frg_signin_password);
        buttonForgot = (UIButton) mainView.findViewById(R.id.frg_signin_btn_forgot);
        buttonSignup = (UIButton) mainView.findViewById(R.id.frg_signin_btn_signup);
        imgbtnSignin = (ImageButton) mainView.findViewById(R.id.frg_signin_imgbtn_signin);
        imgbtnFb = (ImageButton) mainView.findViewById(R.id.frg_signin_imgbtn_fb);
        imgbtnTwitter = (ImageButton) mainView.findViewById(R.id.frg_signin_imgbtn_twitter);
    }

    @Override
    public void onActionComponent() {
        super.onActionComponent();
        imgbtnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });
        imgbtnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgbtnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignup();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        onActionComponent();
    }
    private void goToSignup()
    {
        Map<String, String> param = new HashMap<String, String>();
        FragmentSignup signup = new FragmentSignup();
        interfaceFragment.onAttachFragment(signup, param);
    }
    private void goToHome()
    {
        Intent i = new Intent(activity, ActivityMain.class);
        startActivity(i);
        activity.finish();
    }
    @Override
    public void onLoadData() {
        super.onLoadData();
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_SIGNIN;
    }
}
