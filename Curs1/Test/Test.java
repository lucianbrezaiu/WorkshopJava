package Test;

import Age.AgeManager;
import Game.Game;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {

        exercise1();


        exercise2();


        exercise3();


        exercise4();


        exercise5();


        exercise6();



/*
        String  s = "abc";
        s = s.toUpperCase();
        System.out.println(s);
*/




        keyboard.close();
    }


    public static void exercise1()
    {
        AgeManager myManager = new AgeManager();

        System.out.print("Insert age: ");

        int age = keyboard.nextInt();

        System.out.print(myManager.checkAge(age));


    }

    public static void exercise2()
    {
        System.out.print("\nInsert month: ");

        int month = keyboard.nextInt();

        if(month == 12 || month == 1 || month == 2)
        {
            System.out.println("Winter");
        }
        else if(month >= 3 && month <=5)
        {
            System.out.println("Spring");
        }
        else if(month>=6 && month<=8)
        {
            System.out.println("Summer");
        }
        else if(month>=9 && month<=11)
        {
            System.out.println("Autumn");
        }
        else
        {
            System.out.println("Wrong month!");
        }
    }

    public static void exercise3()
    {
        Game.start();
    }

    public static void exercise4()
    {
        String s1 = new String("abc");
        String s2 = new String("abc");

        if(s1==s2) // se verifica zonele de memorie, se va afisa 'nu'
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("Not equal");
        }
    }



    public static void exercise5()
    {
        String str = "Ana are mere si pere si visine";
        System.out.println(str.split(" ").length + " words.");



        Map<String,Integer> map = new HashMap<>() ;
        for (String s :  str.split(" ")   )
        {
            if(map.containsKey(s))
            {
                map.put(s, map.get(s) + 1);
            }
            else
            {
                map.put(s,1);
            }
        }
        System.out.println(map);


        String first = "abc";
        String second = "cba";

        if(first.equals((new StringBuilder(second).reverse()).toString()))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }


    public static void exercise6()
    {
        /*
        DaysOfWeek dos = new DaysOfWeek();
        */

        DaysOfWeek[] days = DaysOfWeek.values();
        for(int i=0; i<days.length; i++)
        {
            System.out.println(days[i]);
        }

    }

}
