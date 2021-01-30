package com.example.practiceapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BookRecViewAdapter(this,"allBooks");
        booksRecView = findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));

//        ArrayList<Book> books = new ArrayList<>();
//        books.add(new Book(1,"1Q84","Haruki Marakami","https://assets.awwwards.com/assets/images/book/2019/now/header/slide-01.jpg","short description for a book", "long description for book content"));
//        books.add(new Book(2,"1Q85","Haruki Sukuman","https://cdn.thespaces.com/wp-content/uploads/2018/05/Island-caruso-st-john-marcus-taylor-cover-2-1024x663.jpg","short description for a book", "long description for book content"));
//        books.add(new Book(3,"1Q86","Haruki KonoiChi","https://shadycharacters.co.uk/wp/wp-content/uploads/2016/12/Book_IMG_1754-1-e1481474081467.jpg","short description for a book", "long description for book content"));
//        books.add(new Book(4,"1Q87","Haruki Masuro","https://www.thebalance.com/thmb/w4syTJBkKMI7QDfXQPee3boybtU=/683x512/smart/filters:no_upscale()/ScreenShot2019-10-14at9.34.06AM-757b2b342fd448b88804abe6c96e122a.png","short description for a book", "long description for book content"));
//        books.add(new Book(5,"1Q88","Haruki Okasame","https://media.gq.com/photos/5ad64204c8be07604e8b5f2f/16:9/w_2000,h_1125,c_limit/21-books-GQ-April-2018-041718-3x2.jpg","short description for a book", "long description for book content"));
//
//        adapter.setBooks(books);

        adapter.setBooks(Utils.getInstance(this).getAllBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
    }
}
