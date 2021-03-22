package player.wellnesssolutions.com.base.uis

import java.lang.ref.WeakReference

abstract class BaseClickableAdapter<VH : BaseVH<M>, T : Any, M : Any>(listener: T?, var list: ArrayList<M>) : androidx.recyclerview.widget.RecyclerView.Adapter<VH>() {
    protected var weakPresenter: WeakReference<T?>
    protected var mHolders: ArrayList<VH>? = ArrayList()

    protected var presenter: T?
        set(value) {
            weakPresenter = WeakReference(value)
        }
        get() = weakPresenter.get()

    init {
        weakPresenter = WeakReference(listener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(list[position])
    }

    open fun release() {
        weakPresenter.clear()
        mHolders?.also { holders ->
            while (holders.size > 0) {
                holders[0].release()
                holders.removeAt(0)
            }
        }
        mHolders = null
    }
}