package sg.edu.sg.mad_t02_assignment;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolViewHolder> {

    private int imagesss[];
    private Context context;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Schools");


    public SchoolAdapter(int input[], Context c){
        imagesss = input;
        context = c;
    }

    public SchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_itemlist,parent,false);
        return new SchoolViewHolder(item);
    }

    public void onBindViewHolder(SchoolViewHolder holder, final int position) {
        holder.schoolImage.setImageResource(imagesss[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),CourseActivity.class);
                i.putExtra("pos",position);   //Pass the value of position to CourseAcitivity to locate the list to be added
                context.startActivity(i);

            }
        });

    }

    public int getItemCount() {
        return imagesss.length;
    }


}
