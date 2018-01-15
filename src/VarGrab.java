//*********************************************************
//
//  Author:         Beau Shirdavani
//  Date:           1-14-2017
//  Description:    cs320 - Prog Languages
//                  HW 01 - reg expression
//
//*********************************************************

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarGrab {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("A.java");
        Scanner scanner = new Scanner(file);

        // scan the text
        String input = "";
        String text = "";
        while(scanner.hasNextLine()){
            input = scanner.nextLine();
            text += input + "\n";
        }

        // print the text that was scanned from file
        System.out.println("\nhere is the text...\n");
        System.out.println(text);

        // Make the pattern that we will use to search for in our Reg Exp
            // first reg exp will grab subset the text to give me the entire
            // row where it finds variable identifiers
            // then I will further break that apart for type, name, value
        Pattern pattern = Pattern.compile("(int.*|double.*|float.*|char.*|String.*).*;");
        Matcher matcher = pattern.matcher(text);
        String subset_01 = "";
        int countMatch = 0;
        System.out.println("loop should start printing now...\n\n");
        while( matcher.find() ){
            System.out.println("\t" + matcher.group(1));
            subset_01 = subset_01 + "\n" + matcher.group(1);
            countMatch++;
        }
            // preview subset_01
//        System.out.println("\t" + subset_01);




            // put every row into an array of strings for looping work later
        Pattern patternROW = Pattern.compile("(.*)\n");
        Matcher matcher2 = patternROW.matcher(subset_01);
        String[] arrSTRING = new String[countMatch];
        int i = 0;
        System.out.println("\nprinting second matcher...\n");
        while( matcher2.find() ){
            System.out.println("\t\t" + matcher2.group(1));
            arrSTRING[i] = matcher2.group(1);
            i++;
        }
            // double check the array of strings
        System.out.println("\nprinting array list [1]...\n" + arrSTRING[1]);
        System.out.println("\nprinting array list [2]...\n" + arrSTRING[2]);
        for (int g = 1; g < 12; g++){
            System.out.println("\t\t\t\t" + arrSTRING[g]);                  // <---------These rows fail ????
        }


            // run for loop on this array of strings
                // use 3 different patterns to extract type/name/value
        Pattern patternTYPE = Pattern.compile("(int.*|double.*|float.*|char.*|String.*)");
        Pattern patternNAME = Pattern.compile("\\s{1}([a-zA-Z]{1,}).*");
        Pattern patternVALUE = Pattern.compile("=\\s(.*)");

//
//        for (int j = 0; j < countMatch; j++){
            Matcher matcherTYPE = patternTYPE.matcher( arrSTRING[i+1] );    // <---------These rows fail ????
            Matcher matcherNAME = patternNAME.matcher( arrSTRING[i+1] );    // <---------These rows fail ????
            Matcher matcherVALUE = patternVALUE.matcher( arrSTRING[i+1] );  // <---------These rows fail ????

            System.out.println("Type: " + matcherTYPE.group(1));            // <---------These rows fail ????
            System.out.println("Name: " + matcherNAME.group(1));            // <---------These rows fail ????
            System.out.println("Value: " + matcherVALUE.group(1));          // <---------These rows fail ????
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        }




    }


