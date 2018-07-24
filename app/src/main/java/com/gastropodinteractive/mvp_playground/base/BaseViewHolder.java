package com.gastropodinteractive.mvp_playground.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Kei Lazu on 7/25/2018
 * check https://github.com/KeiLazu for more
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private int currentPosition;

    public BaseViewHolder(View v) {
        super(v);
    }

    protected abstract void clear();

    public void onBind(int position) {
        currentPosition = position;
        clear();
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

}
