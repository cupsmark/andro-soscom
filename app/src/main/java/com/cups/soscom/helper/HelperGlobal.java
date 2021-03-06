package com.cups.soscom.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.cups.soscom.BaseActivity;
import com.cups.soscom.BaseFragment;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class HelperGlobal {

    public interface InterfaceFragment{
        public void onAttachFragment(BaseFragment src, Map<String, String> parameter);
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public interface onLoadMoreListener{
        void onLoadMore();
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    public static String getJSON(String urlData)
    {
        String result = "";
        try{
            URL url = new URL(urlData);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setConnectTimeout(20 * 1000);
            urlConnection.setReadTimeout(20 * 1000);

            // Check the connection status
            if(urlConnection.getResponseCode() == 200)
            {
                // if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                urlConnection.disconnect();
            }
            else
            {
                result = "";
            }
        }catch (MalformedURLException e){
            //e.printStackTrace();
            result = "";
        }catch(IOException e){
            //e.printStackTrace();
            result = "";
        }finally {

        }
        // Return the data from specified url
        return result;
    }

    public static boolean checkConnection(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    public static String getDeviceID(Context c) {
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    public static String getNetworkProvider(Context c) {
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getNetworkOperatorName();
    }

    public static String getCountryID(Context c) {
        String result = "";
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm.getPhoneType() == TelephonyManager.PHONE_TYPE_CDMA) {
            result = tm.getSimCountryIso();
        } else {
            result = tm.getNetworkCountryIso();
        }
        return result.toUpperCase(Locale.US);
    }


    public final static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static String getDeviceVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getAppVersionName(Context context) {
        String result = "";
        try {
            result = "v" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            result = "";
        }
        return result;
    }

    public static int getAppVersionCode(Context context) {
        int result = 0;
        try {
            result = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            result = 0;
        }
        return result;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void openApplicationInPlayStore(Context context, String packages) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packages)));
        } catch (ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packages)));
        }
    }

    public static void openAppURL(Context context, String url) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } catch (ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        }
    }

    public static Bitmap getAssetBitmap(String filename, Context context) {
        Bitmap bmp = null;
        AssetManager assets = context.getAssets();
        InputStream inputStream;
        try {
            inputStream = assets.open("files/" + filename);
            bmp = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            bmp = null;
            e.printStackTrace();
        }
        return bmp;
    }

    public final static String getPrivatePath(String filename, Context context) {
        String result = "";
        result = "file:///" + context.getFilesDir().getAbsolutePath() + "/" + filename;
        return result;
    }

    public final static String getAssetsPath(String filename) {
        return "assets://" + filename;
    }

    public static void DeleteInternalFile(String filename, Context mContext)
    {
        File dir = mContext.getFilesDir();
        File file = new File(dir, filename);
        if(file.exists())
        {
            file.delete();
        }
    }

    public static int getScreenSize(Context context, String param) {
        int size = 0;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        if (Build.VERSION.SDK_INT > 12) {
            Point sizePoint = new Point();
            display.getSize(sizePoint);
            if(param.equals("w"))
            {
                size = sizePoint.x;
            }
            else
            {
                size = sizePoint.y;
            }

        } else {
            if(param.equals("w"))
            {
                size = display.getWidth();
            }
            else
            {
                size = display.getHeight();
            }
        }

        return size;
    }

    public static final int getColor(Context context, int id)
    {
        final int version = Build.VERSION.SDK_INT;
        if(version >= 23)
        {
            return ContextCompat.getColor(context, id);
        }
        else
        {
            return context.getResources().getColor(id);
        }
    }

    public static String postJSON(String urlData, String[] field, String[] value)
    {
        String result = "";
        try{
            URL url = new URL(urlData);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(20 * 1000);
            urlConnection.setReadTimeout(20 * 1000);

            Uri.Builder uriBuilder = new Uri.Builder();
            for(int i = 0;i < field.length;i++)
            {
                uriBuilder.appendQueryParameter(field[i], value[i]);
            }
            String query = uriBuilder.build().getEncodedQuery();
            OutputStream os = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            // Check the connection status
            int responseCode = urlConnection.getResponseCode();
            if(responseCode == 200)
            {
                // if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                urlConnection.disconnect();
            }
            else
            {
                result = "";
            }
        }catch (MalformedURLException e){
            //e.printStackTrace();
            result = "";
        }catch(IOException e){
            //e.printStackTrace();
            result = "";
        }finally {

        }
        // Return the data from specified url
        return result;
    }

    public static final String GetJSONAssets(String jsonFile, Context context)
    {
        String jsonResult = null;
        try {
            InputStream is = context.getAssets().open("json/" + jsonFile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonResult = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonResult;
    }

    public static String convertStandardJSONString(String data_json){
        data_json = data_json.replace("\\", "");
        data_json = data_json.replace("\"{", "{");
        data_json = data_json.replace("}\",", "},");
        data_json = data_json.replace("}\"", "}");
        return data_json;
    }

    public static String buildURL(String url, String[] field, String[] value)
    {
        String path = "";
        Uri.Builder builder = Uri.parse(url).buildUpon();
        for(int i = 0;i < field.length;i++)
        {
            builder.appendQueryParameter(field[i], value[i]);
        }
        path = builder.build().toString();
        return path;
    }

    public static boolean checkInternalFile(String filename, Context mContext)
    {
        File dir = mContext.getFilesDir();
        File file = new File(dir, filename);
        if(file.exists())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void saveBitmapInternal(String filename, Context context, Bitmap bitmap)
    {
        FileOutputStream fos;
        try {
            fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void closeKeyboard(BaseActivity activity)
    {
        View v = activity.getCurrentFocus();
        if(v != null)
        {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }

    }

    public static String getFormatedAmount(int amount){
        return NumberFormat.getNumberInstance(Locale.US).format(amount);
    }

    public static Bitmap setBitmapColor(int color,Bitmap source)
    {
        if (color == 0) {
            color = 0xffffffff;
        }

        Bitmap maskBitmap = source;
        final int width = maskBitmap.getWidth();
        final int height = maskBitmap.getHeight();

        Bitmap outBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outBitmap);
        canvas.drawBitmap(maskBitmap, 0, 0, null);

        Paint maskedPaint = new Paint();
        maskedPaint.setColor(color);
        maskedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));

        canvas.drawRect(0, 0, width, height, maskedPaint);

        return outBitmap;
    }
}
