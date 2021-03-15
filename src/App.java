import model.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
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

        System.out.println(clinic.findPetByID(5));

        System.out.println(clinic.findPetByType("dog"));
    }

    /**
     * Function loads data from a .json file into a PetClinic object and hash map
     * 
     * @param fileName  - the name of the .json file
     * @return          - the updated PetClinic object 
     */
    private static PetClinic loadClinic(String fileName)
    {
        File file = new File(fileName);
        String json = "";
        PetClinic clinic = null;
        HashMap<String, PetClinic> loadMap = new HashMap<>();

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
            loadMap.put(clinic.toString(), clinic);
        }
        catch(Exception e)
        {
            System.out.println("File not found or unable to load. Creating " + fileName + ".");
            clinic = null;
        }

        return clinic;
    }

    /**
     * Function saves data to a .json file using a PetClinic object
     * 
     * @param clinic        - object to be converted to json and saved
     * @param fileName      - name of the file that contains pet clinic data
     */
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

    /**
     * Initialize pet clinic object with hard coded data
     * 
     * @return      - pet clinic object initialized with hardcoded data
     */
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
        Pet buttons = new Pet("Buttons","bird", "mutt");
        Pet pretty = new Pet("Pretty","cat", "mutt");
        Pet lola = new Pet("Lola","dog", "mutt");
        Pet token = new Pet("Token","lizard", "Domestic");
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