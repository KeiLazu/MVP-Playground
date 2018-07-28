package com.gastropodinteractive.mvp_playground.utils;

import android.view.View;

/**
 * Created by Kei Lazu on 7/28/2018
 * check https://github.com/KeiLazu for more
 */
public interface ClickListener {
    void onClick(View view,int position);
    void onLongClick(View view, int position);
}
