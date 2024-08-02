package com.example.imagelocker.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagelocker.data.response.ResultDocument
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LockerViewModel: ViewModel() {
    private val _lockerList = MutableStateFlow<ArrayList<ResultDocument>>(arrayListOf())
    val lockerList: StateFlow<ArrayList<ResultDocument>> = _lockerList.asStateFlow()

    private val _isLoading = MutableStateFlow<Boolean?>(null)
    val isLoading: StateFlow<Boolean?> = _isLoading.asStateFlow()

    fun getData(sp: SharedPreferences) {
        viewModelScope.launch {
            val resultList: ArrayList<ResultDocument>
            val ref = sp.getString("items", "none")

            _isLoading.value = false
            if (ref != "none" && ref != "[]") {
                resultList = GsonBuilder().create().fromJson(ref, object: TypeToken<ArrayList<ResultDocument>>() {}.type)
                _lockerList.value.clear()
                _lockerList.value = resultList
                _isLoading.value = true
            } else {
                _lockerList.value = arrayListOf()
                _isLoading.value = true
            }
        }
    }

    fun addData(addDocument: ResultDocument, sp: SharedPreferences) {
        viewModelScope.launch {
            val resultList: ArrayList<ResultDocument>
            val ref = sp.getString("items", "none")
            val gson = GsonBuilder().create()

            with(sp.edit()) {
                if (ref == "none") {
                    val initList = arrayListOf<ResultDocument>()
                    initList.add(addDocument)

                    val stringJson = gson.toJson(initList, object: TypeToken<ArrayList<ResultDocument>>() {}.type)
                    putString("items", stringJson)
                } else {
                    resultList = gson.fromJson(ref, object: TypeToken<ArrayList<ResultDocument>>() {}.type)
                    resultList.add(addDocument)

                    val stringRef = gson.toJson(
                        resultList,
                        object: TypeToken<ArrayList<ResultDocument>>() {}.type
                    )
                    putString("items", stringRef)
                }

                apply()
            }
        }
    }

    fun removeData(removeDocument: ResultDocument, sp: SharedPreferences) {
        var currentList: ArrayList<ResultDocument>
        val gson = GsonBuilder().create()
        val ref = sp.getString("items", "none")

        viewModelScope.launch {
            with(sp.edit()) {
                if (ref != "none" && ref != "[]") {
                    currentList = gson.fromJson(ref, object: TypeToken<ArrayList<ResultDocument>>() {}.type)
                    currentList.removeIf { it.id == removeDocument.id }

                    val stringRef = gson.toJson(
                        currentList,
                        object: TypeToken<ArrayList<ResultDocument>>() {}.type
                    )
                    putString("items", stringRef)

                    _lockerList.value = currentList
                }

                apply()
            }
        }
    }
}