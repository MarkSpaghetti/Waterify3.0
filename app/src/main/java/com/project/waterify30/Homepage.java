package com.project.waterify30;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Homepage extends AppCompatActivity {

    private final Logic logic = new Logic();

    private ImageButton buttonProfile, homepagePlant;
    private Bitmap originalBitmap;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ImageButton buttonStatistics, buttonSocials, buttonStore, buttonDrops;

        homepagePlant = findViewById(R.id.homepage_plant);
        loadPlantIfThere();

        buttonProfile = findViewById(R.id.button_profile);
        loadImageIfThere();

        buttonProfile.setOnClickListener(v -> logic.openActivity(Homepage.this, Profile.class));

        buttonStore = findViewById(R.id.shop_button);
        buttonStore.setOnClickListener(v-> logic.openActivity(Homepage.this, Shop.class));

        homepagePlant.setOnClickListener(v -> logic.openActivity(Homepage.this, UserGarden.class));

        buttonStatistics = findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(v-> logic.openActivity(Homepage.this, Statistics.class));

        buttonDrops = findViewById(R.id.button_drops);
        buttonDrops.setOnClickListener(v-> logic.openActivity(Homepage.this, Cups.class));

        buttonSocials = findViewById(R.id.socials_button);
        buttonSocials.setOnClickListener(v-> logic.openActivity(Homepage.this, userlist.class));

    }

    public void buttonPopUpWindow(View view) {
        View viewPopUpWindow = set();
        final PopupWindow popupWindow = new PopupWindow(viewPopUpWindow, 900, 900, false);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //close pop-up
        viewPopUpWindow.setOnClickListener(v -> {
            popupWindow.dismiss();
            logic.openActivity(Homepage.this, Homepage.class);
        });
    }

    public View set() {
        PopUpWindow_coins pop = new PopUpWindow_coins();
        setContentView(R.layout.activity_homepage);
        ConstraintLayout mainLayout = findViewById(R.id.pop_up_window_coins);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.activity_pop_up_window_coins, mainLayout, false);

        // make changes to our custom layout and its subviews
        TextView txtLevel =  myLayout.findViewById(R.id.textView_level);
        txtLevel.setText(getString(R.string.level_text, pop.getLevel()));
        TextView txt_droplets = myLayout.findViewById(R.id.textView_droplets);
        txt_droplets.setText(getString(R.string.droplets_text, pop.getDroplets()));
        return myLayout;
    }

    public void quiz(View view) {
        int[] q = {R.layout.quizz, R.layout.quizz_1, R.layout.quizz_2, R.layout.quizz_3, R.layout.quizz_4};
        int min = 0;
        int max = 3;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);


        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopUpWindow = layoutInflater.inflate(q[randomNum], null);
        final PopupWindow popupWindow = new PopupWindow(viewPopUpWindow, 900, 900, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //Answers
        PopUpWindow_coins pop = new PopUpWindow_coins();
        Button yes = viewPopUpWindow.findViewById(R.id.yes);
        Button no1 = viewPopUpWindow.findViewById(R.id.no1);
        Button no2 = viewPopUpWindow.findViewById(R.id.no2);
        Button no3 = viewPopUpWindow.findViewById(R.id.no3);

        yes.setOnClickListener(v -> {
                pop.addDroplets(10);
                Toast.makeText(getApplicationContext(), "Hurray!, you are correct. You have earned 10 droplets", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            });
        no1.setOnClickListener(v-> {
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            });

        no2.setOnClickListener(v-> {
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            });

        no3.setOnClickListener(v->{
                Toast.makeText(getApplicationContext(), "Sorry, your answer was wrong", Toast.LENGTH_LONG).show();
                popupWindow.dismiss();
            });

    }

    public void loadPlantIfThere() {
        int defaultPlantResource = R.drawable.plant_10; // Default plant resource if none is saved

        // Load homepagePlant from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("prefs_homepage", MODE_PRIVATE);
        int homepagePlantResource = preferences.getInt("homepage_plant", 0);

        if (homepagePlantResource != 0) {
            // Set the saved plant resource in the ImageView
            this.homepagePlant.setImageResource(homepagePlantResource);
        } else {
            // If no saved plant resource, set the default plant resource
            this.homepagePlant.setImageResource(defaultPlantResource);
        }
    }




    public void loadImageIfThere() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        this.imagePath = sharedPreferences.getString("imagePath", null);
        if (this.imagePath != null) {
            File file = new File(this.imagePath);
            if (file.exists()) {
                this.originalBitmap = BitmapFactory.decodeFile(this.imagePath); // Load the original bitmap
                Bitmap circularBitmap = logic.getRoundedBitmap(this.originalBitmap);
                buttonProfile.setImageBitmap(circularBitmap);
            }
        }
    }


}