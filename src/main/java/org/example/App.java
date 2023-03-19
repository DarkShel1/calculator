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

        switch (b) {
            case "+" -> result = romanian.get(a) + romanian.get(c);
            case "-" -> result = romanian.get(a) - romanian.get(c);
            case "*" -> result = romanian.get(a) * romanian.get(c);
            case "/" -> result = romanian.get(a) / romanian.get(c);
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

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main( String[] args ) throws IOException
    {
        final HashMap<String, Integer> romanians = new HashMap<>();
        romanians.put("I", 1);
        romanians.put("II", 2);
        romanians.put("III", 3);
        romanians.put("IV", 4);
        romanians.put("V", 5);
        romanians.put("VI", 6);
        romanians.put("VII", 7);
        romanians.put("VIII", 8);
        romanians.put("IX", 9);
        romanians.put("X", 10);


        while (true) {
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            String[] arr = line.split(" ");
            if (arr.length != 3){
                throw new IOException();
            }

            if (romanians.containsKey(arr[0]) && romanians.containsKey(arr[2])) {
                String a = arr[0];
                String b = arr[1];
                String c = arr[2];
                printRomanian(a, b, c);
            } else if (romanians.containsValue(Integer.valueOf(arr[0]))) {
                Integer a = Integer.valueOf(arr[0]);
                String b = arr[1];
                Integer c = Integer.valueOf(arr[2]);
                switch (b) {
                    case "+" -> System.out.println(a + c);
                    case "-" -> System.out.println(a - c);
                    case "*" -> System.out.println(a * c);
                    case "/" -> System.out.println(a / c);
                }
            }
        }
    }
}
