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

        BookModel bookModel = new BookModel(R.drawable.cmbook,"Computing Mathematics",27,"Computing Mathematics module used by all course in ICT Year 1 Students");
        bookModelList.add(bookModel);

        RecyclerView recyclerView = findViewById(R.id.book_recycler);

        BookAdapter bAdapter = new BookAdapter(bookModelList);
        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bAdapter);

        Log.v(TAG, "Finished Pre-Initialization");
    }
}
