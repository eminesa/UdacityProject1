package com.eminesa.udacityproject1.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eminesa.udacityproject1.models.Shoe

@Suppress("DEPRECATION")
class ShoeViewModel: ViewModel() {

    private var liveList: LiveData<MutableList<Shoe>>
    private var liveUpdate: MutableLiveData<Shoe>
    private var liveStandBy: MutableLiveData<Boolean>
    private val mutableList = mutableListOf<Shoe>()

    init {
        liveList = MutableLiveData()
        liveUpdate = MutableLiveData()
        liveStandBy = MutableLiveData()
    }

    @Deprecated("For Static Data")
    fun setItems() : MutableList<Shoe>{

        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        mutableList.add( Shoe("deneme", 40.0, "Company Name", "Description Denemeee"))
        return mutableList
    }

    fun getItems() : LiveData<MutableList<Shoe>> {
       liveList=   MutableLiveData(setItems())
        return liveList
    }

}
