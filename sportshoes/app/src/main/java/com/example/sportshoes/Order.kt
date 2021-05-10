package com.example.sportshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_order.imgProduct
import kotlinx.android.synthetic.main.activity_product.*

class Order : AppCompatActivity() {

    var totHarga:Int = 0
    var minteger:Int = 0
    var MIN_NUMBER = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent      = intent

        //pProduct, pPrice dan pImg diperoleh dari putExtra pada file
        //ProductAdapter.kt
        val aProduct    = intent.getStringExtra("pProduct")
        val aPrice      = intent.getIntExtra("pPrice", 0)
        val aImg        = intent.getIntExtra("pImg", 0)


        actionBar.setTitle("Order " +aProduct)
        //id pada activity_order.xml
        namaMenu.text     = aProduct
        hargaOrder.text       = aPrice.toString()
        imgProduct.setImageResource(aImg)


        fun display(number: Int) {
            val displayInteger = findViewById<View>(R.id.jmlOrder) as TextView

            displayInteger.text = "" + number

            totHarga = hargaOrder.text.toString().toInt() *
                    displayInteger.text.toString().toInt()
            totalOrder.text = totHarga.toString()
        }

        decreaseOrd.setOnClickListener(){
            if(minteger == MIN_NUMBER){
                minteger = 0
            }
            else{
                minteger = minteger - 1
                display(minteger)
            }
        }

        increaseOrd.setOnClickListener(){
            minteger = minteger + 1
            display(minteger)
        }


        OrderLagi.setOnClickListener {
            onBackPressed()
        }

        Bayar.setOnClickListener {

            val intent = Intent(this, Checkout::class.java)
            intent.putExtra("name", aProduct)
            intent.putExtra("price", aPrice.toString().toInt())
            intent.putExtra("qty", jmlOrder.text.toString().toInt())
            intent.putExtra("tot", totHarga.toString().toInt())

            startActivity(intent)
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
