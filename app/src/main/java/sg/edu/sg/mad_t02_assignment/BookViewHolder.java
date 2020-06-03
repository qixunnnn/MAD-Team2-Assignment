package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {

        private ImageView bookImage;
        private TextView bookName;
        private TextView bookPrice;
        private TextView bookDescription;

        public BookViewHolder(@NonNull View itemView){
            super(itemView);

            bookImage = itemView.findViewById(R.id.book_image);
            bookName = itemView.findViewById(R.id.book_name);
            bookPrice = itemView.findViewById(R.id.book_price);
            bookDescription = itemView.findViewById(R.id.book_description);
        }
        public void setData(int bImage,String bName,int bPrice, String bDescription){
            bookImage.setImageResource(bImage);
            bookName.setText(bName);
            bookPrice.setText(bPrice);
            bookDescription.setText(bDescription);
        }

}
