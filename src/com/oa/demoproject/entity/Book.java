package com.oa.demoproject.entity;

/**
 * Created by viacheslav on 20.09.15.
 */
public class Book {
    private int bookIsbn;
    private String bookAutor;
    private String bookName;


    public Book (int bookIsbn, String bookAutor, String bookName){
        this.bookIsbn = bookIsbn;
        this.bookAutor = bookAutor;
        this.bookName = bookName;
    }


    public String getBookName() {
        return bookName;
    }

    public String getBookAuthorName() {
        return bookAutor;
    }

    public int getBookIsbn() { return bookIsbn; }

    @Override
    public String toString() {
        return "Book{" +
                "bookIsbn=" + bookIsbn +
                ", bookAutor='" + bookAutor + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
