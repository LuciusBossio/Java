package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class populates a list of pets linked to their owners
 * 
 * @author Lucius Bossio
 * @version 1.0
 */
public class PetClinic 
{
    ArrayList<Owner> ownerList;
    ArrayList<Pet> petList;

    HashMap<Integer, Pet> petIDMap;
    HashMap<String, ArrayList<Pet>> petTypeMap;
    
    /**
     * Default constructor initializes array lists and hash maps
     */
    public PetClinic()
    {
        super();
        ownerList = new ArrayList<>();
        petList = new ArrayList<>();

        petIDMap = new HashMap<>();
        petTypeMap = new HashMap<>();
    }

    /**
     * Populate list of owners with data from owner object
     * 
     * @param owner     - name of owner object
     */
    public void addOwner(Owner owner)
    {
        if (ownerList.contains(owner))
        {
            System.out.println(owner + " already exists");
        }
        else
        {
            ownerList.add(owner);
        }
    }

    /**
     * Populate list of pets linked to owners
     * Build hash map to allow for search by pet ID and pet type 
     * 
     * @param pet       - pet object to be added to the list of pets
     * @param owner     - owner associated with the pet to be added
     */
    public void addPet(Pet pet, Owner owner)
    {
        pet.setOwner(owner);
        petList.add(pet);
        owner.petList.add(pet);

        petIDMap.put(pet.id, pet);

        if (petTypeMap.get(pet.type) == null)
        {
            petTypeMap.put(pet.type, new ArrayList<>());
        }
        petTypeMap.get(pet.type).add(pet);
    }

    /**
     * Search for a pet by ID from the clinic's pet list using the pet ID hash map
     * 
     * @param id        - pet ID used to retrieve pet object
     * @return          - pet object retrieved from the pet ID hash map
     */
    public Pet findPetByID(int id)
    {
        return petIDMap.get(id);
    }

    /**
     * Search for pets by type from the clinic's pet list using the pet type hash map
     * 
     * @param type      - pet type used to retrieve list of pets of that type
     * @return          - array list of pets of a specific type
     */
    public ArrayList<Pet> findPetByType(String type)
    {
        return petTypeMap.get(type);
    }

    @Override
    public String toString()
    {
        return petList.toString();
    }
}