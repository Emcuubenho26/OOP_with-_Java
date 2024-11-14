/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author DELL
 */
public class Controller {
    
    static ArrayList<Candidate> candidates = new ArrayList<>();
    
     static Validation validation = new Validation();
     public static void createCandidate(int type) {
        while (true) {
            String id;
            while (true) {
                id = validation.checkInputString("Enter firstname");
                if (validation.checkIdExist(candidates, id)) {
                    break;
                } else {
                    System.out.println("ID is existed");
                }
            }
            String firstName = validation.checkInputString("Enter first name:");
            String lastName = validation.checkInputString("Enter last name:");
            int birthDate = validation.inputInt("Enter bithdate:", 1900,Calendar.getInstance().get(Calendar.YEAR));
            String address = validation.checkInputString("Enter address");
            String phone = validation.checkInputPhone("Enrer phone:");
            String email = validation.checkInputEmail("Enter email:");
            switch (type) {
                case 0:
                    int yearExperience = validation.inputInt("Enter year of experience:", 0, 100);
                    String professionalSkill = validation.checkInputString("Enter professional skill:");
                    
                    
                    
                    candidates.add(new Experience(yearExperience, professionalSkill, id, firstName, lastName, id, address, phone, email, birthDate));
                    
                    
                    
                    break;
                case 1:
                    String graduationDate = validation.checkInputString("Enter graduation date:");
                    String graduationRank = validation.checkInputGraduationRank("Enter graduation rank: ");
                    candidates.add(new Fresher(graduationDate, graduationRank, id, firstName, lastName, id, address, phone, email, birthDate));
                    break;
                case 2:
                    String major = validation.checkInputString("Enter major:");
                    String semester = validation.checkInputString("Enter major:");
                    String university = validation.checkInputString("Enter university:");
                    candidates.add(new Intern(major, semester, university, id, firstName, lastName, id, address, phone, email, birthDate));
                    break;
            }
            System.out.print("Do you want to continue (Y/N): ");
           
        }
    }

    public static void searchCandidate() {
        printListNameCandidate();
        String nameSearch = validation.checkInputString("Enter andidate name (First name or Last name):");
        int typeCandidate = validation.inputInt("Enter type of candidate", 0, 2);
        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }

    public static void printListNameCandidate() {
        int countExperience = 0;
        int countFresher = 0;
        int countIntern = 0;
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                countExperience++;
                if (countExperience == 1) {
                    System.out.println("Experience Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
            if (candidate instanceof Fresher) {
                countFresher++;
                if (countFresher == 1) {
                    System.out.println("Fresher Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
            if (candidate instanceof Intern) {
                countIntern++;
                if (countIntern == 1) {
                    System.out.println("Internship Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
    
    public static void run(){
        while (true) {
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            int choice = validation.inputInt("Enter your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    createCandidate(0);
                    break;
                case 2:
                    createCandidate(1);
                    break;
                case 3:
                    createCandidate(2);
                    break;
                case 4:
                    searchCandidate();
                    break;
                case 5:
                    return;
            }
        }
    }
    
    
}
