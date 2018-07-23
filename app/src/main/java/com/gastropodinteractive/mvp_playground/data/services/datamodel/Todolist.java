package com.gastropodinteractive.mvp_playground.data.services.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by Kei Lazu on 7/23/2018
 * check https://github.com/KeiLazu for more
 */
public class Todolist {

    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("notes")
    private String notes;

    public Todolist() {
    }

    public Todolist(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Todolist{" +
                "title='" + title + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todolist todolist = (Todolist) o;
        return Objects.equals(title, todolist.title) &&
                Objects.equals(notes, todolist.notes);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, notes);
    }
}
