package com.main;
/**This class uses the text file docnum+contract.txt to scan it.
 * Then it uses its information to check it. The information in there are numbers of documents/contracts.
 * When a name is invalid it creates a new file and writes the errors inside.
 * At first the file is scanned, to get its length, this length is used to create a new array.
 * A valid information looks like this:
 * docnumXXXXXXXXXXXXXXX or
 * contraXXXXXXXXXXXXXXX.
 * The x is a number!
 */

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        String filePathName ="C:\\Users\\Tatjana\\Music\\I\\Text Files\\docnum+contract.txt";

        File newFile = new File(filePathName);
        if (!newFile.exists()){
            throw new FileNotFoundException();
        }

        FileReader fileReader1 = new FileReader(filePathName);
        FileReader fileReader2 = new FileReader(filePathName);
        char[] test = new char[65536];
        int i = 0;
        int newCharLength = 0;
        while ((i = fileReader1.read(test)) >= 0) {
            newCharLength = i;
        }
        i = 0;
        int q = 0;
        char[] c = new char[newCharLength];
        char[] c2 = new char[newCharLength];
        while ((i = fileReader2.read(c)) >= 0) {

            c2 = c;
        }
        String str;
        str = String.valueOf(c2);

        /**Analyzes*/
        long long1 =ThreadLocalRandom.current().nextLong(100000000,999999999 );
        String fileName = "C:\\Users\\Tatjana\\Music\\I\\Text Files\\conflicts"+ (long1)  +".txt";
        String[] words = str.split(",");
        File myFile = new File(fileName);
        try {
            myFile.createNewFile();
        }catch (FileAlreadyExistsException e){
            System.out.println("Failed to create file because file already exists.");
            System.out.println(e.getMessage());
        }
        System.out.println("Your analyses will be here: ");
        System.out.println(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        String qwertz;
            for (int j = 0; j < words.length - 1; j++) {
                if (words[j].length() < 21) {

                    qwertz = ("Invalid: " + words[j] + "  is too short("+ words[j].length() + "). Found at position: " + j +"\n");
                    try(FileWriter fw = new FileWriter(myFile, true)){
                        fw.write(qwertz);
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                if (words[j].length() > 21) {
                    qwertz = ("Invalid: " + words[j] + "  is too long("+ words[j].length() + "). Found at position: " + j +"\n");
                    try(FileWriter fw = new FileWriter(myFile, true)){
                        fw.write(qwertz);
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                }
                if (!words[j].contains("docnum") && !words[j].contains("contra")) {
                    qwertz = ("Invalid: " + words[j] + " does not have a specification. " +words[j].length()+ " pos: " + j +"\n");
                    try(FileWriter fw = new FileWriter(myFile, true)){
                        fw.write(qwertz);
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
                if (!words[j].matches(".*[0-9].*")) {
                    qwertz = ("Invalid: " + words[j] + "  does not contain numbers " +words[j].length()+ " pos: " + j +"\n");
                    try(FileWriter fw = new FileWriter(myFile, true)){
                        fw.write(qwertz);
                    } catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }













