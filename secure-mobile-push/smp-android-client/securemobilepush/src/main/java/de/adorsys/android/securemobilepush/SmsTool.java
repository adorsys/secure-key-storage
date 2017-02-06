package de.adorsys.android.securemobilepush;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;

public class SmsTool {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private Context context;
    private Activity activity;

    public SmsTool(@NonNull Context context) {
        this.context = context;
        activity = (Activity) context;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void requestSMSPermission() {
        final String permission = Manifest.permission.READ_SMS;
        int hasSpecificPermission = ContextCompat.checkSelfPermission(context, permission);

        if (hasSpecificPermission != PackageManager.PERMISSION_GRANTED) {
            if (!activity.shouldShowRequestPermissionRationale(permission)) {
                activity.requestPermissions(new String[]{permission},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
        }
    }
}