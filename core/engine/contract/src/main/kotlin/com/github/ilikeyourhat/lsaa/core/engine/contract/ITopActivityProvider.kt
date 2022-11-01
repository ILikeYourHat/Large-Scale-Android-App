package com.github.ilikeyourhat.lsaa.core.engine.contract

import android.app.Activity
import androidx.annotation.AnyThread

public interface ITopActivityProvider {
    @AnyThread
    public fun onTopActivity(action: (Activity) -> Unit)
}
