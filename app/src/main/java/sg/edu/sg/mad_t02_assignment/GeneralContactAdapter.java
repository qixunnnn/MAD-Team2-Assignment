package sg.edu.sg.mad_t02_assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GeneralContactAdapter extends RecyclerView.Adapter<GeneralContactViewHolder> {

    ArrayList<ContactModel> cList;
    int selectedItemlist;

    public GeneralContactAdapter(ArrayList<ContactModel> list){

        this.cList = list;
    }

    @NonNull
    @Override
    public GeneralContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.generalcontact_itemlist,parent,false);
        return new GeneralContactViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull GeneralContactViewHolder holder, int position) {
        holder.title.setText(cList.get(position).getTitle());
        holder.number.setText(cList.get(position).getTelephone());
        holder.email.setText(cList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return cList.size();
    }
}
