package com.paulaacs15.tienda
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper

class admiSQL (contexto:Context, nombre:String, cursor:CursorFactory?, version:Int): SQLiteOpenHelper(contexto,nombre,cursor,version){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Producto(codigo int primary key, nombre text, precio real)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}