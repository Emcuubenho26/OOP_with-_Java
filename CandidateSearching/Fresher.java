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
public class Fresher extends Candidate {

    private String granduationDate;
    private String granduationRank;

    public Fresher() {
        super();
    }

    public Fresher(String granduationDate, String granduationRank, String id, String firstName, String lastName, String DoB, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, DoB, address, phone, email, typeCandidate);
        this.granduationDate = granduationDate;
        this.granduationRank = granduationRank;
    }

    public String getGranduationDate() {
        return granduationDate;
    }

    public void setGranduationDate(String granduationDate) {
        this.granduationDate = granduationDate;
    }

    public String getGranduationRank() {
        return granduationRank;
    }

    public void setGranduationRank(String granduationRank) {
        this.granduationRank = granduationRank;
    }

    
    
}
