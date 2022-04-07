package com.example.interviewApp.model;

import java.util.ArrayList;

public class Resource {

    private ArrayList<String> tasks = new ArrayList<String>();
    private int id;
    public int getId() {
        return this.id;
    }

    public Iterable<String> getTasks() {
        return this.tasks;
    }

    public Resource(int id) {
        this.id = id;
    }

    public void performTask(String task) {
        if (this.tasks == null)
            throw new IllegalStateException(this.getClass().getName());

        this.tasks.add(task);
    }

    public void dispose() {
        this.tasks = null;
    }
}
