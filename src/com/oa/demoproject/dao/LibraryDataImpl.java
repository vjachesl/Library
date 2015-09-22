package com.oa.demoproject.dao;

import com.oa.demoproject.entity.Book;
import com.oa.demoproject.utility.sorting.SortingFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by viacheslav on 20.09.15.
 */
public class LibraryDataImpl implements LibraryDao {
    private static List<Book> booksData;
    private static final LibraryDataImpl instance = new LibraryDataImpl();

    private LibraryDataImpl(){
        if (booksData==null) {
            booksData = new ArrayList<Book>();
            booksData.add(new Book(12345,"Bloh", "Java"));
            booksData.add(new Book(23456,"Norton", "Assembler"));
            booksData.add(new Book(34567,"Knut", "Algorythms"));
            booksData.add(new Book(45678,"Shildt", "Java Referense"));
            booksData.add(new Book(56789,"Clarence", "Pro Spring"));
        }
    }

    public static LibraryDataImpl getInstance(){
       return instance;
    }

    public List<Book> getAllBooks() {
        return booksData;
    }

    public Book getBookByIsbn(int isbn) {
        for (Book b : booksData) {
             if(b.getBookIsbn()==isbn) return b;
        }
        return null;
    }

    public boolean deleteBookByIsbn(int isbn) {
        for (Book b : booksData) {
            if(b.getBookIsbn()==isbn) booksData.remove(b);
            return true;
        }
        return false;
    }

    public void addBook(Book book) {
        if (getBookByIsbn(book.getBookIsbn())!=null) throw new IllegalArgumentException("Book already exists");
        booksData.add(book);
    }

    public List<Book> getBooksByAuthor(String bookAuthor) {
        List<Book> booksToReturn = new ArrayList<Book>();
        for (Book b : booksData) {
            if (b.getBookAuthorName().equalsIgnoreCase(bookAuthor)) booksToReturn.add(b);
        }
        return booksToReturn;
    }
    public void sortBooksByKey(boolean isIncrementingCriteria, String sortingFieldName) {
        if (sortingFieldName!="bookName"||sortingFieldName!="bookIsbn"||sortingFieldName!="bookAuthor") throw new IllegalArgumentException("No such sorting criteria");
        String sortingParam =sortingFieldName+(isIncrementingCriteria ? "Incr": "Decr");
        Collections.sort(booksData, new SortingFactory(sortingParam).createSortOrder());
    }

    public List<String> getBooksAuthors() {
        List<String> authorsToReturn = new ArrayList<String>();
        for (Book b : booksData) authorsToReturn.add(b.getBookAuthorName());
      return authorsToReturn;
    }


}
