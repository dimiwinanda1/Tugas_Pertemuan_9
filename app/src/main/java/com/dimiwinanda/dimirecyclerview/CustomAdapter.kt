//untuk mendeklarasikan package com.dimiwinanda.dimirecyclerview kita dapat menggunakan kata kunci package.
package com.dimiwinanda.dimirecyclerview

//kita dapat menggunakan deklarasi import untuk mengaktifkan compiler untuk menemukan class, function, interface atau object yang akan diimpor.

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

//kita perlu menerapkan Adapter dan ViewHolder, kedua class ini bekerja sama untuk menentukan cara data yang akan kita tampilkan. 
//ViewHolder merupakan wrapper di sekitar View yang berisi tata letak untuk setiap item dalam daftar. 
//sedangkan Adapter membuat objek ViewHolder seperlunya, serta menetapkan data untuk tampilan tersebut.

internal class CustomAdapter (private var itemsList: List<String>) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    //onCreateViewHolder(): RecyclerView berfungsi untuk memanggil method setiap kali kita perlu untuk membuat ViewHolder baru. 
    //Metode ini membuat serta menginisialisasi ViewHolder dan View-nya yang diatribusikan, 
    //tetapi tidak mengisi konten tampilan—ViewHolder belum terikat dengan data tertentu.
    
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    //onBindViewHolder(): RecyclerView berfungsi untuk memanggil metode ini untuk kemudian mengatribusikan ViewHolder dengan data. 
    //Metode ini mengambil data yang sesuai dan menggunakan data tersebut untuk mengisi tata letak pemegang tampilan. 
    //Misalnya, jika RecyclerView menampilkan daftar nama, metode tersebut mungkin menemukan nama yang sesuai di dalam daftar dan mengisi widget TextView pemegang tampilan.
    
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
    }

    //getItemCount(): RecyclerView berfungsi untuk memanggil metode ini untuk mendapatkan ukuran set data. 
    //RecyclerView menggunakan ukuran ini untuk menentukan bahwa tidak ada lagi item yang dapat ditampilkan.
    override fun getItemCount(): Int {
        return itemsList.size
    }
}
