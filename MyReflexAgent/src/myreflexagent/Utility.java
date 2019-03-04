/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myreflexagent;

import java.util.Random;

public class Utility {

    static Random generator = new Random();

    static void printMovement(Environment env, String Direction) {
        System.out.println("\nMove " + Direction + ":");
        System.out.println(env.toString());
    }

    // Generate random number and map it to the direction
    static Direction getRandomDirection() {
        int randDirection = generator.nextInt(4);
        return Direction.values()[randDirection];
    }

    // Clean current cell from the environment and
    // return updated dirty cells count
    static int cleanCell(Environment env, int totalDirty) {
        if (env.isDirty()) {
            env.suck();
            totalDirty--;
            System.out.println("\nClean:");
            System.out.println(env.toString());

        }
        return totalDirty;
    }

}
