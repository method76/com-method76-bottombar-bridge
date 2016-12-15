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
 * WebIntent is a PhoneGap plugin that bridges Android intents and web
 * applications:
 * 
 * 1. web apps can spawn intents that call native Android applications. 2.
 * (after setting up correct intent filters for PhoneGap applications), Android
 * intents can be handled by PhoneGap web applications.
 * 
 * @author methodtweak@naver.com
 * 
 */
public class BottombarBridge extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

				if (action==null || "changeTab".equals(action)==false || args.length() < 2) {
						//return new PluginResult(PluginResult.Status.INVALID_ACTION);
						callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
						return false;
					}
				}

        // Parse the arguments
				final CordovaResourceApi resourceApi = webView.getResourceApi();

        int tabIdx = args.getInt(0);
        String url = args.getString(1);
        
        // Todo: Some validation required
        
        MainActivity act = (MainActivity)this.cordova.getActivity()
        act.changeTab(tabIdx, url);
        
        //return new PluginResult(PluginResult.Status.OK);
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
        return true;

    }

}
