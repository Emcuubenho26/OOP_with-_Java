/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class View {
    
    static Scanner in = new Scanner(System.in);
    public static String getInput(String msg){
        System.out.println(msg);
        return in.nextLine().trim();
    }
    public static void showOutput(String msg){
        System.out.println(msg);
    }
    public static void showError(String err){
        System.err.println(err);
    }
    
    
}
