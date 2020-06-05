package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GeneralContact extends AppCompatActivity {

    ArrayList<ContactModel> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_contact);

        setTitle("General Contact");

        contactList.add(new ContactModel("General Enquiries", "6466 6555", "askNP@np.edu.sg"));
        contactList.add(new ContactModel("Covid-19 Enquiries","6460 7888", "askCovid@np.edu.sg"));

        RecyclerView recyclerView = findViewById(R.id.generalrecycler);
        GeneralContactAdapter gAdapter = new GeneralContactAdapter(contactList);

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);

    }
}
