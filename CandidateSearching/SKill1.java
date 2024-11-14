package candidate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class SKill1 {
    
    private String id;
    private String skillName;
    private int skillYear;

    public SKill1() {
    }

    public SKill1(String id, String skillName, int skillYear) {
        this.id = id;
        this.skillName = skillName;
        this.skillYear = skillYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillYear() {
        return skillYear;
    }

    public void setSkillYear(int skillYear) {
        this.skillYear = skillYear;
    }
    
    
    
}
