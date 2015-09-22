package com.oa.demoproject.dao;

import com.oa.demoproject.entity.Book;

import java.util.List;

/**
 * Created by viacheslav on 20.09.15.
 */
public interface LibraryDao {
        List<Book> getAllBooks ();
        Book getBookByIsbn (int isbn);
        boolean deleteBookByIsbn(int isbn);
        void addBook(Book book);
        List<Book> getBooksByAuthor (String bookAuthor);
        void sortBooksByKey(boolean isIncrementingCriteria, String sortingFieldName);
        List<String> getBooksAuthors();
        }
