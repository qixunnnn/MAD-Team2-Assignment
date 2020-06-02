package sg.edu.sg.mad_t02_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    Context context;
    ArrayList<CourseModel> models;

    public CourseAdapter(Context context, ArrayList<CourseModel> models) {
        this.context = context;
        this.models = models;
    }

    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_itemlist,parent,false); //The layout for each row
        return new CourseViewHolder(item);
    }

    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.logo.setImageResource(models.get(position).getCourseLogo()); //Image source get from list model list. Image resource were used because images in resource folder is drawable
        holder.motto.setText(models.get(position).getCourseMotto());        //Set Motto text for each row from model list item.
        holder.name.setText(models.get(position).getCourseName());          //Set Name text for each row from model list item
    }

    @Override
    public int getItemCount() { //Total number of items in models.size
        return models.size();
    }
}
