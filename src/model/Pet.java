package model;

/**
 * Class defines individual pets that will be added to the pet clinic
 * 
 * @author Lucius Bossio
 * @version 1.0
 */
public class Pet 
{
    int id;
    String name;
    String type;
    String breed;
    Owner owner;

    private static int nextID = 1;

    /**
     * Default constructor auto increments the pet ID
     */
    public Pet() 
    {
        super();        
        this.id = nextID++;
    }

    /**
     * Non default constructor sets other pet parameters
     * 
     * @param name      - name of the pet to be created
     * @param type      - type of pet to be created
     * @param breed     - breed of pet to be created
     */
    public Pet(String name, String type, String breed) 
    {
        this();     
        this.name = name;
        this.type = type;
        this.breed = breed;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getBreed() {
        return breed;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString()
    {
        return  "\nid: " + id +        
                "\nname: " + name + 
                "\ntype: " + type + 
                "\nbreed: " + breed + 
                "\nowner: " + owner.toString();
    }
}