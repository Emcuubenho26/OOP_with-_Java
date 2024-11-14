/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.*;

/**
 *
 * @author DELL
 */
public class Controller {
    static Locale locale;
    static ResourceBundle bundle;
    static View in = new View();
    
   public static int getInt (String msg){
       while (true) {           
           try {
               int choice = Integer.parseInt(in.getUserInput(msg));
               
               if(1<=choice && choice <=3){
                   return choice;
               }else{
                   in.showErr("Just in range 1-3 pls");
               }
           } catch (Exception e) {
                  in.showErr("Just in range 1-3 pls");
           }
       }
   }
   
    
    
    
 public static String getString(String msg) {
        while (true) {
       String s = in.getUserInput(msg);
            if (!s.isEmpty()) {
                return s;
            }
            System.err.println("Empty string is not allowed");
        }
    }

    public static void setLocale(Locale locale) {
        Controller.locale = locale;
    }

  
 
 
 
  public static void inputInformation(int choice) {
        if (choice == 1) {
            setLocale(new Locale.Builder().setLanguage("VIE").setRegion("VN").build());
            bundle = ResourceBundle.getBundle("language.VIE", locale);
        } else {
            setLocale(new Locale.Builder().setLanguage("ENG").setRegion("US").build());
            bundle = ResourceBundle.getBundle("language/ENG", locale);
        }

        while (true) {
            String accountNumber = getString(bundle.getString("account"));
            String msg = checkAccountNumber(accountNumber);
            System.out.println(accountNumber);
            if (msg.isEmpty()) {
                break;
            }
           in.showErr(msg);
        }

        while (true) {
            String password = getString(bundle.getString("password"));
            String msg = checkPassword(password);
            System.out.println(password + "#1");
            if (msg.isEmpty()) {
                break;
            }
            in.showErr(msg);
        }

        int wrong = 0;
        while (true) {
            String captchaGenerate = generateCaptcha();
            System.out.println(bundle.getString("captcha") + captchaGenerate);
            String captchaInput = getString(bundle.getString("captcha"));
            String msg = checkCaptcha(captchaInput, captchaGenerate);
            if (msg.isEmpty()) {
                break;
            }else{
                wrong++;
                 in.showErr(msg + wrong);
                 if(wrong == 4){
                     break;
                 }
            }
           
        }
    }



    public static String checkAccountNumber(String accountNumber) {
        if (accountNumber.matches("^[0-9]{10}$")) {
            return "";
        }
        return bundle.getString("check.account");
    }

    public static String checkPassword(String password) {
        if (password.matches("^[0-9a-zA-Z]{8,31}$")
                && password.matches(".*[a-zA-Z].*")
                && password.matches(".*[0-9].*")) {
            return "";
        }
        return bundle.getString("wrong.password");
    }

    public static String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.equals(captchaInput)) {
            return "";
        }
        return bundle.getString("wrong.captcha");
    }

    public static String generateCaptcha() {
       String s = "1234567890qwertyuiopasdfghjklzxcvbmnQWERTYUIOPASDFGHJKLZXCVBNM";
    // String s = "^[0-9A-Za-z]$";
        Random r = new Random();
        String captcha = "";
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(s.length());
            captcha = captcha + s.charAt(index);
            s = s.substring(0, index) + s.substring(index + 1);
        }
        return captcha;
    }
 
 
    public static void run(){
        while (true) {
            in.menu();
            int choice = getInt("Choose a language/Chon ngon ngu: ");
            switch (choice) {
                case 1: case 2:
                    inputInformation(choice);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
    
    
 
}
