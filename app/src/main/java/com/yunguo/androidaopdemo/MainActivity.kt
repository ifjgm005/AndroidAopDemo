package com.yunguo.androidaopdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var TAG="MainActivity"
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.btn_add)
        var textView=findViewById<TextView>(R.id.textView)
        var animal = Animal()
        button.setOnClickListener {
            Log.d(TAG, " onCreate fly start...");
            animal.fly();
            Log.d(TAG, " onCreate finish...");
        }

        textView.setOnLongClickListener{
            Log.d(TAG, " hello world is clicked...")
            true
        }


        animal.run(100);

        animal.getName("zhangsannnnnn");
        val sp: SharedPreferences =
            this.getSharedPreferences("SP", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putString("update_time", "2022-08-23")
        editor.commit()
//        animal.setAge(10);
    }
}