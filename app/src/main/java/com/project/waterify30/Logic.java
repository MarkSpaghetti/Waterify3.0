package com.project.waterify30;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

public class Logic {


    public void openActivity(Context fromContext, Class<?> activityToOpen) {
        Intent intent = new Intent(fromContext, activityToOpen);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        fromContext.startActivity(intent);
    }


    public String ignoreEmail(FirebaseUser user) {
        String email = user.getEmail();
        String username = "";
        for (char a : email.toCharArray()) {
            if (a != '@') {
                username += a;
            } else return username;
        }
        return username;
    }


    public void setClickListener(Button button, int cupSize, String toastMessage, Context fromActivity) {
        button.setOnClickListener(v -> {
            MainActivity.cup = cupSize;
            Toast.makeText(fromActivity, toastMessage, Toast.LENGTH_LONG).show();
            openActivity(fromActivity, Homepage.class);
        });
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
