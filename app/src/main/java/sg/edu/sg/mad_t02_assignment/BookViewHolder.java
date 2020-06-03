package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {

         ImageView bookImage;
         TextView bookName;
         TextView bookPrice;
         TextView bookDescription;

        public BookViewHolder(@NonNull View itemView){
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_image);
            bookName = itemView.findViewById(R.id.book_name);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookDescription = itemView.findViewById(R.id.book_description);
        }


}
