package com.project.waterify30;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class Logic {

    void openActivity(Context fromActivity ,Class activityToOpen){
        Intent intent = new Intent( fromActivity, activityToOpen);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fromActivity.startActivity(intent);
    }


}
