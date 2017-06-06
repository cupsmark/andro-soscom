package com.cups.soscom;



import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class BaseFragment extends Fragment {

    String TAG;

    Map<String, String> parameter;
    ArrayList<BaseFragment> fragmentTarget;

    public BaseFragment()
    {

    }
    public void onInit()
    {

    }
    public void onInitComponent()
    {

    }
    public void onActionComponent()
    {

    }
    public void onUpdate()
    {

    }
    public void onLoadData()
    {

    }
    public void setParameter(Map<String, String> param)
    {
        this.parameter = param;
    }
    public Map<String, String> getParameter()
    {
        return this.parameter;
    }
    public void setTAG(String tags)
    {
        this.TAG = tags;
    }
    public String getTAG()
    {
        return TAG;
    }

}
