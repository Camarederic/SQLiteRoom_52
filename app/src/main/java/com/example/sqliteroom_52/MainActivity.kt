package com.example.sqliteroom_52

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.sqliteroom_52.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = MainDatabase.getDatabase(this)

        database.getDao().getAllItem().asLiveData().observe(this){ list ->
            binding.textViewList.text = ""
            list.forEach{
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price}\n"
                binding.textViewList.append(text)
            }
        }

        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val price = binding.editTextPrice.text.toString()
            val item = Item(null, name, price)

            Thread{
                database.getDao().insertItem(item)
            }.start()


        }
    }
}