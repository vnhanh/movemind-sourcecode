package player.wellnesssolutions.com.ui.fragment_time_table.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import player.wellnesssolutions.com.R
import player.wellnesssolutions.com.network.models.response.SessionVideo

class SchedulerAdapter(private var listener: OnClickItemListener?) : RecyclerView.Adapter<SchedulerItemVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchedulerItemVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_timetable, parent, false)

        return SchedulerItemVH(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SchedulerItemVH, position: Int) {
        if (position < 0 || position >= list.size) return
        holder.bind(list[position])
    }

    private var list = ArrayList<SessionVideo>()


    fun setList(_list: ArrayList<SessionVideo>) {
        list = _list
        notifyDataSetChanged()
    }

    fun release() {
        listener = null
    }

    interface OnClickItemListener {
        fun onClick(item: SessionVideo)
    }
}