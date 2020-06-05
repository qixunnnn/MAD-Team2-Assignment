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

        contactList.add(new ContactModel("General Enquiries", "6466 6555\n Name: Tan AH kao", "askNP@np.edu.sg"));
        contactList.add(new ContactModel("Covid-19 Enquiries","6460 7888", "askCovid@np.edu.sg"));
        contactList.add(new ContactModel("Admissions for Full-time Diplomas","6463 1233", "admissions@np.edu.sg"));
        contactList.add(new ContactModel("CET Academy for Lifelong Learning","6460 6353", "enquiryCET@np.edu.sg"));
        contactList.add(new ContactModel("Exams & Graduation","6467 8911", "exams@np.edu.sg"));
        contactList.add(new ContactModel("Student Care and Counselling Helpline", "6460 6380", "-"));
        contactList.add(new ContactModel("Crisis Helpline\n" +
                "(For life-threatening emergencies)", "6460 6777", "-"));
        contactList.add(new ContactModel("Campus Security", "6460 6999", "-"));
        contactList.add(new ContactModel("Financial Matters (Fee Payment)", "6460 6215", "fin_student@np.edu.sg"));
        contactList.add(new ContactModel("Financial Assistance (Bursaries & Loans)", "6460 7553", "Dorothea_Ong@np.edu.sg"));
        RecyclerView recyclerView = findViewById(R.id.generalrecycler);
        GeneralContactAdapter gAdapter = new GeneralContactAdapter(contactList);

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);

    }
}
