package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolViewHolder extends RecyclerView.ViewHolder {

    ImageView schoolImage;
    public SchoolViewHolder(@NonNull View itemView) {
        super(itemView);
        schoolImage = itemView.findViewById(R.id.school_image);
    }
}
