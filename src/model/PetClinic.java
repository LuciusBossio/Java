package model;

import java.util.ArrayList;

public class PetClinic 
{
    ArrayList<Owner> ownerList;
    ArrayList<Pet> petList;
    
    public PetClinic()
    {
        super();
        ownerList = new ArrayList<>();
        petList = new ArrayList<>();
    }

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

    public void addPet(Pet pet, Owner owner)
    {
        pet.setOwner(owner);
        petList.add(pet);
        owner.petList.add(pet);
    }

    @Override
    public String toString()
    {
        return petList.toString();
    }
}