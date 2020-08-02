package sg.edu.sg.mad_t02_assignment;

public class UserData {

    private String email;
    private String id;
    private String role;
    private String username;

    public UserData(){

    }

    public UserData(String email, String id, String role, String username) {
        this.email = email;
        this.role = role;
        this.username = username;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
