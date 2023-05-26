package com.project.waterify30;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Logic {

    void openActivity(Context fromActivity ,Class activityToOpen){
        Intent intent = new Intent( fromActivity, activityToOpen);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fromActivity.startActivity(intent);
    }

//    private val dbfriends = FirebaseDatabase.getInstance().getReference();
//    private val _result = MutableLiveData<Exception?>()
//    val result: LiveData<Exception?> get() = _result





}
