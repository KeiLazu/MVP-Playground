package com.gastropodinteractive.mvp_playground.data.services.model;

import com.gastropodinteractive.mvp_playground.data.services.datamodel.Todolist;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Created by Kei Lazu on 7/23/2018
 * check https://github.com/KeiLazu for more
 */
public class GetTodolist {

    @Expose
    @SerializedName("todo")
    private List<Todolist> todolist;

    public List<Todolist> getTodolist() {
        return todolist;
    }

    public void setTodolist(List<Todolist> todolist) {
        this.todolist = todolist;
    }

    @Override
    public String toString() {
        return "GetTodolist{" +
                "todolist=" + todolist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTodolist that = (GetTodolist) o;
        return Objects.equals(todolist, that.todolist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(todolist);
    }

}
