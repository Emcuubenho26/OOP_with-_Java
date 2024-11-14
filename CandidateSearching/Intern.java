/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candidate;

/**
 *
 * @author DELL
 */
public class Intern extends Candidate{
    private String major;
    private String semester;
    private String university;

    public Intern() {
        super();
    }

    public Intern(String major, String semester, String university, String id, String firstName, String lastName, String DoB, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, DoB, address, phone, email, typeCandidate);
        this.major = major;
        this.semester = semester;
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    
    
    
    
}
