package com.example.sportshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_checkout.hargaOrder
import kotlinx.android.synthetic.main.activity_checkout.jmlOrder
import kotlinx.android.synthetic.main.activity_checkout.nameProduct
import kotlinx.android.synthetic.main.activity_checkout.totalOrder
import kotlinx.android.synthetic.main.activity_receipt.*

class Receipt : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent

        var aPembeli    =   intent.getStringExtra("pembeli")
        val aNoHp       =   intent.getStringExtra("noHp")
        val aAlamat     =   intent.getStringExtra("alamat")
        val aProduct    =   intent.getStringExtra("name")
        val aPrice      =   intent.getIntExtra("price",0)
        val aQty        =   intent.getIntExtra("qty",0)
        val aTotal      =   intent.getIntExtra("tot",0)

        actionBar.setTitle("Receipt " +aPembeli)

        editNama1.text    = aPembeli
        editHp1.text         = aNoHp.toString()
        editAlamat1.text     = aAlamat
        nameProduct.text    = aProduct
        hargaOrder.text     = aPrice.toString()
        jmlOrder.text       = aQty.toString()
        totalOrder.text     = aTotal.toString()

        back.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            true
        }
        cetak.setOnClickListener {
            Toast.makeText(this,"Cetak Struk", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}