package com.fullscreenbridge;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;

import java.util.Objects;

public class FullScreen extends ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;

    FullScreen(ReactApplicationContext context){
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void hideBar(){

        hideSystemUI();
        Toast.makeText(reactContext, "hellöööö", Toast.LENGTH_LONG).show();
    }

    @NonNull
    @Override
    public String getName() {
        return "FullScreen";
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        UiThreadUtil.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Window window = Objects.requireNonNull(getCurrentActivity()).getWindow();

                        View decorView = window.getDecorView();
                        decorView.setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_IMMERSIVE
                                        // Set the content to appear under the system bars so that the
                                        // content doesn't resize when the system bars hide and show.
                                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                        // Hide the nav bar and status bar
                                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
                    }
                }
        );
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        UiThreadUtil.runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Window window = Objects.requireNonNull(getCurrentActivity()).getWindow();

                        View decorView = window.getDecorView();
                        decorView.setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                    }
                }
        );
    }



}
