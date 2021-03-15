package model;

import java.util.ArrayList;

/**
 * Class defines owners that will be associated with each pet at the clinic
 * 
 * @author Lucius Bossio
 * @version 1.0
 */
public class Owner 
{
    int id;
    String name;

    private static int nextID = 1001;

    transient ArrayList<Pet> petList; 

    /**
     * Default constructor auto increments owner ID and initializes a list of the owners pets
     */
    public Owner() 
    {
        super();
        petList = new ArrayList<>();
        this.id = nextID++;
    }

    /**
     * Non default constructor sets the owners name
     * 
     * @param name      - name of the owner to be created
     */
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