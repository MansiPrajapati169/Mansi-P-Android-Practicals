package com.example.practicals.recycler_list_practicals.DataClass

import android.text.style.UpdateAppearance
import android.widget.ImageView

data class Details (var selected: Boolean = false, var title: String? = null , var subTitle: String? = null, var image: Int? = 0 ,
                    var name : String? = null , var realName : String? = null , var team : String? = null, var firstAppearance : String? = null, var exapndable : Boolean = false)