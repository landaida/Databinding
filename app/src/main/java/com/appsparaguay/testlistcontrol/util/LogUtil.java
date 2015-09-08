package com.appsparaguay.testlistcontrol.util;

import android.util.Log;

/**
 * Created by Administrador on 9/8/2015.
 */
public class LogUtil {
    public static final String myTagName = "myTagName";

    public static void i(String message){
        Log.i(myTagName, message);
    }

    public static void e(String message){
        Log.e(myTagName, message);
    }
}
