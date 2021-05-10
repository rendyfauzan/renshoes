package com.example.sportshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_checkout.hargaOrder
import kotlinx.android.synthetic.main.activity_checkout.jmlOrder
import kotlinx.android.synthetic.main.activity_checkout.nameProduct
import kotlinx.android.synthetic.main.activity_checkout.totalOrder
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_receipt.*

class Checkout : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent

        val aProduct    =   intent.getStringExtra("name")
        val aPrice      =   intent.getIntExtra("price",0)
        val aQty        =   intent.getIntExtra("qty",0)
        val aTotal      =   intent.getIntExtra("tot",0)

        actionBar.setTitle("Pembayaran " +aProduct)

        nameProduct.text    = aProduct
        hargaOrder.text     = aPrice.toString()
        jmlOrder.text       = aQty.toString()
        totalOrder.text     = aTotal.toString()

        Bayar2.setOnClickListener {

            val intent = Intent(this, Receipt::class.java)

            intent.putExtra("pembeli", editNama.text.toString())
            intent.putExtra("noHp", editHp.text.toString())
            intent.putExtra("alamat", editAlamat.text.toString())
            intent.putExtra("name", aProduct)
            intent.putExtra("price", aPrice.toString().toInt())
            intent.putExtra("qty", jmlOrder.text.toString().toInt())
            intent.putExtra("tot", totalOrder.text.toString().toInt())

            startActivity(intent)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}