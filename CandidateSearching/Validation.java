/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author DELL
 */
public class Validation {

    public static String Email_VALID = "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    static View view = new View();

    public static String checkInputString(String msg) {
        while (true) {
            String result = view.getInput(msg);
            if (result.length() == 0) {
                view.showError("Not empty");
            } else {
                return result;
            }
        }
    }

    public static String checkInputEmail(String msg) {
        while (true) {
            String input = view.getInput(msg);
            if (!input.isEmpty() && input.matches(Email_VALID)) {
                return input;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputYear(String msg) {
        while (true) {
            try {
                String input = view.getInput(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Date inputDate = sdf.parse(input);

                Calendar today = Calendar.getInstance();
                int currentYear = today.get(Calendar.YEAR);
                int inputYear = Integer.parseInt(sdf.format(inputDate));

                if (inputYear >= currentYear) {
                    view.showError("Year must be in the past.");
                    continue;
                }

                return input;
            } catch (Exception e) {
                view.showError("Invalid year. Please re-enter.");
            }
        }
    }

    public static String checkInputGraduateYear(String msg, String dOB) {
        while (true) {
            try {
                String input = view.getInput(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                Date inputDate = sdf.parse(input);

                Calendar today = Calendar.getInstance();
                
                int currentYear = today.get(Calendar.YEAR);
                int inputYear = Integer.parseInt(sdf.format(inputDate));
                
                
                int a = currentYear - inputYear; //expe
                System.out.println(a);
                int b = currentYear - Integer.parseInt(dOB); // age
                System.out.println(b);
                if(b <= a ){
                    System.err.println("sai so ko the vuot qua tuoi");
                }
                
                return input;
                
                

            } catch (Exception e) {
                
            }
        }
    }

    public static String checkInputPhone(String msg) {

        while (true) {

            String result = view.getInput(msg);

            if (result.matches("^[0-9]{10}$")) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public static int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        //force user input exectly integer number
        while (true) {
            String input = view.getInput(mess);
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }

    public static String checkInputGraduationRank(String msg) {
        while (true) {
            String input = view.getInput(msg);
            try {
                if (!input.equalsIgnoreCase("Excellent")
                        || !input.equalsIgnoreCase("good")
                        || !input.equalsIgnoreCase("bad")) {
                    view.showError("must be exactly!");
                    continue;
                }
                return input;
            } catch (Exception e) {

            }
        }
    }

}
