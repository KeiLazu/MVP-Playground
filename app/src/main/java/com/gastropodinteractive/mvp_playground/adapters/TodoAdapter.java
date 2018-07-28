package com.gastropodinteractive.mvp_playground.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gastropodinteractive.mvp_playground.R;
import com.gastropodinteractive.mvp_playground.base.BaseViewHolder;
import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.gastropodinteractive.mvp_playground.data.services.model.GetTodolist;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kei Lazu on 7/26/2018
 * check https://github.com/KeiLazu for more
 */
public class TodoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Todolist> todolist;

    public TodoAdapter(List<Todolist> todolist) {
        this.todolist = todolist;
    }

    public void addTodolist(List<Todolist> todolist) {
        this.todolist.addAll(todolist);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (todolist != null && todolist.size() > 0)
            return todolist.size();
        else
            return 0;
    }

    public Todolist getTodolistInPosition(int position) {
        if (todolist != null)
            return todolist.get(position);
        else
            return null;
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.list_item_todo_lbl_title)
        TextView lblTitle;

        @BindView(R.id.list_item_todo_lbl_notes)
        TextView lblNotes;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        @Override
        protected void clear() {
            lblTitle.setText("");
            lblNotes.setText("");
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            Todolist todolistModel = todolist.get(position);

            lblTitle.setText(todolistModel.getTitle());
            lblNotes.setText(todolistModel.getNotes());

        }

    }

}
