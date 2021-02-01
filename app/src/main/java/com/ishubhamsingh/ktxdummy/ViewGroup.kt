package com.ishubhamsingh.ktxdummy

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*

/**
 * Created by Shubham Singh on 1/2/21.
 */
class ViewGroup: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arrayList = arrayListOf(1,2,3) + arrayListOf(4,5,6)

        var newArrayList = arrayList + 7 + 8 + 9  // will add items to the list

        newArrayList = newArrayList - 9 - 8 - 7 - 6 - 5 // will remove items from the list

        val (a,b,c,d) = newArrayList // destructuring

        newArrayList.getOrNull(1) // will return value or null
        newArrayList.getOrElse(1) {8} // will return value or default value

        newArrayList.takeIf { it.isNotEmpty() }?.apply { this[0] }
        newArrayList.takeUnless { it.isEmpty() }?.apply { this[0] }

        newArrayList = newArrayList.sortedDescending()
        newArrayList = newArrayList.sorted()


        val viewGroup = LinearLayout(this)

        val view1 = View(this)
        val view2 = View(this)

        viewGroup.addView(view1)
        viewGroup.addView(view2)

        viewGroup += view1
        viewGroup += view2

        viewGroup.contains(view1)
        viewGroup.contains(view2)

        view1 in viewGroup
        view2 in viewGroup

        viewGroup[0]
        viewGroup[1]

        viewGroup.forEachIndexed { index, view ->

        }

        viewGroup.forEach {

        }

        viewGroup.size
        viewGroup.isEmpty()
        viewGroup.isNotEmpty()

        viewGroup.removeView(view1)
        viewGroup.removeView(view2)

        viewGroup -= view1
        viewGroup -= view2

    }

}