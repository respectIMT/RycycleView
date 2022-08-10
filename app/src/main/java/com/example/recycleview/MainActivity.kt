package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recycleview.adapter.RvAdapter
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list:ArrayList<String>
    private lateinit var rvAdapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        rvAdapter = RvAdapter(this, list, object : RvAdapter.RvAction {
            override fun delateItem(position: Int, str: String) {
                list.remove(str)
                rvAdapter.notifyItemRemoved(position)
            }

        })
        binding.rv.adapter = rvAdapter
    }

    private fun loadData(){
        list = ArrayList()

        binding.apply {
            btnSave.setOnClickListener{
                val s = edt1.text.toString()
                list.add(s)
                rvAdapter.notifyItemInserted(list.size-1)
                Toast.makeText(this@MainActivity, "$s qo'shildi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}