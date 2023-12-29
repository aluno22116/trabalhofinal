package com.example.trabalhofinal

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CriarNotas : AppCompatActivity() {
    private var dbHelper: BDNotas? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criarnotas)

        dbHelper = BDNotas(this)
        val editTextNote = findViewById<EditText>(R.id.editarTexto)
        val btnSave = findViewById<Button>(R.id.btnSalvar)
        btnSave.setOnClickListener { view: View? ->
            salvarNotaNoBancoDeDados(
                editTextNote.text.toString()
            )
        }
    }

    private fun salvarNotaNoBancoDeDados(nota: String) {
        val db = dbHelper!!.writableDatabase
        val values = ContentValues()
        values.put(BDNotas.COLUMN_NOTE, nota)
        val newRowId = db.insert(BDNotas.TABLE_NOTES, null, values)
        if (newRowId != -1L) {
            Toast.makeText(this, "Nota salva com sucesso!", Toast.LENGTH_SHORT).show()
            abrirBNotas(this)
        } else {
            Toast.makeText(this, "Erro ao salvar nota.", Toast.LENGTH_SHORT).show()
        }
    }
}
private fun abrirBNotas(context: Context) {
    val intent = Intent(context, Bnotas::class.java)
    context.startActivity(intent)
}