package com.company;
import java.util.HashMap;
import java.util.Vector;
import java.io.*;

public class database {

    //Constructor: make database by making new HashMap
    public database() {
        data = new HashMap<>();

    }

    //Function: Add molecule to database by reading in text file
    //Read first line (name) and store as value
    //Read all other lines and store as vector (to be used as key)
    public void addCompound(String TextFile) {
        String line = null;
        Vector<String> key = new Vector<>();
        String value = new String();
        int count = 0;
        try {
            BufferedReader read = new BufferedReader(new FileReader(TextFile));
            while ((line = read.readLine())!= null) {
                if (count == 0) {
                    value = line;
                } else {
                    key.addElement(line);
                }
                count += 1;
            }
            if (findCompound(value + ".txt") == false) { // only add when the molecule does not exist
                data.put(key, value);
                System.out.println("Molecule " + value + " added");
            }
            else {
                System.out.println("Molecule " + value + " already exists");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO");
        }
    }

    //Function (WIP):
    public boolean findCompound(String TextFile) {
        String line = null;
        Vector<String> key = new Vector<>();
        String value = new String();
        int count = 0;
        try {
            BufferedReader read = new BufferedReader(new FileReader(TextFile));
            while ((line = read.readLine())!= null) {
                if (count != 0) {
                    key.addElement(line);
                }
                count += 1;
            }
            value = data.get(key);
            if (value == null) {
                //System.out.println("No molecule found");
                return false;
            } else {
                //System.out.println("Molecule name: " + value);
                return true;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO");
        }
        return false;
    }

    //Field: HashMap with key as vector of the vertices/structure and value as molecule name(data)
    private HashMap<Vector<String>, String> data;
}