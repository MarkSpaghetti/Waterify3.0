package com.project.waterify30;
import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static android.content.Context.MODE_PRIVATE;


import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.view.LayoutInflater;

import com.google.firebase.auth.FirebaseUser;

import java.io.File;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Logic {

    public void openActivity(Context fromActivity ,Class activityToOpen){
        Intent intent = new Intent( fromActivity, activityToOpen);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fromActivity.startActivity(intent);
    }

//    private val dbfriends = FirebaseDatabase.getInstance().getReference();
//    private val _result = MutableLiveData<Exception?>()
//    val result: LiveData<Exception?> get() = _result

    public void setImage(Context fromActivity, Class activityToOpen){
        Intent intent = new Intent();
    }

    public String ignoreEmail(FirebaseUser user){
        String email = user.getEmail();
        String username = "";
        for (char a:email.toCharArray() ) {
            if (a!='@'){
                username += a;
            }
            else return username;
        }
        return username;
    }

    public Bitmap getRoundedBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int radius = Math.min(width, height) / 2;

        Bitmap circularBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circularBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);

        return circularBitmap;
    }

}
