package com.abi.rtes.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by Abhilash on 29/03/2018.
 */

public class ProgressUtils {

    public static ProgressDialog mProgressDialog = null;

    public static void showProgress(Activity activity, String message, boolean cancelable) {

        mProgressDialog = new ProgressDialog(activity);
        mProgressDialog.setCancelable(false);

        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }
    }

    public static void showProgress(Activity activity, String message) {
        showProgress(activity, message, false);
    }

    public static void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
