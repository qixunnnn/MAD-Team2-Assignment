package sg.edu.sg.mad_t02_assignment;

public class UserData {

    private String Username;
    private String Password;

    public UserData(){

    }
    public UserData(String username, String password){
        this.Username = username;
        this.Password = password;

    }

    public String getUsername(){
        return this.Username;
    }

    public void setUsername(String username){
        this.Username = username;
    }

    public String getPassword(){
        return this.Password;
    }

    public void setPassword(String password){
        this.Password = password;
    }
}
