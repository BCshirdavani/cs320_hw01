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
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            text += input + "\n";
        }

        // print the text that was scanned from file
        System.out.println("\nhere is the text...\n");
        System.out.println(text);

        // Make the pattern that we will use to search for in our Reg Exp
//        Pattern pattern = Pattern.compile("(.+)//s(.+)//s?=?//s?(.*);");
//        Pattern pattern = Pattern.compile("([a-zA-Z]+)\\s(.+)\\s?=?\\s?(.*);");
        Pattern pattern = Pattern.compile("(\\w+)\\s(\\w+)\\s?=?\\s?([\\w|\\'|\\.|\"]*);");
//        Pattern pattern = Pattern.compile("(\\w+)\\s?(\\w+)\\s?=?\\s?([\\w|\\'|\\.|\"]*);");

        Matcher matcher = pattern.matcher(text);
        String subset_01 = "";
        int countMatch = 0;
        System.out.println("loop should start printing now...\n\n");
        while (matcher.find()) {
//            System.out.println("\t looping");
//            System.out.println("\t" + matcher.group(0));
            System.out.println("\t" + matcher.group(0));
            System.out.println("type:\t" + matcher.group(1));
            System.out.println("name:\t" + matcher.group(2));
            System.out.println("value:\t" + matcher.group(3));
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            countMatch++;
        }
        System.out.println(countMatch);
    }

}