package com.example.nabinrai.recyclerviewdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.nabinrai.recyclerviewdemo.Model.FriendModel;
import com.example.nabinrai.recyclerviewdemo.R;
import java.util.List;

/**
 * Created by nabinrai on 9/5/17.
 */

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.MyViewHolder> {

    private List<FriendModel> friendsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView sId, name, age;

         public MyViewHolder(View view) {
            super(view);
            sId = (TextView) view.findViewById(R.id.mId);
            name = (TextView) view.findViewById(R.id.name);
            age = (TextView) view.findViewById(R.id.age);
        }
    }


    public FriendsAdapter(List<FriendModel> friendsList) {
        this.friendsList = friendsList;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FriendModel frn = friendsList.get(position);
        String idtext = "Id : "+frn.getId().toString();
        String nameText = "Name : "+frn.getName();
        String ageText = "Age : "+frn.getAge().toString();
        holder.sId.setText(idtext);
        holder.name.setText(nameText);
        holder.age.setText(ageText);
    }

    @Override
    public int getItemCount() {
        return friendsList.size();
    }

}
