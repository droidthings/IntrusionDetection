package com.abi.rtes.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Abhilash on 29/03/2018.
 */


public class IAPreference {

    public static final String DB_SHARED_PREF_NAME = "IAAppSettings";

    /**
     * SharedPreferences object that will be used for storing persistent data
     */
    private static SharedPreferences mSharedPreferences;

    public static void startWith(Context applicationContext) {
        mSharedPreferences = applicationContext.getSharedPreferences(DB_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Gets an integer from persistent storage
     *
     * @param variable Variable name in string
     * @return returns the value that is stored if available, 0 otherwise
     */
    public static int getInt(String variable) {
        return getInt(variable, 0);
    }

    /**
     * Gets an integer from persistent storage
     *
     * @param variable     Variable name in string
     * @param defaultValue If this variable is not initialized, this default value will be returned instead
     * @return returns the value that is stored if available, defaultValue otherwise
     */
    public static int getInt(String variable, int defaultValue) {
        if (mSharedPreferences == null)
            return defaultValue;
        return mSharedPreferences.getInt(variable, defaultValue);
    }

    /**
     * Sets an integer in persistent storage
     *
     * @param variable Variable name in string
     * @param value    Value to be set
     */
    public static void setInt(String variable, int value) {
        if (mSharedPreferences == null)
            return;
        Editor e = mSharedPreferences.edit();
        e.putInt(variable, value);
        e.commit();
    }

    /**
     * Gets a String from persistent storage
     *
     * @param variable Variable name in string
     * @return returns the value that is stored if available, null otherwise
     */
    public static String getString(String variable) {
        return getString(variable, null);
    }

    /**
     * Gets a String from persistent storage
     *
     * @param variable     Variable name in string
     * @param defaultValue If this variable is not initialized, this default value will be returned instead
     * @return returns the value that is stored if available, defaultValue otherwise
     */
    public static String getString(String variable, String defaultValue) {
        if (mSharedPreferences == null)
            return defaultValue;
        return mSharedPreferences.getString(variable, defaultValue);
    }

    /**
     * Sets a String in persistent storage
     *
     * @param variable Variable name in string
     * @param value    Value to be set
     */
    public static void setString(String variable, String value) {
        if (mSharedPreferences == null)
            return;
        Editor e = mSharedPreferences.edit();
        e.putString(variable, value);
        e.commit();
    }

    /**
     * Gets a boolean from persistent storage
     *
     * @param variable Variable name in string
     * @return returns the value that is stored if available, false otherwise
     */
    public static boolean getBoolean(String variable) {
        return getBoolean(variable, false);
    }

    /**
     * Gets a boolean from persistent storage
     *
     * @param variable     Variable name in string
     * @param defaultValue If this variable is not initialized, this default value will be returned instead
     * @return returns the value that is stored if available, defaultValue otherwise
     */
    public static boolean getBoolean(String variable, boolean defaultValue) {
        if (mSharedPreferences == null)
            return defaultValue;
        return mSharedPreferences.getBoolean(variable, defaultValue);
    }

    /**
     * Sets a boolean in persistent storage
     *
     * @param variable Variable name in string
     * @param value    Value to be set
     */
    public static void setBoolean(String variable, boolean value) {
        if (mSharedPreferences == null)
            return;
        Editor e = mSharedPreferences.edit();
        e.putBoolean(variable, value);
        e.commit();
    }

    /**
     * Gets a float from persistent storage
     *
     * @param variable Variable name in string
     * @return returns the value that is stored if available, 0.0f otherwise
     */
    public static float getFloat(String variable) {
        return getFloat(variable, 0.0f);
    }

    /**
     * Gets a float from persistent storage
     *
     * @param variable     Variable name in string
     * @param defaultValue If this variable is not initialized, this default value will be returned instead
     * @return returns the value that is stored if available, defaultValue otherwise
     */
    public static float getFloat(String variable, float defaultValue) {
        if (mSharedPreferences == null)
            return defaultValue;
        return mSharedPreferences.getFloat(variable, defaultValue);
    }

    /**
     * Sets a float in persistent storage
     *
     * @param variable Variable name in string
     * @param value    Value to be set
     */
    public static void setFloat(String variable, float value) {
        if (mSharedPreferences == null)
            return;
        Editor e = mSharedPreferences.edit();
        e.putFloat(variable, value);
        e.commit();
    }

    /**
     * Gets a long from persistent storage
     *
     * @param variable Variable name in string
     * @return returns the value that is stored if available, 0L otherwise
     */
    public static long getLong(String variable) {
        return getLong(variable, 0L);
    }

    /**
     * Gets a long from persistent storage
     *
     * @param variable     Variable name in string
     * @param defaultValue If this variable is not initialized, this default value will be returned instead
     * @return returns the value that is stored if available, defaultValue otherwise
     */
    public static long getLong(String variable, long defaultValue) {
        if (mSharedPreferences == null)
            return defaultValue;
        return mSharedPreferences.getLong(variable, defaultValue);
    }

    /**
     * Sets a long in persistent storage
     *
     * @param variable Variable name in string
     * @param value    Value to be set
     */
    public static void setLong(String variable, long value) {
        if (mSharedPreferences == null)
            return;
        Editor e = mSharedPreferences.edit();
        e.putLong(variable, value);
        e.commit();
    }

}
