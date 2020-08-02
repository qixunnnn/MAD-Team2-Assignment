package sg.edu.sg.mad_t02_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    public static final int MSG_TYPE_LEFT = 0;
    public static final int MSG_TYPE_RIGHT = 1;
    Context mContext;
    ArrayList<ChatModel> mChat;
    FirebaseUser fuser;

    public MessageAdapter(ArrayList<ChatModel> list, Context context) {
        this.mContext = context;
        this.mChat = list;

    }

    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_RIGHT) {
            View item = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right, parent, false);
            return new MessageViewHolder(item);
        } else
        {
            View item = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left, parent, false);
            return new MessageViewHolder(item);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position)
    {
        Log.d("ASD", String.valueOf(mChat.size()));
        holder.show_message.setText(mChat.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return mChat.size();
    }

    public int getItemViewType(int position)
    {
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        if (mChat.get(position).getSender().equals(fuser.getUid()))
        {
            return MSG_TYPE_RIGHT;
        }
        else
        {
            return MSG_TYPE_LEFT;
        }
    }

}
