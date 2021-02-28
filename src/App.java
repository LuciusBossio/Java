import model.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import com.google.gson.Gson;

public class App 
{
    static Gson gson = new Gson();

    public static void main(String[] args) throws Exception 
    {   
        PetClinic clinic = loadClinic("petClinic.json");
        if (clinic == null)
        {
            clinic = initPetClinic();
        }
        
        saveClinic(clinic, "petClinic.json");
    }

    private static PetClinic loadClinic(String fileName)
    {
        File file = new File(fileName);
        String json = "";
        PetClinic clinic = null;

        try
        (
            FileInputStream bytStream = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(bytStream);
            Scanner scanner = new Scanner(inputStream);
        )
        {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine())
            {
                stringBuilder.append(scanner.nextLine());
            }

            json = stringBuilder.toString();
            clinic = gson.fromJson(json, PetClinic.class);
        }
        catch(Exception e)
        {
            System.out.println("File not found or unable to load. Creating " + fileName + ".");
            clinic = null;
        }

        return clinic;
    }

    private static void saveClinic(PetClinic clinic, String fileName)
    {
        File file = new File(fileName);
        String json = gson.toJson(clinic);

        try
        (
            FileOutputStream bytStream = new FileOutputStream(file);
            OutputStreamWriter streamWriter = new OutputStreamWriter(bytStream);
        )
        {
            streamWriter.write(json);
        }
        catch(Exception e)
        {
            System.out.println("File unable to save.");
            e.printStackTrace();
        }
    }

    private static PetClinic initPetClinic()
    {
        PetClinic clinic = new PetClinic();

        Owner chris = new Owner("Chris");
        Owner jim = new Owner("Jim");
        Owner lucius = new Owner("Lucius");
        Owner adam = new Owner("Adam");
        Owner amy = new Owner("Amy");

        Pet rover = new Pet("Rover","dog", "mutt");
        Pet garfield = new Pet("Garfield","cat", "Persian");
        Pet kaiju = new Pet("Kaiju","cat", "Domestic");
        Pet raiju = new Pet("Raiju","cat", "Russian Blue");
        Pet koda = new Pet("Koda","dog", "mutt");
        Pet buttons = new Pet("Buttons","dog", "mutt");
        Pet pretty = new Pet("Pretty","cat", "mutt");
        Pet lola = new Pet("Lola","dog", "mutt");
        Pet token = new Pet("Token","cat", "Domestic");
        Pet tweak = new Pet("Tweak","cat", "Domestic");
        
        clinic.addOwner(chris);
        clinic.addOwner(jim);
        clinic.addOwner(lucius);
        clinic.addOwner(adam);
        clinic.addOwner(amy);

        clinic.addPet(rover,chris);
        clinic.addPet(garfield,chris);
        clinic.addPet(kaiju,lucius);
        clinic.addPet(raiju,lucius);
        clinic.addPet(koda,lucius);
        clinic.addPet(buttons,jim);
        clinic.addPet(pretty,lucius);
        clinic.addPet(lola,adam);
        clinic.addPet(token,amy);
        clinic.addPet(tweak,amy);

        return clinic;
    }
}

//***************NOTES***************
//gson - when gson converts to JSON it attempts to print pet info then owner info
//the owner points back to pets and gson tries to convert the pet again
//bounces back and forth between pets and owners until all stack space is used up until the stack overflow
//in the owner class we need to add the keyword TRANSIENT before the arraylist - prevents serialization and stops the infinite loop
//add transient to petlist reference in the owners class
//transient - Javas way of not serializing a specific field - convert owner object to json and ignore pets - pets do not need to be serialized from the owner class

//save json object to a file
//reload petClinic from file
//populate petclinic with a set of data

//main - loadclinic from JSON if exists - can use try catch logic inside of loadClinic to verify file exists and loads properly, returns null if try does not work
//main todo - interact with clinic data after data is loaded from petclinic json
//main - saveClinic to json file at end

//documentation - use javaDoc format - standard form of documentation in real world development - allows other devs to continue project

//next milestone - indexes in SQL are the same as a hashmap - speeds up ability to search for data
