package com.github.ilikeyourhat.lsaa.util.android

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.os.Build

public fun PackageManager.getApplicationInfoCompat(
    packageName: String,
    flags: Int
): ApplicationInfo {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(flags.toLong()))
    } else {
        @Suppress("DEPRECATION")
        getApplicationInfo(packageName, PackageManager.GET_META_DATA)
    }
}
