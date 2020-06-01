package sg.edu.sg.mad_t02_assignment;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolViewHolder> {

    private int imagesss[];
    private Context context;

    public SchoolAdapter(int input[], Context c){
        imagesss = input;
        context = c;
    }

    public SchoolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_itemlist,parent,false);
        return new SchoolViewHolder(item);
    }

    public void onBindViewHolder(SchoolViewHolder holder, int position) {
        holder.schoolImage.setImageResource(imagesss[position]);
    }

    public int getItemCount() {
        return imagesss.length;
    }
}
