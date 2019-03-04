/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myreflexagent;

import java.util.Scanner;
import java.util.Random;

public class MyReflexAgent {

    private static Random rand = new Random();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows, cols, dirt;

        System.out.println("Total rows: ");
        rows = input.nextInt();
        System.out.println("Total Columns: ");
        cols = input.nextInt();
        System.out.println("Total Dirty cells: ");
        dirt = input.nextInt();
        int totalDirty = dirt;

        Environment environment = new Environment(rows, cols, dirt);

        System.out.println("\nInitial state :");
        System.out.println(environment.toString());

        //Clean dirt
        while (totalDirty > 0) {
            Direction randDirection = Utility.getRandomDirection();
            while (true) {
                int success = 4;
                // Move into randome direction
                switch (randDirection) {
                    case UP:
                        success = environment.moveUp();
                        Utility.printMovement(environment, "Up");
                        break;
                    case DOWN:
                        success = environment.moveDown();
                        Utility.printMovement(environment, "Down");
                        break;
                    case LEFT:
                        success = environment.moveLeft();
                        Utility.printMovement(environment, "Left");
                        break;
                    case RIGHT:
                        success = environment.moveRight();
                        Utility.printMovement(environment, "Right");
                        break;
                }
                totalDirty = Utility.cleanCell(environment, totalDirty);

                if (success == 1) {
                    break;
                }
            }

        }

        System.out.println("\nEnvironment after the reflex agent has completed the work:");
        System.out.println(environment.toString());
        System.out.println("Total score: " + environment.getScore());
    }

}
