package com.example.sportshoes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDrawerView: NavigationView

    private lateinit var bottomNavigation : BottomNavigationView
    var myAdapter : ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<ProductModel>()
        arrayItem.add(ProductModel("Adidas","Adidas cocok untuk pergi hangout",R.drawable.adidas,500000))
        arrayItem.add(ProductModel("Brodo","Brodo merupakan brand terbaru dari Eropa",R.drawable.brodo,650000))
        arrayItem.add(ProductModel("Convers","Convers adalah sepatu andalan anak muda",R.drawable.convers,300000))
        arrayItem.add(ProductModel("Diadora","Diadora bukan sepatunya Dora",R.drawable.diadora,400000))
        arrayItem.add(ProductModel("League","League? Lo aja kali, gue enggak...",R.drawable.league,450000))
        arrayItem.add(ProductModel("New Balance","New Balance cocok untuk anak nongkrong",R.drawable.newbalance,355000))
        arrayItem.add(ProductModel("Nike","Nike adalah sepatu sejuta umat manusia",R.drawable.nike,525000))
        arrayItem.add(ProductModel("Puma","Puma dengan logo macan yang berwibawa",R.drawable.puma,475000))
        arrayItem.add(ProductModel("Rebook","Rebook sepatu andalan masa lalu",R.drawable.rebook,455000))
        arrayItem.add(ProductModel("Vans","Vans idola para remaja",R.drawable.vans,475000))
        arrayItem.add(ProductModel("Wakai","Wakai adalah product dari jepang",R.drawable.wakai,275000))

        myAdapter = ProductAdapter(this)
        myAdapter!!.setData(arrayItem)

        // product_recyclerView
        Product_RecycleView.layoutManager = LinearLayoutManager(this)
        Product_RecycleView.adapter = myAdapter
        //end product item

        //start bottom navigation
        bottomNavigation = findViewById(R.id.navBottom)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                    true
                }
                R.id.history -> {
                    Toast.makeText(this,"Go to history transaction",Toast.LENGTH_SHORT)
                    true
                }
                else ->{
                    false
                }
            }

        }
        //end bottom navigation


        drawerLayout = findViewById(R.id.drawer)
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)

        drawerLayout.addDrawerListener(actionBarToggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()
        navDrawerView = findViewById(R.id.navDrawer)

        navDrawerView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.myProfile -> {
                   val intent = Intent(applicationContext, Profile::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myContact -> {
                    Toast.makeText(this, "Go to my Contact", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myHelp -> {
                    Toast.makeText(this, "Go to our Help", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem = menu?.findItem(R.id.search)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.maxWidth = Int.MAX_VALUE
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(filterString: String?): Boolean {
                    myAdapter!!.filter.filter(filterString)
                    return true
                }
            })

        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.cart) {
            Toast.makeText(this, "View Shopping Cart", Toast.LENGTH_SHORT).show()
            return true
        }else if(id == R.id.search) {
            Toast.makeText(this, "View Search", Toast.LENGTH_SHORT).show()
            return true
        }else if(id==R.id.account){
            Toast.makeText(this, "Ini Akun loe", Toast.LENGTH_SHORT).show()
            return true
        }else if(id==R.id.logout) {

            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            true
        }
        return super.onOptionsItemSelected(item)
    }


}