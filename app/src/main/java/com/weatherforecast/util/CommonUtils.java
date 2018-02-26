package com.weatherforecast.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class CommonUtils {

    private static String TAG = "CommonUtils";
    private static CommonUtils commonUtility = null;

    //Single ton method...
    public static CommonUtils getInstance() {
        if (commonUtility != null) {
            return commonUtility;
        } else {
            commonUtility = new CommonUtils();
            return commonUtility;
        }
    }

    public boolean isAboveMarshmallow() {
        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {
            // Do something for marshmallow and above versions
            return true;
        } else {
            // do something for phones running an SDK before marshmallow
            return false;

        }
    }

    /*public Location getLocation(Context context) {
        GPSTracker gpsTracker = new GPSTracker(context);
        if (gpsTracker.canGetLocation()) {
            return gpsTracker.getLocation();
        } else {
            return null;
        }

    }
    */
    public boolean isAboveLollipop() {
        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP) {
            // Do something for marshmallow and above versions
            return true;
        } else {
            // do something for phones running an SDK before marshmallow
            return false;

        }
    }

    public boolean hasNetworkConnection(Context context) {
        // TODO Auto-generated method stub

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean valid = false;

        /*NetworkInfo wifiNetwork = cm.getActiveNetworkInfo();
        if (wifiNetwork != null && wifiNetwork.isConnectedOrConnecting()) {
            valid = true;
        }*/

       /* NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnectedOrConnecting()) {
            valid = true;
        }*/

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            valid = true;
        }

        return valid;
    }

    public void hideSoftKeyboard(View view, Context context) {

        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void hideSoftKeyboard(Activity activity) {
        // Check if no view has focus:
        View view = activity.getCurrentFocus();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        /* InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        View focusedView = activity.getCurrentFocus();
    *//*
     * If no view is focused, an NPE will be thrown
     *
     * Maxim Dmitriev
     *//*
        if (focusedView != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }*/
    }

    public void showSoftKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * Check whether the string contains value (OR) not.
     *
     * @param isNotNull string value which has to be checked
     * @return true if the given string is not null and this will validateBaseResponseList if the contains
     * "null" as a String value too
     */

    public boolean isNullCheck(String isNotNull) {
        isNotNull = isNotNull.trim();
        if (isNotNull != null) {
            if (!isNotNull.equalsIgnoreCase("") && isNotNull.length() > 0) {
                if (!isNotNull.equalsIgnoreCase("null")) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Checks whether the arraylist has values (or) not.
     *
     * @param arrayList which has to be checked
     * @return "true" if the given arraylist is not null and has values; otherwise "false".
     */


    public boolean isNullCheck(ArrayList<?> arrayList) {

        if (arrayList != null) {
            if (arrayList.size() > 0 && !arrayList.isEmpty()) {
                return true;
            }
        }

        return false;
    }


    /**
     * Checks whether the list has values (or) not.
     *
     * @param list which has to be checked
     * @return "true" if the given list is not null and has values; otherwise "false".
     */

    public boolean isNullCheck(List<?> list) {

        if (list != null) {
            if (list.size() > 0 && !list.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public String convertDateToMonthDateTimeString(String timeData) {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        Date date = null;
        try {
            date = (Date) formatter.parse(timeData);
            Log.e(TAG,date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, hh:mm a");
        String finalString = newFormat.format(date);
        return finalString;
    }

    public String convertDateToMonthDateString(String timeData) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) formatter.parse(timeData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd");
        String finalString = newFormat.format(date);
        return finalString;
    }

    public String convertDateToDayMonthDateString(String timeData) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) formatter.parse(timeData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newFormat = new SimpleDateFormat("EEEE, MMM dd");
        String finalString = newFormat.format(date);
        return finalString;
    }
}
