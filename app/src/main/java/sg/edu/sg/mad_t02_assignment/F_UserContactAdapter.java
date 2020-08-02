package sg.edu.sg.mad_t02_assignment;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class F_UserContactAdapter extends RecyclerView.Adapter<F_UserContactViewHolder> {

    Context mContext;
    ArrayList<UserData> mUsers;

    public F_UserContactAdapter(ArrayList<UserData> list, Context context) {
        this.mContext = context;
        this.mUsers = list;

    }

    public F_UserContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.usercontact_item,parent,false);
        return new F_UserContactViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull F_UserContactViewHolder holder, final int position) {
        holder.username.setText(mUsers.get(position).getUsername());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, MessageActivity.class);
                i.putExtra("userid", mUsers.get(position).getId());
                mContext.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}
