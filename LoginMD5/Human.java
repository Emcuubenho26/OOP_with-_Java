
import java.util.*;


public class Human {

    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dateOfBirth;
     private List<String> previousPasswords = new ArrayList<>();

    public Human() {
    }

    public Human(String username, String password, String name, String phone, String email, String address, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        
        
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    
    public void setPassword(String newPassword) {
        if (previousPasswords.size() == 2) {
            previousPasswords.remove(0);
        }
                
        previousPasswords.add(password);
        this.password = newPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPreviousPasswords() {
        return previousPasswords;
    }

    public void setPreviousPasswords(List<String> previousPasswords) {
        this.previousPasswords = previousPasswords;
    }

    
    
}
