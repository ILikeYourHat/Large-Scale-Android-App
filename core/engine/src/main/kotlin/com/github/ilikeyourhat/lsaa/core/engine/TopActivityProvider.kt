package com.github.ilikeyourhat.lsaa.core.engine

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.Looper
import androidx.annotation.AnyThread
import androidx.annotation.MainThread

public class TopActivityProvider(
    private val isMainThread: () -> Boolean = { Looper.getMainLooper() == Looper.myLooper() }
) {

    private val pendingActions = mutableListOf<(Activity) -> Unit>()

    private var topActivity: Activity? = null
        private set(activity) {
            field = activity
            executePendingActions()
        }

    @AnyThread
    public fun onTopActivity(action: (Activity) -> Unit) {
        val topActivity = topActivity

        if (topActivity == null) {
            addPendingAction(action)
        } else {
            if (isMainThread()) {
                action(topActivity)
            } else {
                addPendingAction(action)
                topActivity.runOnUiThread { executePendingActions() }
            }
        }
    }

    internal fun attach(app: Application) {
        app.registerActivityLifecycleCallbacks(callbacks)
    }

    @MainThread
    private fun executePendingActions() {
        val activity = topActivity ?: return

        val actionsToExecute: List<(Activity) -> Unit>
        synchronized(pendingActions) {
            actionsToExecute = ArrayList(pendingActions) // immutable copy
            pendingActions.clear()
        }

        actionsToExecute.forEach { it(activity) }
    }

    @AnyThread
    private fun addPendingAction(action: (Activity) -> Unit) {
        synchronized(pendingActions) {
            pendingActions.add(action)
        }
    }

    private val callbacks = object : Application.ActivityLifecycleCallbacks {

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            topActivity = activity
        }

        override fun onActivityStarted(activity: Activity) {
            topActivity = activity
        }

        override fun onActivityResumed(activity: Activity) {
            topActivity = activity
        }

        override fun onActivityPaused(activity: Activity) {
            topActivity = null
        }

        override fun onActivityStopped(activity: Activity) {
            // noop
        }

        override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
            // noop
        }

        override fun onActivityDestroyed(activity: Activity) {
            // noop
        }
    }
}
