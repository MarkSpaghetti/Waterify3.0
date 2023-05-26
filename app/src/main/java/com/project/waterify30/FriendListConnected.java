package com.project.waterify30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FriendListConnected extends AppCompatActivity {

    private ImageButton buttonHome, buttonSocials, buttonStatistics, buttonFriendGarden; // list of buttons
    private Logic logic = new Logic();
    RecyclerView recyclerView;
    FriendListAdapter friendListAdapter;

    buttonStatistics = (ImageButton) findViewById(R.id.statistics_button);
        buttonStatistics.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {

            logic.openActivity(FriendList.this, Statistics.class);
        }

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list_connected);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModelFriendList> options =
                new FirebaseRecyclerOptions.Builder<MainModelFriendList>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("friends"), MainModelFriendList.class)
                        .build();

        friendListAdapter = new FriendListAdapter(options);
        recyclerView.setAdapter(friendListAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        friendListAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        friendListAdapter.stopListening();
    }


}