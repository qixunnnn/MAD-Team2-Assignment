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
    String role;

    public F_UserContactAdapter(ArrayList<UserData> list, Context context, String role) {
        this.mContext = context;
        this.mUsers = list;
        this.role = role;

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
        holder.circleImageView.setImageResource(getImageID(position));
    }


    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    private int getImageID(int position) {

        String username = mUsers.get(position).getUsername();
        if (username.equals("CCA Enquiries")) {
            return R.drawable.cca;
        }
        else if (username.equals("Covid-19 Enquiries"))
        {
            return R.drawable.covid;
        }
        else if (username.equals("General Enquiries"))
        {
            return R.drawable.general;
        }
        else if (username.equals("Financial Assistance"))
        {
            return R.drawable.financial;
        }
        return R.drawable.logo3;
    }
}
