package com.paulaacs15.tienda

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigo = findViewById<EditText>(R.id.codPro)
        val nombre = findViewById<EditText>(R.id.nomPro)
        val precio = findViewById<EditText>(R.id.preProo)
        val registrar = findViewById<Button>(R.id.buttonRegistrar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        val editar = findViewById<Button>(R.id.buttonEditar)
        val eliminar = findViewById<Button>(R.id.buttonEliminar)

        registrar.setOnClickListener {
            val adminBD=admiSQL(this, "Store", null, 1)
            val bd=adminBD.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", codigo.text.toString().toInt())
            registro.put("nombre",nombre.text.toString())
            registro.put("precio", precio.text.toString())

            bd.insert("producto", null, registro)

            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")

            Toast.makeText(this, "¡Producto Registrado!", Toast.LENGTH_LONG).show()
        }

        consultar.setOnClickListener {
            val adminBD=admiSQL(this, "Store", null, 1)
            val bd=adminBD.writableDatabase

            val consulta = bd.rawQuery("selec nombre, precio  from producto where codigo = ${codigo.text.toString().toInt()}", null)

            if(consulta.moveToFirst()){
                nombre.setText(consulta.getString(0))
                precio.setText(consulta.getString(1))
            }else{
                Toast.makeText(this, "¡Producto No Encontrado!", Toast.LENGTH_LONG).show()
            }
            bd.close()
        }
        editar.setOnClickListener {
            val adminBD=admiSQL(this, "Store", null, 1)
            val bd=adminBD.writableDatabase

            val registro = ContentValues()
            registro.put("nombre",nombre.text.toString())
            registro.put("precio", precio.text.toString())

            val editar = bd.update("Producto", registro, "codigo=${codigo.text.toString()}", null)
            bd.close()

            if(editar==1){
                Toast.makeText(this,"¡Producto Actualizado!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"¡Producto No Actualizado!", Toast.LENGTH_LONG).show()
            }

        eliminar.setOnClickListener {
            val adminBD=admiSQL(this, "Store", null, 1)
            val bd=adminBD.writableDatabase

            val eliminar= bd.delete("Producto", "codigo=${codigo.text.toString()}", null)
            if(eliminar==1){
                Toast.makeText(this,"¡Producto Eliminado!", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"¡Producto No Existe!", Toast.LENGTH_LONG).show()
            }

            bd.close()
            codigo.setText("")
            nombre.setText("")
            precio.setText("")

        }

        }
    }
}