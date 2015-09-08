package com.appsparaguay.testlistcontrol.util;

import com.loopj.android.http.*;

import org.apache.http.Header;

/**
 * Created by Administrador on 9/8/2015.
 */
public class RestUtil {

    private static final String BASE_URL = "http://52.7.2.149/ServerDatapar/rest/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
