/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpbank;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class View {

    static Scanner in = new Scanner(System.in);

    public static void menu() {
        System.out.println("====== Login Program ======");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public static String getUserInput(String msg) {
        System.out.println(msg);
        return in.nextLine().trim();
    }

    public static void showOutput(String msg) {
        System.out.println(msg);
    }

    public static void showErr(String err) {
        System.err.println(err);
    }

}
