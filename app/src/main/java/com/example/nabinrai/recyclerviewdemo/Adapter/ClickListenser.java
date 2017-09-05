package com.example.nabinrai.recyclerviewdemo.Adapter;

import android.view.View;

/**
 * Created by nabinrai on 9/5/17.
 */

public interface ClickListenser {
    void onClick(View view, int position);
    void onLongClick(View view, int position);
}