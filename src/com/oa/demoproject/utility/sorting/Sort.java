package com.oa.demoproject.utility.sorting;

import com.oa.demoproject.entity.Book;

import java.util.Comparator;

/**
 * Created by viacheslav on 20.09.15.
 */
abstract class  Sort implements Comparator<Book> {
    public int compare(Book book1, Book book2) {
        return 0;
    }
}
