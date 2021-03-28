package player.wellnesssolutions.com.base.view

abstract class BaseClickableAdapter<VH : BaseVH<M>, T : Any, M : Any>(protected var listener: T?, var list: ArrayList<M>) : androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {
    protected var mHolders: ArrayList<VH>? = ArrayList()


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

    open fun release() {
        listener = null
        mHolders?.also { holders ->
            while (holders.size > 0) {
                holders[0].release()
                holders.removeAt(0)
            }
        }
        mHolders = null
    }
}