package com.example.recyclerviewtest

import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits() // 初始化水果数据

//        // LayoutManager用于指定RecyclerView的布局方式，这里使用的
//        // LinearLayoutManager是线性布局的意思，可以实现和ListView类似的效果。
//        val layoutManager = LinearLayoutManager(this)
//
//        // 默认是纵向排列的，我们传入LinearLayoutManager.HORIZONTAL
//        // 表示让布局「横行排列」，这样RecyclerView就可以横向滚动了
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        // 瀑布流
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = layoutManager

        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        // 垂直和水平列表使用
//        repeat(2) {
//            fruitList.add(Fruit("Apple", R.drawable.back_bg))
//            fruitList.add(Fruit("Pear", R.drawable.kotlin_bean))
//            fruitList.add(Fruit("Orange", R.drawable.title_bg))
//        }

        // 瀑布流使用
        repeat(6) {
            fruitList.add(Fruit(getRandomLengthString("Apple"), R.drawable.back_bg))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.kotlin_bean))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.title_bg))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..50).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}