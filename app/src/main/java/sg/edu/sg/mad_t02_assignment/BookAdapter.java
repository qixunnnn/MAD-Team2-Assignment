package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private ArrayList<BookModel> bookModelList;
    private Context bookContext;

    public BookAdapter(ArrayList<BookModel> bookModelList) {
        this.bookModelList = bookModelList;
        this.bookContext = bookContext;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_itemlist,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        int bookImage = bookModelList.get(position).getBookImage();
        String bookName = bookModelList.get(position).getBookName();
        int bookPrice = bookModelList.get(position).getBookPrice();
        String bookDescription = bookModelList.get(position).getBookDescription();
        holder.setData(bookImage,bookName,bookPrice,bookDescription);
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }

}
