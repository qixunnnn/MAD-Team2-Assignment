package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private final String TAG = "Book Activity";

    private RecyclerView bookRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        bookRecyclerView = findViewById(R.id.book_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        bookRecyclerView.setLayoutManager(layoutManager);

        ArrayList<BookModel> bookModelList = new ArrayList<>();
        bookModelList.add(new BookModel(R.drawable.cmbook,"Computing Mathematics",27,"Computing Mathematics module used by all courses in ICT for Year 1 Students"));

        BookAdapter bAdapter = new BookAdapter(bookModelList);
        bookRecyclerView.setAdapter(bAdapter);
        bAdapter.notifyDataSetChanged();
    }
}
