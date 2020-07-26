package sg.edu.sg.mad_t02_assignment;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    private final String TAG = "Book Activity";

    private RecyclerView bookRecyclerView;
    private BookAdapter bookAdapter;

    private DatabaseReference dbRef;
    ArrayList<NewBookModel> bookModelList = new ArrayList<>();

    private BookViewHolder bookViewHolder;
    private Context bContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        final RecyclerView bookRecyclerView = findViewById(R.id.book_recycler);

        bookRecyclerView.setHasFixedSize(true);
        bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bookModelList = new ArrayList<>();

        dbRef = FirebaseDatabase.getInstance().getReference("Books");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postsnapshot : snapshot.getChildren()){
                    NewBookModel uploadBook = postsnapshot.getValue(NewBookModel.class);
                    bookModelList.add(uploadBook);
                }
                bookAdapter = new BookAdapter(BookActivity.this,bookModelList);

                bookRecyclerView.setAdapter(bookAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BookActivity.this,"Error getting info.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

// old recyclerview
//        setTitle("Book Price");
//        LoadInputData();
//        //All books loaded
//        Log.v(TAG,"All input Data Loaded");
//
//        //Load RecyclerView
//        RecyclerView recyclerView = findViewById(R.id.book_recycler);
//
//        BookAdapter bAdapter = new BookAdapter(bookModelList);
//        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setLayoutManager(sLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(bAdapter);
//
//        Log.v(TAG, "Finished Pre-Initialization");
//    }
//    public void LoadInputData()
//    {
//        BookModel bookMode0 = new BookModel(R.drawable.eblbook,"Essentials of Business Law",36,"Business Law module textbook used by all Year 1 students taking courses in school of BA");
//        bookModelList.add(bookMode0);
//        BookModel bookModel1 = new BookModel(R.drawable.fmbook,"Financial Management",15,"Financial Management module textbook used students taking courses in school of DE");
//        bookModelList.add(bookModel1);
//        BookModel bookModel2 = new BookModel(R.drawable.embook,"Engineering Mathematics 1",25,"Engineering Mathematics 1 module textbook used by all Year 1 students taking courses in school of Engineering");
//        bookModelList.add(bookModel2);
//        BookModel bookModel3 = new BookModel(R.drawable.cdbook,"Child Development",53,"Child Development module textbook used by students taking courses in school of HMS");
//        bookModelList.add(bookModel3);
//        BookModel bookModel4 = new BookModel(R.drawable.fonbook,"Kozier & Erb's Fundamentals of Nursing",67,"Fundamentals of Nursing module textbook used by students taking courses in school of HS");
//        bookModelList.add(bookModel4);
//        BookModel bookModel5 = new BookModel(R.drawable.spcbook,"Social Psychology & Communication Textbook \n",20,"Social Psychology module textbook used by students taking courses in school of FMS");
//        bookModelList.add(bookModel5);
//        BookModel bookModel6 = new BookModel(R.drawable.cmbook,"Computing Mathematics",27,"Computing Mathematics module textbook used by all Year 1 students taking courses in school of ICT");
//        bookModelList.add(bookModel6);
//        BookModel bookModel7 = new BookModel(R.drawable.esbook,"Elementary Statistics",30,"Biostatistics / Applied Biostatistics module textbook used by students taking courses in school of LSCT");
//        bookModelList.add(bookModel7);
//    }

