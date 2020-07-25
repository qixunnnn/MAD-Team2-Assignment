package sg.edu.sg.mad_t02_assignment;

public class UserData {

    private String profile_pic;
    private String role;
    private String username;
    private String id;

    public UserData(){

    }

    public UserData(String profile_pic, String role, String username, String id) {
        this.profile_pic = profile_pic;
        this.role = role;
        this.username = username;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
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
