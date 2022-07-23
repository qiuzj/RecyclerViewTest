package com.example.recyclerviewtest

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits() // 初始化水果数据

        // LayoutManager用于指定RecyclerView的布局方式，这里使用的
        // LinearLayoutManager是线性布局的意思，可以实现和ListView类似的效果。
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.back_bg))
            fruitList.add(Fruit("Pear", R.drawable.kotlin_bean))
            fruitList.add(Fruit("Orange", R.drawable.title_bg))
        }
    }
}