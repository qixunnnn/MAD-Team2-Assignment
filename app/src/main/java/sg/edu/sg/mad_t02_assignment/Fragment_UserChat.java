package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Fragment_UserChat extends Fragment {

    private RecyclerView recyclerView;

    private F_UserContactAdapter contactAdapter;
    private ArrayList<UserData> mUsers;

    FirebaseUser fuser;
    DatabaseReference ref;

    private List<String> usersList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_chat, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_chat);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fuser = FirebaseAuth.getInstance().getCurrentUser();

        usersList = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Chats");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();

                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    ChatModel chat = snapshot.getValue(ChatModel.class);

                    if (chat.getSender().equals(fuser.getUid()))
                    {
                        usersList.add(chat.getReceiver());
                    }
                    if (chat.getReceiver().equals(fuser.getUid()))
                    {
                        usersList.add(chat.getSender());
                    }
                }

                readChats();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;

    }

    private void readChats() {
        mUsers = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("Users");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren())
                {
                    UserData userData = snapshot.getValue(UserData.class);

                    for (String id: usersList)
                    {
                        if (userData.getId().equals(id)){
                            if (mUsers.size() != 0)
                            {
                                for (UserData user1 : mUsers)
                                {
                                    if (!userData.getId().equals(user1.getId()))
                                    {
                                        mUsers.add(userData);
                                    }
                                }
                            } else
                            {
                                mUsers.add(userData);
                            }
                        }
                    }
                }
                contactAdapter = new F_UserContactAdapter(mUsers,getContext());
                recyclerView.setAdapter(contactAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
