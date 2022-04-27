//untuk mendeklarasikan package com.dimiwinanda.dimirecyclerview kita dapat menggunakan kata kunci package.
package com.dimiwinanda.dimirecyclerview

//kita dapat menggunakan deklarasi import untuk mengaktifkan compiler untuk menemukan class, function, interface atau object yang akan diimpor.
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//Class MainActivity merupakan turunan dari Class AppCompatActivity dan mengimplementasikan Interface View.
class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    //onCreate() adalah kondisi awal saat Activity baru diciptakan, disin dilakukan inisialisasi.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Dimi RecyclerView"
        
        //RecyclerView meminta tampilan tersebut, dan mengikat tampilan ke data, dengan memanggil metode di adaptor. 
        //dalam file layout aktivitas akan berfungsi sebagai kontainer tampilan.
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        
        //Instance dari RecyclerView.LayoutManager untuk menyusun layout item dalam RecyclerView. 
        //Pengelola layout ini berfungsi untuk mengelola susunan item daftar di dalamnya. 
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }
    private fun prepareItems() {
        itemsList.add("Item 1")
        itemsList.add("Item 2")
        itemsList.add("Item 3")
        itemsList.add("Item 4")
        itemsList.add("Item 5")
        itemsList.add("Item 6")
        itemsList.add("Item 7")
        itemsList.add("Item 8")
        itemsList.add("Item 9")
        itemsList.add("Item 10")
        itemsList.add("Item 11")
        itemsList.add("Item 12")
        itemsList.add("Item 13")
        customAdapter.notifyDataSetChanged()
    }
}
