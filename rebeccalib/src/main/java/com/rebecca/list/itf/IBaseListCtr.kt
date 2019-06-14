package com.rebecca.list.itf

interface IBaseListCtr<B> {

  fun outputList(): ArrayList<B>

  fun update(list: ArrayList<B>, index: Int = -1)

  fun update(list: ArrayList<B>, bean: B) {}

  fun output(): B? = null

  fun update(index: Int) {}

  fun output(index: Int): B? = null

}