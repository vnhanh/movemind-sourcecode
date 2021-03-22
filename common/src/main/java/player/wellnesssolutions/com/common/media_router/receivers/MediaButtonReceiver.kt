/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package player.wellnesssolutions.com.common.media_router.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Broadcast receiver for handling ACTION_MEDIA_BUTTON.
 *
 * This is needed to create the RemoteControlClient for controlling
 * remote route volume in lock screen. It routes media key events back
 * to main app activity MainActivity.
 */
class MediaButtonReceiver : BroadcastReceiver() {

    override fun onReceive(context : Context, intent : Intent) {
        if (mActivity != null && Intent.ACTION_MEDIA_BUTTON == intent.action) {
            //            mActivity.handleMediaKey(
            //                    (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT));
        }
    }

    companion object {
        private val TAG = "SampleMediaButtonReceiver"
        private var mActivity : AppCompatActivity? = null

        fun setActivity(activity : AppCompatActivity?) {
            mActivity = activity
        }
    }
}
