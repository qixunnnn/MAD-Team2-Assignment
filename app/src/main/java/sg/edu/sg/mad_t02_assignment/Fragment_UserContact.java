package sg.edu.sg.mad_t02_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class Fragment_UserContact extends Fragment {

    private RecyclerView recyclerView;
    private F_UserContactAdapter contactAdapter;
    private ArrayList<UserData> mUsers;

    FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();

    String cUid = fUser.getUid();
    String role;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_contact, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_contact);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUsers = new ArrayList<>();

        findRole(cUid);
        getAllAdmin();

        return view;
    }
    private void findRole(String cUid) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(cUid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 role = snapshot.child("role").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

        private void getAllAdmin() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mUsers.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    UserData userData = dataSnapshot.getValue(UserData.class);
                    Log.v("ASD", role);

                    if (userData.getUsername() != null) {
                        if (userData.getRole().equals("admin")) {
                            mUsers.add(userData);
                        }
                    }

                }
                contactAdapter = new F_UserContactAdapter(mUsers,getContext(),role);
                recyclerView.setAdapter(contactAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
