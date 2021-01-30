package com.example.practiceapplication;

import android.util.Log;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoritesBooks;
    private static final String TAG = "Utils";

    private Utils() {
        if (allBooks == null) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (alreadyReadBooks == null) {
            alreadyReadBooks = new ArrayList<>();
        }

        if (wantToReadBooks == null) {
            wantToReadBooks = new ArrayList<>();
        }

        if (currentlyReadingBooks == null) {
            currentlyReadingBooks = new ArrayList<>();
        }

        if (favoritesBooks == null) {
            favoritesBooks = new ArrayList<>();
        }
    }

    private void initData() {
        // create Data
        allBooks.add(new Book(1,"1Q84","Haruki Marakami","https://assets.awwwards.com/assets/images/book/2019/now/header/slide-01.jpg","short description for a book", "long description for book content"));
        allBooks.add(new Book(2,"1Q85","Haruki Sukuman","https://cdn.thespaces.com/wp-content/uploads/2018/05/Island-caruso-st-john-marcus-taylor-cover-2-1024x663.jpg","short description for a book", "long description for book content"));
        allBooks.add(new Book(3,"1Q86","Haruki KonoiChi","https://shadycharacters.co.uk/wp/wp-content/uploads/2016/12/Book_IMG_1754-1-e1481474081467.jpg","short description for a book", "long description for book content"));
        allBooks.add(new Book(4,"1Q87","Haruki Masuro","https://www.thebalance.com/thmb/w4syTJBkKMI7QDfXQPee3boybtU=/683x512/smart/filters:no_upscale()/ScreenShot2019-10-14at9.34.06AM-757b2b342fd448b88804abe6c96e122a.png","short description for a book", "long description for book content"));
        allBooks.add(new Book(5,"1Q88","Haruki Okasame","https://media.gq.com/photos/5ad64204c8be07604e8b5f2f/16:9/w_2000,h_1125,c_limit/21-books-GQ-April-2018-041718-3x2.jpg","short description for a book", "long description for book content"));

    }

    public static Utils getInstance() {
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }

    public static void setInstance(Utils instance) {
        Utils.instance = instance;
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
        Utils.alreadyReadBooks = alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
        Utils.wantToReadBooks = wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoritesBooks() {
        return favoritesBooks;
    }

    public static void setFavoritesBooks(ArrayList<Book> favoritesBooks) {
        Utils.favoritesBooks = favoritesBooks;
    }

    public Book getBookById(int id) {
        for (Book b :allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }
    public boolean addToWantToRead(Book book) {
        return wantToReadBooks.add(book);
    }
    public boolean addToCurrentRead(Book book) {
        return currentlyReadingBooks.add(book);
    }
    public boolean addToFavoriteBook(Book book) {
        return favoritesBooks.add(book);
    }
}
