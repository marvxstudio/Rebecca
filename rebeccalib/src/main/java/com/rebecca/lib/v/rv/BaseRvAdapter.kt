package com.rebecca.lib.v.rv

abstract class BaseRvAdapter<VM : BaseRvVM> : BaseKtAdapter<VM>() {

    //=====================  ==========================
    protected lateinit var mlist: ArrayList<VM>

    //=====================  ==========================

    //=====================  ==========================

    //=====================  ==========================

    override fun update(list: ArrayList<VM>, isNotify: Boolean): BaseRvAdapter<VM> {
        this.mlist = list
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun clear(isNotify: Boolean): BaseRvAdapter<VM> {
        mlist.clear()
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun add(list: ArrayList<VM>, isNotify: Boolean): BaseRvAdapter<VM> {
        this.mlist.addAll(list)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun add(vm: VM, index: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        mlist.add(index, vm)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun remove(index: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        return this
    }

    override fun set(vm: VM, index: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        return this
    }

    override fun set(vm: VM, index: Int, type: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        return this
    }
    override fun removeType(type: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        return this
    }

    override fun getListSize(offset: Int): Int {
        return mlist.size + offset
    }

    //===================== init ========================
    fun getList(): ArrayList<VM> {
        return mlist
    }
    //===================== main ========================

    override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
        holder.updateVM(mlist.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return mlist.get(position).viewType
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}