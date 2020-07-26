package sg.edu.sg.mad_t02_assignment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    Context context;
    ArrayList<CourseModel> models;
    String schoolname;

    public CourseAdapter(Context context, ArrayList<CourseModel> models, String schoolname) {
        this.context = context;
        this.models = models;
        this.schoolname = schoolname;
    }

    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_itemlist, parent, false); //The layout for each row
        return new CourseViewHolder(item);
    }

    public void onBindViewHolder(@NonNull CourseViewHolder holder, final int position) {
        holder.logo.setImageResource(getSchoolLogo()); //Image source get from list model list. Image resource were used because images in resource folder is drawable
        holder.motto.setText(models.get(position).getCourseMotto());        //Set Motto text for each row from model list item.
        holder.name.setText(models.get(position).getCourseName());          //Set Name text for each row from model list item

        Log.v("ASD", context.getClass().getSimpleName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context.getClass() == CourseActivity.class) {
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse(models.get(position).getCourseURL()));
                    context.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() { //Total number of items in models.size
        return models.size();
    }

    private int getSchoolLogo() {
        int logo = 0;

        if (schoolname == "BA") {
            logo = R.drawable.balogo;
        } else if (schoolname == "DE") {
            logo = R.drawable.delogo;
        } else if (schoolname == "Engineering") {
            logo = R.drawable.soelogo;
        } else if (schoolname == "HMS") {
            logo = R.drawable.hmslogo;
        } else if (schoolname == "FMS") {
            logo = R.drawable.fmslogo;
        } else if (schoolname == "ICT") {
            logo = R.drawable.ictlogo;
        } else if (schoolname == "LSCT") {
            logo = R.drawable.lsctlogo;
        }

        return logo;

    }
}
