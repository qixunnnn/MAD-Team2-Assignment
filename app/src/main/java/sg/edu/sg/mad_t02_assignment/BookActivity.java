package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private final String TAG = "Book Activity";

    ArrayList<BookModel> bookModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        setTitle("Book Price");
        LoadInputData();
        //All books loaded
        Log.v(TAG,"All input Data Loaded");

        //Load RecyclerView
        RecyclerView recyclerView = findViewById(R.id.book_recycler);

        BookAdapter bAdapter = new BookAdapter(bookModelList);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bAdapter);

        Log.v(TAG, "Finished Pre-Initialization");
    }
    public void LoadInputData()
    {
        BookModel bookMode0 = new BookModel(R.drawable.eblbook,"Essentials of Business Law",36,"Business Law module textbook used by all Year 1 students taking courses in school of BA");
        bookModelList.add(bookMode0);
        BookModel bookModel1 = new BookModel(R.drawable.fmbook,"Financial Management",15,"Financial Management module textbook used students taking courses in school of DE");
        bookModelList.add(bookModel1);
        BookModel bookModel2 = new BookModel(R.drawable.embook,"Engineering Mathematics 1",25,"Engineering Mathematics 1 module textbook used by all Year 1 students taking courses in school of Engineering");
        bookModelList.add(bookModel2);
        BookModel bookModel3 = new BookModel(R.drawable.cdbook,"Child Development",53,"Child Development module textbook used by students taking courses in school of HMS");
        bookModelList.add(bookModel3);
        BookModel bookModel4 = new BookModel(R.drawable.fonbook,"Kozier & Erb's Fundamentals of Nursing",67,"Fundamentals of Nursing module textbook used by students taking courses in school of HS");
        bookModelList.add(bookModel4);
        BookModel bookModel5 = new BookModel(R.drawable.spcbook,"Social Psychology & Communication Textbook \n",20,"Social Psychology module textbook used by students taking courses in school of FMS");
        bookModelList.add(bookModel5);
        BookModel bookModel6 = new BookModel(R.drawable.cmbook,"Computing Mathematics",27,"Computing Mathematics module textbook used by all Year 1 students taking courses in school of ICT");
        bookModelList.add(bookModel6);
        BookModel bookModel7 = new BookModel(R.drawable.esbook,"Elementary Statistics",30,"Biostatistics / Applied Biostatistics module textbook used by students taking courses in school of LSCT");
        bookModelList.add(bookModel7);
    }
}
