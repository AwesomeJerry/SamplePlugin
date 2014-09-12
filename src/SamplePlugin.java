package com.example.myplugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;

public class SamplePlugin extends CordovaPlugin {
    public static final String ACTION_OPEN_INTENT = "openIntent";
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (ACTION_OPEN_INTENT.equals(action)) { 
                     JSONObject arg_object = args.getJSONObject(0);
                     Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
               this.cordova.getActivity().startActivity(intent);
               callbackContext.success();
               return true;
            }
            callbackContext.error("Invalid action");
            return false;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            callbackContext.error(e.getMessage());
            return false;
        } 
    }
}