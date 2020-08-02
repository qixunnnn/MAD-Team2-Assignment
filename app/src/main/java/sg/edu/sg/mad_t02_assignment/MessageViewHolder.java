package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    TextView show_message;
    ImageView profile_image;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);

        show_message = itemView.findViewById(R.id.show_message);

    }
}
