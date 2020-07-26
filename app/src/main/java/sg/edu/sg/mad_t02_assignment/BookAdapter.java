package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private Context bContext;
    ArrayList<NewBookModel> bookModelList;

    public BookAdapter(Context bContext, ArrayList<NewBookModel> bookModelList) {
        this.bContext = bContext;
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
        NewBookModel uploadBook = bookModelList.get(position);

        Picasso.get().load(uploadBook.getNBookImage()).fit().centerCrop().into(holder.bookImage);
        holder.bookDescription.setText(bookModelList.get(position).getNBookDescription());
        holder.bookPrice.setText("$ " + String.valueOf(bookModelList.get(position).getNBookPrice()));
        holder.bookName.setText(bookModelList.get(position).getNBookName());

    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }
}
