package com.example.practicals.web_services.Interface

import com.example.practicals.utils.Constants.BASE_URL
import com.example.practicals.utils.Constants.END_URL
import com.example.practicals.utils.Constants.END_USER_URL
import com.example.practicals.web_services.AddUserData
import com.example.practicals.web_services.DataClass
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface UserInterface {
    @GET(END_URL)
    fun getData(): retrofit2.Call<DataClass>

    @FormUrlEncoded
    @POST(END_USER_URL)
    fun addUserData(@Field("name") name: String,@Field("job") job: String): retrofit2.Call<AddUserData>

    companion object {
        
        fun retrofitObject(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
