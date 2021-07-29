package xyz.kumaraswamy.taskutil;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.judemanutd.autostarter.AutoStartPermissionHelper;

public class TaskUtil extends AndroidNonvisibleComponent {

    private final AutoStartPermissionHelper permissionHelper;
    private final ActivityManager activityManager;

    private final Activity activity;

    public TaskUtil(ComponentContainer container) {
        super(container.$form());

        activity = container.$context();
        activityManager = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        permissionHelper = AutoStartPermissionHelper.Companion.getInstance();
    }

    @SimpleFunction(description = "Checks if background services are restricted.")
    public boolean IsRestricted() {
        return activityManager.isBackgroundRestricted();
    }

    @SimpleFunction(description =
            "Use this block to check if autostart " +
            "(or any permission required to run a service) is available.")
    public boolean IsAutoStartAvailable() {
        return permissionHelper.isAutoStartPermissionAvailable(activity, true);
    }

    @SimpleFunction(description =
            "Opens the activity page where the user requires to allow an " +
            "additional permission to get the service working.")
    public void RequestAutoStart() {
        permissionHelper.getAutoStartPermission(activity, true, true);
    }
}
