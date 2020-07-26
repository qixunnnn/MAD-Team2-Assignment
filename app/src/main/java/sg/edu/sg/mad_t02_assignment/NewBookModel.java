package sg.edu.sg.mad_t02_assignment;

public class NewBookModel {
    private String NBookImage;
    private String NBookName;
    private Float NBookPrice;
    private String NBookDescription;

    public NewBookModel(){

    }

    public NewBookModel(String NBookImage, String NBookName, Float NBookPrice, String NBookDescription) {
        this.NBookImage = NBookImage;
        this.NBookName = NBookName;
        this.NBookPrice = NBookPrice;
        this.NBookDescription = NBookDescription;
    }

    public String getNBookImage() {
        return NBookImage;
    }

    public void setNBookImage(String NBookImage) {
        this.NBookImage = NBookImage;
    }

    public String getNBookName() {
        return NBookName;
    }

    public void setNBookName(String NBookName) {
        this.NBookName = NBookName;
    }

    public Float getNBookPrice() {
        return NBookPrice;
    }

    public void setNBookPrice(Float NBookPrice) {
        this.NBookPrice = NBookPrice;
    }

    public String getNBookDescription() {
        return NBookDescription;
    }

    public void setNBookDescription(String NBookDescription) {
        this.NBookDescription = NBookDescription;
    }
}
