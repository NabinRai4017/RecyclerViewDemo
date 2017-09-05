package com.example.nabinrai.recyclerviewdemo.Activity;


import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.nabinrai.recyclerviewdemo.Adapter.ClickListenser;
import com.example.nabinrai.recyclerviewdemo.Adapter.FriendsAdapter;
import com.example.nabinrai.recyclerviewdemo.Adapter.RecyclerTouchListener;
import com.example.nabinrai.recyclerviewdemo.Model.FriendModel;
import com.example.nabinrai.recyclerviewdemo.R;
import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity {


    private List<FriendModel> friendList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FriendsAdapter mAdapter;
    private Button addFrnBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        addFrnBtn = (Button) findViewById(R.id.addFrnBtn);

        mAdapter = new FriendsAdapter(friendList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListenser() {
            @Override
            public void onClick(View view, int position) {
                FriendModel frn = friendList.get(position);
                Toast.makeText(getApplicationContext(), frn.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

                FriendModel frn = friendList.get(position);
                Toast.makeText(getApplicationContext(), frn.getName() + " is long pressed", Toast.LENGTH_LONG).show();

            }
        }));

        addFrnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogBox();

            }
        });


        prepareMovieData(1,"nabin",24);

    }


    private void prepareMovieData(Integer Id, String name, Integer age) {

        FriendModel frn = new FriendModel(Id,name,age);
        friendList.add(frn);
        mAdapter.notifyDataSetChanged();
    }


    private void dialogBox(){

        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Add friend in the list");
        dialog.setContentView(R.layout.friend_add);
        final EditText idText, nameText, ageText;
        final  Button addnewFrn;
        idText = (EditText) dialog.findViewById(R.id.enterId);
        nameText = (EditText) dialog.findViewById(R.id.enterName);
        ageText = (EditText) dialog.findViewById(R.id.enterAge);
        addnewFrn = (Button) dialog.findViewById(R.id.addNewFrn);

        addnewFrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = idText.getText().toString();
                String name = nameText.getText().toString();
                String age = ageText.getText().toString();
                Integer integerId = Integer.parseInt(id);
                Integer integerAge = Integer.parseInt(age);
                prepareMovieData(integerId,name,integerAge);
                dialog.dismiss();

            }
        });
        dialog.show();
    }



}
