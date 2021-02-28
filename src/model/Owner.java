package model;

import java.util.ArrayList;

public class Owner {
    int id;
    String name;

    private static int nextID = 1001;

    transient ArrayList<Pet> petList; 

    public Owner() {
        super();
        petList = new ArrayList<>();
        this.id = nextID++;
    }

    public Owner(String name) 
    {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Pet> getPets() {
        return petList;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "id " + id + ": " + name;
    }
}