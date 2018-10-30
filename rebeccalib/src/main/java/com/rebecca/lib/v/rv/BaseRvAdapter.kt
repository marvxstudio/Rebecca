package com.rebecca.lib.v.rv

abstract class BaseRvAdapter<VM : BaseRvVM> : BaseKtAdapter<VM>() {

    //=====================  ==========================
    protected lateinit var list: ArrayList<VM>

    //=====================  ==========================

    //=====================  ==========================

    //=====================  ==========================

    override fun update(list: ArrayList<VM>, isNotify: Boolean): BaseRvAdapter<VM> {
        this.list = list
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun clear(isNotify: Boolean): BaseRvAdapter<VM> {
        list.clear()
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun add(list: ArrayList<VM>, isNotify: Boolean): BaseRvAdapter<VM> {
        this.list.addAll(list)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun add(vm: VM, index: Int, isNotify: Boolean): BaseRvAdapter<VM> {
        list.add(index, vm)
        if (isNotify) {
            notifyDataSetChanged()
        }
        return this
    }

    override fun getListSize(offset: Int): Int {
        return list.size + offset
    }

    //===================== init ========================

    //===================== main ========================

    override fun onBindViewHolder(holder: BaseRvVH<*, VM>, position: Int) {
        holder.updateVM(list.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return list.get(position).viewType
    }

    override fun getItemCount(): Int {
        return list.size
    }
}