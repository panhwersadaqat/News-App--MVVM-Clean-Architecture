package com.example.newsappmvvmexample.presenter.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappmvvmexample.data.model.APIResponse
import com.example.newsappmvvmexample.data.util.Resource
import com.example.newsappmvvmexample.domain.usecases.GetNewsHeadlinesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by Sadaqat Panhwer
 * https://panhwersadaqat.github.io/
 * on 1/4/22.
 */

class NewsViewModel (
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase): AndroidViewModel(app) {
    val newsHeadlines : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
       try {

           newsHeadlines.postValue(Resource.Loading())

           if (isNetworkAvailable(app)) {
               newsHeadlines.postValue(Resource.Loading())
               val apiResult = getNewsHeadlinesUseCase.execute(country, page)
               newsHeadlines.postValue(apiResult)
           } else {
               newsHeadlines.postValue(Resource.Error("Internet is not available"))
           }
       }catch (e: Exception) {
           newsHeadlines.postValue(Resource.Error(e.message.toString()))
       }

    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }
}