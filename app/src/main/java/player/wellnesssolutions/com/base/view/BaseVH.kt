package player.wellnesssolutions.com.base.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVH<M : Any>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var data: M? = null

    open fun bind(data: M) {
        this.data = data
    }

    open fun release() {
        data = null
    }
}