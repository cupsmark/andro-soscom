package com.cups.soscom.helper;

import com.cups.soscom.BaseFragment;
import java.util.Map;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class HelperGlobal {

    public interface InterfaceFragment{
        public void onAttachFragment(BaseFragment src, Map<String, String> parameter);
    }
}
