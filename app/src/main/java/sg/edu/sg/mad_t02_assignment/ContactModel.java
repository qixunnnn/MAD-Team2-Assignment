package sg.edu.sg.mad_t02_assignment;

public class ContactModel {
    private String Title;
    private String Telephone;
    private String Email;

    public ContactModel(String title, String tel, String email){
        this.Title = title;
        this.Telephone = tel;
        this.Email = email;

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
