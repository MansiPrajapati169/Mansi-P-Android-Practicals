package com.example.practicals.recycler_list_practicals.DataClass

import android.text.style.UpdateAppearance
import android.widget.ImageView
import com.example.practicals.R

data class Details (var selected: Boolean = false, var title: String? = null , var subTitle: String? = null, var image: Int? = 0 ,
                    var name : String? = null , var realName : String? = null , var team : String? = null, var firstAppearance : String? = null, var exapndable : Boolean = false) {
    companion object {
        fun getRecyclerData(titleArray: Array<String>): ArrayList<Details> {
           return arrayListOf(
                Details(title = titleArray[0], image = R.drawable.img),
                Details(title = titleArray[1], image = R.drawable.img),
                Details(title = titleArray[2], image = R.drawable.img),
                Details(title = titleArray[3], image = R.drawable.img),
                Details(title = titleArray[0], image = R.drawable.img),
                Details(title = titleArray[1], image = R.drawable.img),
                Details(title = titleArray[2], image = R.drawable.img),
                Details(title = titleArray[3], image = R.drawable.img),
                Details(title = titleArray[0], image = R.drawable.img),
                Details(title = titleArray[1], image = R.drawable.img),
                Details(title = titleArray[2], image = R.drawable.img),
                Details(title = titleArray[3], image = R.drawable.img))
        }

        fun getListData(titleArray: Array<String>, subTitleArray: Array<String>): Array<Details> {
            return arrayOf(
                Details(title = titleArray[0], subTitle = subTitleArray[0], image = R.drawable.img),
                Details(title = titleArray[1], subTitle = subTitleArray[1], image = R.drawable.img),
                Details(title = titleArray[2], subTitle = subTitleArray[2], image = R.drawable.img),
                Details(title = titleArray[3], subTitle = subTitleArray[3], image = R.drawable.img))
        }
    }
}