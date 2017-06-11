package com.cups.soscom.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;
import com.cups.soscom.R;
import com.cups.soscom.helper.HelperGlobal;
import com.cups.soscom.util.UIImageLoader;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.Map;

/**
 * Created by ekobudiarto on 6/11/17.
 */

public class FragmentDetail extends BaseFragment {

    View mainView;
    HelperGlobal.InterfaceFragment interfaceFragment;
    BaseActivity activity;
    private static final String TAG_FRAGMENT_DETAIL = "tag:fragment_detail";

    ImageButton imgBtnBack;
    ImageView comBigImage;
    RoundedImageView comImageAvatar;
    String dataImage, dataAvatar, dataFullname;
    Map<String, String> param;
    UIImageLoader imageLoader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(mainView == null)
        {
            mainView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_detail, container, false);
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
        setTAG(TAG_FRAGMENT_DETAIL);
        param = getParameter();
        dataImage = param.get("data_image");
        dataAvatar = param.get("data_avatar");
        imageLoader = new UIImageLoader(activity);
    }

    @Override
    public void onStart() {
        super.onStart();
        onInitComponent();
        onLoadData();
    }

    @Override
    public void onInitComponent() {
        super.onInitComponent();
        comBigImage = (ImageView) mainView.findViewById(R.id.frg_detail_bigimage);
        comImageAvatar = (RoundedImageView) mainView.findViewById(R.id.frg_detail_avatar);
        imgBtnBack = (ImageButton) mainView.findViewById(R.id.frg_detail_imgbtn_back);
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    @Override
    public void onLoadData() {
        super.onLoadData();

        imageLoader.showImage(dataImage, comBigImage);
        imageLoader.showImage(dataAvatar, comImageAvatar);
    }

    @Override
    public String getTAG() {
        return TAG_FRAGMENT_DETAIL;
    }
}
