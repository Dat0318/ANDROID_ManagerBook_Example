package com.example.practiceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private TextView txtBookName, txtAuthor, txtPages, txtDescriptions;
    private Button btnAddToWantRead, btnAddToAlreadyRead, btnAddToCurrentlyReading,btnAddToFavorites;
    private ImageView bookImage;
    static final String BOOK_ID_KEY = "bookId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String LongDescriptions = "you are a young man and i see a practical code man, keep camp and your promise, loyal in each your action. I pround of you"
//                +"if your father still alive, I beliverd that him wont say you were up, your name will be a legen in our mysteries. hope every thing will come like your wish. keep your heath."
//                +"your best friend. No one.";
//        Book book = new Book(1,"1Q84","Haruki Marakami","https://assets.awwwards.com/assets/images/book/2019/now/header/slide-01.jpg","short description for a book", LongDescriptions);
//        setData(book);

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);

            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);
                    
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
    }

    private void handleFavoriteBooks(Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getFavoritesBooks();

        boolean existInFavoriteBooks = false;

        for(Book b: wantToReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInFavoriteBooks = true;
            }
        }

        if (existInFavoriteBooks) {
            btnAddToFavorites.setEnabled(false);
        } else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToFavoriteBook(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, FavoriteBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existInCurrentBooks = false;

        for(Book b: wantToReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInCurrentBooks = true;
            }
        }

        if (existInCurrentBooks) {
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToCurrentRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, CurrentReadBook.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for(Book b: wantToReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInWantToReadBooks = true;
            }
        }

        if (existInWantToReadBooks) {
            btnAddToWantRead.setEnabled(false);
        } else {
            btnAddToWantRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToWantToRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and Disable button
     * Add the book to Already read Book ArrayList
     * @param incomingBook
     */
    private void handleAlreadyRead(Book incomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for(Book b: alreadyReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToAlreadyRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
//        txtPage.setText(book.getPages());
        txtDescriptions.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {
        txtAuthor = findViewById(R.id.txtAuthor);
        txtBookName = findViewById(R.id.txtBookName);
        txtPages = findViewById(R.id.txtPages);
        txtDescriptions = findViewById(R.id.txtDescription);

        btnAddToWantRead = findViewById(R.id.btnWantRead);
        btnAddToAlreadyRead = findViewById(R.id.btnReadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnCurrentRead);
        btnAddToFavorites = findViewById(R.id.btnAddFavorite);

        bookImage = findViewById(R.id.imgBook);
    }
}