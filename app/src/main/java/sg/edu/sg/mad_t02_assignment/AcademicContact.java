package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AcademicContact extends AppCompatActivity {

    ArrayList<ContactModel> contactList = new ArrayList<>();
    int itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_contact);

        setTitle("Academic Contact");

        contactList.add(new ContactModel("School of Business & Accountancy\n" + "(Tan Hui Hui)","6460 8324","Sch-BA@np.edu.sg"));

        RecyclerView recyclerView = findViewById(R.id.academicrecycler);
        GeneralContactAdapter gAdapter = new GeneralContactAdapter(contactList);

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);


    }
}
