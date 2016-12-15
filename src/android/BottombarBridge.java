package com.method76.bottombarbridge;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;

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

        if (action==null || "changeTab".equals(action)==false
            || args.length() < 1) {
            //return new PluginResult(PluginResult.Status.INVALID_ACTION);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
            return false;
        }

        try {
            int tabIdx = args.getInt(0);
	        String url = args.length()==2?args.getString(1):null;

            Log.d("Tab clicked: ", tabIdx + "/" + url);

            // Todo: Some validation required

            BottombarFunction act = (BottombarFunction) this.cordova.getActivity();
            if (url==null) {
                act.changeTab(tabIdx);
            } else {
                act.changeTab(tabIdx, url);
            }

            //return new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            return true;
        } catch(Exception e){
            Log.e("Error", e.getMessage());
        }
        return false;

    }

}
