package org.reorso.dvdlib.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
        Scanner keyboard = new Scanner(System.in);

        @Override
        public void print(String msg) {
            System.out.println(msg);
        }

        @Override
        public double readDouble(String prompt) {
            System.out.print(prompt);
            String input = keyboard.nextLine();

            return Double.parseDouble(checkInput(input));

        }

        @Override
        public double readDouble(String prompt, double min, double max) {
            double result = readDouble(prompt);
            while (result < min || result > max) {
                System.out.println("ERROR: " + result + " is not within the required range or null.");
                result = readDouble(prompt);
            }
            return result;
        }

        @Override
        public float readFloat(String prompt) {
            System.out.print(prompt);
            String input = keyboard.nextLine();

            return Float.parseFloat(checkInput(input));

        }

        @Override
        public float readFloat(String prompt, float min, float max) {
            float result = readFloat(prompt);
            while (result < min || result > max) {
                System.out.println("ERROR: " + result + " is not within the required range or null.");
                result = readFloat(prompt);
            }
            return result;
        }

        @Override
        public int readInt(String prompt) {
            System.out.print(prompt);
            String input = keyboard.nextLine();

            return Integer.parseInt(checkInput(input));


        }

        @Override
        public int readInt(String prompt, int min, int max) {
            int result = readInt(prompt);
            while (result < min || result > max) {
                System.out.println("ERROR: " + result + " is not within the required range or null.");
                result = readInt(prompt);
            }
            return result;
        }

        @Override
        public long readLong(String prompt) {
            System.out.print(prompt);
            String input = keyboard.nextLine();

            return Long.parseLong(checkInput(input));

        }

        @Override
        public long readLong(String prompt, long min, long max) {
            long result = readLong(prompt);
            while (result < min || result > max) {
                System.out.println("ERROR: " + result + " is not within the required range or null.");
                result = readLong(prompt);
            }
            return result;
        }

        @Override
        public String readString(String prompt) {
            System.out.print(prompt);
            String input = keyboard.nextLine();
            if(input != null) {
                return input;
            }
            return "";
        }

        @Override
        public void cls() {
/*            System.out.print("\033[H\033[2J");
            System.out.flush();*/
            for(int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

        String checkInput(String input) {
            if(input == null || input.isEmpty() || input.equals("\n")) {
                return "-1";
            }
            return input;
        }

}
