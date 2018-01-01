package me.magurmach.challenge;

/**
 * Created by Shakib Ahmed on 1/1/18.
 */
public class Main {



    public static void main(String[] args) {
        String commandLineFileName = "test.txt";

        if (args[0].equals("-i")) {
            commandLineFileName = args[1];
        }

        System.out.println(commandLineFileName);
    }
}
