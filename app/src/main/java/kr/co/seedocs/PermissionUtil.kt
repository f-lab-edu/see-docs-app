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

internal fun ComponentActivity.checkStoragePermission(): Boolean =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        checkStoragePermissionApi30()
    } else {
        checkStoragePermissionApi19()
    }

@RequiresApi(Build.VERSION_CODES.R)
private fun ComponentActivity.checkStoragePermissionApi30(): Boolean {
    val appOps = getSystemService(AppOpsManager::class.java)
    val mode = appOps.unsafeCheckOpNoThrow(
        MANAGE_EXTERNAL_STORAGE_PERMISSION,
        applicationInfo.uid,
        packageName
    )

    return mode == AppOpsManager.MODE_ALLOWED
}

private fun ComponentActivity.checkStoragePermissionApi19(): Boolean {
    val status =
        ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)

    return status == PackageManager.PERMISSION_GRANTED
}

internal fun ComponentActivity.requestStoragePermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        requestStoragePermissionApi30()
    }
    else {
        requestStoragePermissionApi19()
    }
}

@RequiresApi(Build.VERSION_CODES.R)
private fun ComponentActivity.requestStoragePermissionApi30() {
    val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)

    startActivityForResult(intent, MANAGE_EXTERNAL_STORAGE_PERMISSION_REQUEST)
}

private fun ComponentActivity.requestStoragePermissionApi19() {
    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    ActivityCompat.requestPermissions(
        this,
        permissions,
        READ_EXTERNAL_STORAGE_PERMISSION_REQUEST
    )
}
