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

package player.wellnesssolutions.com.common.media_router.models

import android.app.PendingIntent
import android.net.Uri
import android.os.SystemClock
import androidx.mediarouter.media.MediaItemStatus

/**
 * PlaylistItem helps keep track of the current status of an media item.
 */
class PlaylistItem(// immutables
        val sessionId: String? = null, val itemId: String? = null, val uri: Uri? = null,
        private val mMime: String? = null, val updateReceiver: PendingIntent? = null) {
    // changeable states
    var state = MediaItemStatus.PLAYBACK_STATE_PENDING
    var position: Long = 0
    var duration: Long = 0
    var timestamp: Long = 0
    var remoteItemId: String? = null

    val status: MediaItemStatus
        get() = MediaItemStatus.Builder(state)
                .setContentPosition(position)
                .setContentDuration(duration)
                .setTimestamp(timestamp)
                .build()

    init {
        timestamp = SystemClock.elapsedRealtime()
    }

    override fun toString(): String {
        val state = arrayOf("PENDING", "PLAYING", "PAUSED", "BUFFERING", "FINISHED", "CANCELED", "INVALIDATED", "ERROR")
        return ("[" + sessionId + "|" + itemId + "|"
                + (if (remoteItemId != null) remoteItemId else "-") + "|"
                + state[this.state] + "] " + uri.toString())
    }
}
