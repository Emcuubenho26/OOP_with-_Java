
import java.util.Scanner;


public class View {
   static Scanner sc = new Scanner(System.in);
    
 public static void printMenu(boolean isLogin) {
        if (isLogin) {
            System.out.println("1. Logout");
            System.out.println("2. Exit");
        } else {
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
        }
    }
 
 public void showOutput(String msg){
     System.out.println(msg);
 }
 
 public void showError(String msg) {
     System.err.println(msg);
 }
 
 public static String getInput(String msg){
     System.out.println(msg);
     return sc.nextLine().trim();
 }
 
 
 
    
    
}
