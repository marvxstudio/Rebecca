package com.rebecca.list.itf

interface IBaseListCtr<B> {

  fun update(list: ArrayList<B>, index: Int = -1)

  fun outputList(): ArrayList<B>

  fun output(): B? = null

  fun output(index: Int): B? = null

}