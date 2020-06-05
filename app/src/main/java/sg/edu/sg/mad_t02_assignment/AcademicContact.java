package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class AcademicContact extends AppCompatActivity {

    ArrayList<ContactModel> contactList = new ArrayList<>();
    final static String TAG = "Academic Contact";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_contact);

        setTitle("Academic Contact");
        LoadContactInfo(); //Loaded all contact information from another method
        Log.v(TAG,"Contact info added to the list!");

        RecyclerView recyclerView = findViewById(R.id.academicrecycler);
        GeneralContactAdapter gAdapter = new GeneralContactAdapter(contactList);

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gAdapter);
        Log.v(TAG, "Finished Pre-Initialization");


    }

    public void LoadContactInfo()
    {
        contactList.add(new ContactModel("School of Business & Accountancy\n" + "(Tan Hui Hui)","6460 8324","Sch-BA@np.edu.sg"));
        contactList.add(new ContactModel("School of Business & Accountancy\n" + "(Wong Siew Fatt)","6460 7764","Sch-BA@np.edu.sg"));
        contactList.add(new ContactModel("School of Design & Environment\n" + "(Debby Lee)","6460 6973","debby_lee@np.edu.sg"));
        contactList.add(new ContactModel("School of Film & Media Studies\n" + "(Eric Tan)","6460 8152","Eric_TAN@np.edu.sg"));
        contactList.add(new ContactModel("School of Engineering\n" + "(Saleha Bte Salleh)","6460 6425","saleha_SALLEH@np.edu.sg"));
        contactList.add(new ContactModel("School of Engineering\n" + "(Ang Hwee Keng)","6460 8119","Ang_Hwee_Keng@np.edu.sg"));
        contactList.add(new ContactModel("School of Engineering\n" + "(Sharon Lim)","6460 6305","Sharon_BY_Lim@np.edu.sg"));
        contactList.add(new ContactModel("School of Humanities & Social Sciences\n" + "(Aaron Lee)","6460 8170","Aaron_LEE@np.edu.sg"));
        contactList.add(new ContactModel("School of Humanities & Social Sciences\n" + "(Wong-Lim Leck Hoon)","6460 8974","LIM_Leck_Hoon@np.edu.sg"));
        contactList.add(new ContactModel("School of Health Sciences\n" + "(Goh Peng Wah)","6460 6125","GOH_Peng_Wah@np.edu.sg"));
        contactList.add(new ContactModel("School of Health Sciences\n" + "(Mr Abel Lee)","6460 6660","Abel_Lee@np.edu.sg"));
        contactList.add(new ContactModel("School of InfoComm Technology\n" + "(Siti Nur Shahidah Hashim)","6460 6838","Siti_Nur_Shahidah_HASHIM@np.edu.sg"));
        contactList.add(new ContactModel("School of InfoComm Technology\n" + "(Fang Jing Xi)","6460 6860","FANG_Jing_Xi@np.edu.sg"));
        contactList.add(new ContactModel("School of Life Sciences & Chemical Technology\n" + "(Christina Ching Kwee Leng)","6460 8475","Christina_CHING@np.edu.sg"));
        contactList.add(new ContactModel("School of Life Sciences & Chemical Technology\n" + "(Yeo-Lim Sor Khim)","6460 8011","YEO-LIM_Sor_Khim@np.edu.sg"));
        contactList.add(new ContactModel("School of Interdisciplinary Studies\n" + "(CHAN-LOH_Wai Cheng)","6460 6570","CHAN-LOH_Wai_Cheng@np.edu.sg"));
        contactList.add(new ContactModel("School of Interdisciplinary Studies\n" + "(SETO-NG Beng Kiang Edalene)","6460 8366","SETO-NG-Beng-Kiang@np.edu.sg"));
    }
}
