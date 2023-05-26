package com.project.waterify30;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendListAdapter extends FirebaseRecyclerAdapter<MainModelFriendList, FriendListAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FriendListAdapter(@NonNull FirebaseRecyclerOptions<MainModelFriendList> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull MainModelFriendList model) {
        holder.name.setText(model.getName());
        holder.email.setText(model.getName());

//        Glide.with(holder.img.getContext())
//                .load(model.getSurl())
//                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
//                .circleCrop()
//                .error(com.google.firebase.database.collection.R.drawable.common_google_signin_btn_icon_dark)
//                .into(holder.img);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        TextView name, email;

        public myViewHolder(@NonNull View itemView)
        {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            name = (TextView)itemView.findViewById(R.id.nametext);
            email = (TextView)itemView.findViewById(R.id.emailtext);

        }

    }
}
