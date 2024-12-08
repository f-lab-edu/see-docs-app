package kr.co.seedocs

import android.Manifest
import android.app.AppOpsManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val MANAGE_EXTERNAL_STORAGE_PERMISSION = "android:manage_external_storage"
private const val MANAGE_EXTERNAL_STORAGE_PERMISSION_REQUEST = 100
private const val READ_EXTERNAL_STORAGE_PERMISSION_REQUEST = 101

internal fun checkStoragePermission(
    activity: ComponentActivity,
): Boolean =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        checkStoragePermissionApi30(activity)
    } else {
        checkStoragePermissionApi19(activity)
    }

@RequiresApi(Build.VERSION_CODES.R)
private fun checkStoragePermissionApi30(activity: ComponentActivity): Boolean {
    val appOps = activity.getSystemService(AppOpsManager::class.java)
    val mode = appOps.unsafeCheckOpNoThrow(
        MANAGE_EXTERNAL_STORAGE_PERMISSION,
        activity.applicationInfo.uid,
        activity.packageName
    )

    return mode == AppOpsManager.MODE_ALLOWED
}

private fun checkStoragePermissionApi19(activity: ComponentActivity): Boolean {
    val status =
        ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)

    return status == PackageManager.PERMISSION_GRANTED
}

internal fun requestStoragePermission(activity: ComponentActivity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        requestStoragePermissionApi30(activity)
    }
    else {
        requestStoragePermissionApi19(activity)
    }
}

@RequiresApi(Build.VERSION_CODES.R)
private fun requestStoragePermissionApi30(
    activity: ComponentActivity
) {
    val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)

    activity.startActivityForResult(intent, MANAGE_EXTERNAL_STORAGE_PERMISSION_REQUEST)
}

fun requestStoragePermissionApi19(activity: ComponentActivity) {
    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    ActivityCompat.requestPermissions(
        activity,
        permissions,
        READ_EXTERNAL_STORAGE_PERMISSION_REQUEST
    )
}
