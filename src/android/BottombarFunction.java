package com.method76.bottombar.bridge;

import java.util.HashMap;
import java.util.Map;

import org.apache.cordova.CordovaActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.PluginResult;

/**
 * BottombarBridge is a Cordova plugin that communicates Native Tab UI with JavaScript
 * @author methodtweak@naver.com
 */
public interface BottombarFunction {

    int changeTab(int idx, String URL);

}
