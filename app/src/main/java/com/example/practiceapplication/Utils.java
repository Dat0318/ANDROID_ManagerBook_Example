package com.example.practiceapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEYS = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";

    private static Utils instance;
    private SharedPreferences sharedPreferences;

//    private static ArrayList<Book> allBooks;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadingBooks;
//    private static ArrayList<Book> favoritesBooks;
    private static final String TAG = "Utils";

    private Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if (getAllBooks() == null) {
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getAlreadyReadBooks() == null) {
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if (getWantToReadBooks() == null) {
            editor.putString(WANT_TO_READ_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if (getCurrentlyReadingBooks() == null) {
            editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

        if (getFavoritesBooks() == null) {
            editor.putString(FAVORITE_BOOKS, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "1Q84", "Haruki Marakami", "https://assets.awwwards.com/assets/images/book/2019/now/header/slide-01.jpg", "short description for a book", "long description for book content"));
        books.add(new Book(2, "1Q85", "Haruki Sukuman", "https://cdn.thespaces.com/wp-content/uploads/2018/05/Island-caruso-st-john-marcus-taylor-cover-2-1024x663.jpg", "short description for a book", "long description for book content"));
        books.add(new Book(3, "1Q86", "Haruki KonoiChi", "https://shadycharacters.co.uk/wp/wp-content/uploads/2016/12/Book_IMG_1754-1-e1481474081467.jpg", "short description for a book", "long description for book content"));
        books.add(new Book(4, "1Q87", "Haruki Masuro", "https://www.thebalance.com/thmb/w4syTJBkKMI7QDfXQPee3boybtU=/683x512/smart/filters:no_upscale()/ScreenShot2019-10-14at9.34.06AM-757b2b342fd448b88804abe6c96e122a.png", "short description for a book", "long description for book content"));
        books.add(new Book(5, "1Q88", "Haruki Okasame", "https://media.gq.com/photos/5ad64204c8be07604e8b5f2f/16:9/w_2000,h_1125,c_limit/21-books-GQ-April-2018-041718-3x2.jpg", "short description for a book", "long description for book content"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEYS, gson.toJson(books));
        editor.commit();

        // create Data
//        allBooks.add(new Book(1,"1Q84","Haruki Marakami","https://assets.awwwards.com/assets/images/book/2019/now/header/slide-01.jpg","short description for a book", "long description for book content"));
//        allBooks.add(new Book(2,"1Q85","Haruki Sukuman","https://cdn.thespaces.com/wp-content/uploads/2018/05/Island-caruso-st-john-marcus-taylor-cover-2-1024x663.jpg","short description for a book", "long description for book content"));
//        allBooks.add(new Book(3,"1Q86","Haruki KonoiChi","https://shadycharacters.co.uk/wp/wp-content/uploads/2016/12/Book_IMG_1754-1-e1481474081467.jpg","short description for a book", "long description for book content"));
//        allBooks.add(new Book(4,"1Q87","Haruki Masuro","https://www.thebalance.com/thmb/w4syTJBkKMI7QDfXQPee3boybtU=/683x512/smart/filters:no_upscale()/ScreenShot2019-10-14at9.34.06AM-757b2b342fd448b88804abe6c96e122a.png","short description for a book", "long description for book content"));
//        allBooks.add(new Book(5,"1Q88","Haruki Okasame","https://media.gq.com/photos/5ad64204c8be07604e8b5f2f/16:9/w_2000,h_1125,c_limit/21-books-GQ-April-2018-041718-3x2.jpg","short description for a book", "long description for book content"));

    }

    public static Utils getInstance(Context context) {
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }

    public static void setInstance(Utils instance) {
        Utils.instance = instance;
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEYS, null), type);
        return books;
    }

//    public static void setAllBooks(ArrayList<Book> allBooks) {
//        Utils.allBooks = allBooks;
//    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS, null), type);
        return books;
    }

//    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
//        Utils.alreadyReadBooks = alreadyReadBooks;
//    }

    public ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS, null), type);
        return books;
    }

//    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
//        Utils.wantToReadBooks = wantToReadBooks;
//    }

    public ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS, null), type);
        return books;
    }

//    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
//        Utils.currentlyReadingBooks = currentlyReadingBooks;
//    }

    public ArrayList<Book> getFavoritesBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS, null), type);
        return books;
    }

//    public static void setFavoritesBooks(ArrayList<Book> favoritesBooks) {
//        Utils.favoritesBooks = favoritesBooks;
//    }

    public Book getBookById(int id) {
        ArrayList<Book> books = getAllBooks();
        if (books != null) {
            for (Book b :books) {
                if (b.getId() == id) {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (books != null) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (books != null) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToCurrentRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (books != null) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFavoriteBook(Book book) {
        ArrayList<Book> books = getFavoritesBooks();
        if (books != null) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }
// remove item
    public boolean removeAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();

        if (books != null) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeWantToRead(Book book) {
        ArrayList<Book> books = getWantToReadBooks();
        if (books != null) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeCurrentRead(Book book) {
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (books != null) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean removeFavoriteBook(Book book) {
        ArrayList<Book> books = getFavoritesBooks();
        if (books != null) {
            for (Book b : books) {
                if (b.getId() == book.getId()) {
                    if (books.remove(b)) {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
