package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{

    static void printRomanian(String a, String b, String c) throws IOException{

        final HashMap<Integer, String> romanianDecimals = new HashMap<>();
        romanianDecimals.put(1, "X");
        romanianDecimals.put(2, "XX");
        romanianDecimals.put(3, "XXX");
        romanianDecimals.put(4, "XL");
        romanianDecimals.put(5, "L");
        romanianDecimals.put(6, "LX");
        romanianDecimals.put(7, "LXX");
        romanianDecimals.put(8, "LXXX");
        romanianDecimals.put(9, "XC");
        romanianDecimals.put(10, "C");

        final HashMap<Integer, String> romanianReverse = new HashMap<>();
        romanianReverse.put(1, "I");
        romanianReverse.put(2, "II");
        romanianReverse.put(3, "III");
        romanianReverse.put(4, "IV");
        romanianReverse.put(5, "V");
        romanianReverse.put(6, "VI");
        romanianReverse.put(7, "VII");
        romanianReverse.put(8, "VIII");
        romanianReverse.put(9, "IX");
        romanianReverse.put(10, "X");

        final HashMap<String, Integer> romanian = new HashMap<>();
        romanian.put("I", 1);
        romanian.put("II", 2);
        romanian.put("III", 3);
        romanian.put("IV", 4);
        romanian.put("V", 5);
        romanian.put("VI", 6);
        romanian.put("VII", 7);
        romanian.put("VIII", 8);
        romanian.put("IX", 9);
        romanian.put("X", 10);

        int result = 0;
        String romanianResult;

        if (romanian.containsKey(a) && romanian.containsKey(c)){
            switch (b) {
                case "+" -> result = romanian.get(a) + romanian.get(c);
                case "-" -> result = romanian.get(a) - romanian.get(c);
                case "*" -> result = romanian.get(a) * romanian.get(c);
                case "/" -> result = romanian.get(a) / romanian.get(c);
            }
        }
        if (result <= 0){
            throw new IOException();
        } else if(result/10 > 1){
            romanianResult = romanianDecimals.get(result/10);
            if (result%10 > 0){
                System.out.println(romanianResult + romanianReverse.get(result%10));
            } else {
                System.out.println(romanianResult);
            }
        } else {
            System.out.println(romanianReverse.get(result));
        }
    }


    public static void main( String[] args ) throws IOException
    {
        while (true) {
            Scanner in = new Scanner(System.in);
            if (in.hasNextInt()) {
                Integer a = Integer.valueOf(in.next());
                String b = in.next();
                Integer c = Integer.valueOf(in.next());
                switch (b) {
                    case "+" -> System.out.println(a + c);
                    case "-" -> System.out.println(a - c);
                    case "*" -> System.out.println(a * c);
                    case "/" -> System.out.println(a / c);
                }
            } else if (in.hasNextLine()){
                String a = String.valueOf(in.next());
                String b = in.next();
                String c = String.valueOf(in.next());
                printRomanian(a, b, c);
            }
        }
    }
}
