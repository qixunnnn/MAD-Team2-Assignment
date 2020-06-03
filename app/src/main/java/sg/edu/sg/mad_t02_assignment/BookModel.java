package sg.edu.sg.mad_t02_assignment;

public class BookModel {

    private int BookImage;
    private String BookName;
    private int BookPrice;
    private String BookDescription;

    public BookModel(){

    }

    public BookModel(int bookImage, String bookName, int bookPrice, String bookDescription) {
        BookImage = bookImage;
        BookName = bookName;
        BookPrice = bookPrice;
        BookDescription = bookDescription;
    }

    public int getBookImage() {
        return BookImage;
    }

    public void setBookImage(int bookImage) {
        BookImage = bookImage;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public int getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(int bookPrice) {
        BookPrice = bookPrice;
    }

    public String getBookDescription() {
        return BookDescription;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }
}
