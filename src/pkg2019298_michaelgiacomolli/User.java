
package pkg2019298_michaelgiacomolli;


public class User {
    
    private String email;
    private String password;
    
    private String name;
    private String mobile;
    
    private String address;
    
    public User(String email, String password, String name, String mobile, String address){
        this.email = email;
        this.password = password;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public String getAddress() {
        return address;
    }
    
}
