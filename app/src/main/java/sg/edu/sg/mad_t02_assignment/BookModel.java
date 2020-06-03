package sg.edu.sg.mad_t02_assignment;

public class BookModel {

    private int BookImage;
    private String BookName;
    private int BookPrice;
    private String BookDescription;

    public BookModel(int bookImage, String bookName, int bookPrice, String bookDescription) {
        BookImage = bookImage;
        BookName = bookName;
        BookPrice = bookPrice;
        BookDescription = bookDescription;
    }

    public int getBookImage() {
        return BookImage;
    }

    public String getBookName() {
        return BookName;
    }

    public int getBookPrice() {
        return BookPrice;
    }

    public String getBookDescription() {
        return BookDescription;
    }
}
