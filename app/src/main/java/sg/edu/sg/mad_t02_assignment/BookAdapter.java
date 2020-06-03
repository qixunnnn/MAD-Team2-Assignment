package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

     ArrayList<BookModel> bookModelList;

    public BookAdapter(ArrayList<BookModel> bookModelList) {
        this.bookModelList = bookModelList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_itemlist,parent,false);
        return new BookViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bookImage.setImageResource(bookModelList.get(position).getBookImage());
        holder.bookDescription.setText(bookModelList.get(position).getBookDescription());
        holder.bookPrice.setText("$ " + String.valueOf(bookModelList.get(position).getBookPrice()));
        holder.bookName.setText(bookModelList.get(position).getBookName());
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }
}
