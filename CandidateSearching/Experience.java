/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Experience extends Candidate{
  //  private int yearExperience;
    //private String professionalSkill;

    private ArrayList<SKill1> skills = new ArrayList<>();
    
    public Experience() {
        super();
    }

    public Experience(int yearExperience, String professionalSkill, String id, String firstName, String lastName, String DoB, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, DoB, address, phone, email, typeCandidate);
      //  this.yearExperience = yearExperience;
     //   t//his.professionalSkill = professionalSkill;
    }

    public ArrayList<SKill1> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<SKill1> skills) {
        this.skills = skills;
    }

    
    public void addSkills(ArrayList<SKill1> skills) {
       
    }

    
    
    
    
    
}
