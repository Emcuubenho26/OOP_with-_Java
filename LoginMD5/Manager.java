
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import javax.naming.spi.DirStateFactory;

public class Manager {

    public static String Email_VALID = "^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    //"^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$"
    static View view = new View();

    public static void run() {

        ArrayList<Human> lh = new ArrayList<>();
        boolean isLogin = false;
        while (true) {
            View.printMenu(isLogin);
            int choice = Manager.checkInputChoice(isLogin);
            if (isLogin) {
                switch (choice) {
                    case 1:
                        isLogin = false;

                        break;
                    case 2:
                        System.exit(0);
                        break;
                }

            } else {
                switch (choice) {
                    case 1:
                        Manager.addAccount(lh);
                    case 2:
                        isLogin = Manager.login(lh);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }

    }

    public static int checkInputChoice(boolean isLogin) {
        int maxChoice = isLogin ? 2 : 3;
        while (true) {
            try {
                
                int choice = Integer.parseInt(view.getInput("Enter your choice: "));

                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                } else {
                    System.out.println("Must be in range 1-" + maxChoice);
                }
            } catch (Exception e) {
                System.err.println("Enter again");
            }
        }
    }

    public static String checkInputDate(String msg) {
        while (true) {
            try {

                String input = view.getInput(msg);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(input);

                Date today = Calendar.getInstance().getTime();
                if (date.equals(today) || date.after(today)) {
                    view.showError("Date must be in the past.");
                    continue;
                }

                if (input.equalsIgnoreCase(sdf.format(date))) {
                    return input;
                } else {
                    view.showError("Re-input");
                }

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

    public static String checkInputUsername(ArrayList<Human> lh, String msg) {
        while (true) {
            String input = checkInputString(msg);
            boolean exists = false;
            for (int i = 0; i < lh.size(); i++) {
                if (input.equalsIgnoreCase(lh.get(i).getUsername())) {
                    System.err.println("Username existed");
                    exists = true;
                    break;
                }

            }
            if (!exists) {
                return input;
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

    private static String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void addAccount(ArrayList<Human> lh) {
        String username = checkInputUsername(lh, "Enter Username: ");
        String password = checkInputString("Enter Password: ");
        String name = checkInputString("Enter Name: ");
        String phone = checkInputPhone("Enter phone: ");
        String email = checkInputEmail("Enter Email: ");
        String address = checkInputString("Enter Address: ");
        String dateOfBirth = checkInputDate("Enter Date of Birth: ");

        lh.add(new Human(username, MD5Encryption(password), name, phone, email, address, dateOfBirth));
        System.out.println(" Add Success!!");
    }

//    public static Human findAccount(ArrayList<Human> lh, String username, String password) {
//        for (int i = 0; i < lh.size(); i++) {
//            if (username.equalsIgnoreCase(lh.get(i).getUsername())) {
//                if (MD5Encryption(password).equalsIgnoreCase(lh.get(i).getPassword())) {
//                    return lh.get(i);
//                }
//            }
//        }
//        return null;
//    }
    
      public static Human findAccount(ArrayList<Human> la, String username, String password) {
        for (int i = 0; i < la.size(); i++) {
            if (username.equalsIgnoreCase(la.get(i).getUsername())) {
                if (MD5Encryption(password).equalsIgnoreCase(la.get(i).getPassword())) {
                    return la.get(i);
                } else {
                    return null;
                }
            }
        }
        return null;
    }


    public static void changePassword(Human accountLogin) {
        String choice;
        while (true) {
            choice = view.getInput("Do you want to change your pass word? (Y/n):");
            if (choice.length() == 0) {
                System.err.println("Not Empty!!!");

            } else if (choice.length() == 1 && choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("n")) {
                break;
            } else {
                System.err.println("Enter again: ");
            }

        }

        if (choice.equalsIgnoreCase("Y")) {

            int wrong = 0;

            while (wrong < 3) {
                String oldPassword = checkInputString("Old password: ");
                String newPassword = checkInputString("New password: ");
                String renewPassword = checkInputString("Renew Password");

                String encryptedOldPassword = MD5Encryption(oldPassword);
                String encryptedNewPassword = MD5Encryption(newPassword);

                boolean oldPasswordCorrect = MD5Encryption(oldPassword).equalsIgnoreCase(accountLogin.getPassword());
                boolean isNewPasswordValid = !MD5Encryption(newPassword).equalsIgnoreCase(accountLogin.getPassword())
                        && !accountLogin.getPreviousPasswords().contains(MD5Encryption(newPassword));

//                 boolean isNewPasswordValid = !MD5Encryption(newPassword).equals(accountLogin.getPassword())
//                                    && !accountLogin.getPreviousPasswords().contains(MD5Encryption(newPassword));
                boolean newPasswordMatch = newPassword.equalsIgnoreCase(renewPassword);

                if (!oldPasswordCorrect) {
                    System.err.println("Old password not found");
                }
                if (!newPasswordMatch) {
                    System.err.println("New password and Renew password are not the same");
                }

                if (oldPasswordCorrect && newPasswordMatch && isNewPasswordValid) {
                    accountLogin.setPassword(MD5Encryption(newPassword));
                    System.out.println("Change password success!!");

                } else {
                    wrong++;
                    if (wrong >= 3) {
                        System.err.println("Too many fail attemp. Exiting.");
                        break;
                    } else {
                        System.out.println("Please try again");
                    }
                }
            }
        }

    }

    public static boolean login(ArrayList<Human> lh) {
        if (lh.isEmpty()) {
            System.err.println("Account empty.");
            return false;
        }

        String username = checkInputString("Enter Username: ");
        String password = checkInputString("Enter Password");
        Human accountlogin = findAccount(lh, username, password);

        if (accountlogin != null) {
            System.out.println("Wellcome");
            System.out.println("Hi" + accountlogin.getUsername() + ", do you want change password now? Y/n: ");
            changePassword(accountlogin);
            return true;
        } else {
            System.err.println("Invalid username or password.");

            return false;
        }
    }
  
}
