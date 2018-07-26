package Game;

import java.util.Random;
import java.util.Scanner;

public class Game {


    public static void start()
    {
        Scanner keyboard = new Scanner(System.in);

        int rand = new Random().nextInt(11);

        while(true)
        {
            System.out.print("Insert number: ");

            int number = keyboard.nextInt();

            if(number==rand)
            {
                System.out.println("Game won!");
                return;
            }
            else if(number < rand)
            {
                System.out.println("The number is bigger!");
            }
            else
            {
                System.out.println("The number is lower!");
            }



        }


    }



}
