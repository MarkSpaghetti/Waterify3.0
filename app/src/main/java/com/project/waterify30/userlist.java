package com.project.waterify30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {

    Button buttonRequest;
    ImageButton buttonStatistics, buttonHome, buttonSocials;
    private Logic logic = new Logic();

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

        recyclerView = findViewById(R.id.userlist);
        database = FirebaseDatabase.getInstance().getReference("friends");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    list.add(user);

                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        buttonRequest = (Button) findViewById(R.id.request_button);
        buttonRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(userlist.this, FriendRequest.class);
            }

        });

        buttonStatistics = (ImageButton) findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(userlist.this, Statistics.class);
            }

        });

        buttonHome = (ImageButton)findViewById(R.id.home_button);
        buttonHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(userlist.this, Homepage.class);
            }
        });

        buttonSocials = (ImageButton) findViewById(R.id.socials_button);
        buttonSocials.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                logic.openActivity(userlist.this, userlist.class);
            }
        });

    }
}