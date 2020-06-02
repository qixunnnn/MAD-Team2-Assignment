package sg.edu.sg.mad_t02_assignment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseViewHolder extends RecyclerView.ViewHolder {
    ImageView logo;
    TextView name;
    TextView motto;

    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);
        logo = itemView.findViewById(R.id.course_logo);
        name = itemView.findViewById(R.id.course_name);
        motto = itemView.findViewById(R.id.course_motto);
    }
}
