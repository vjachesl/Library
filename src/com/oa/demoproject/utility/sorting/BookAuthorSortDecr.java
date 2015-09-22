package com.oa.demoproject.utility.sorting;

import com.oa.demoproject.entity.Book;

/**
 * Created by viacheslav on 20.09.15.
 */
public class BookAuthorSortDecr extends  Sort {

         public int compare(Book book1, Book book2) {
            return book2.getBookAuthorName().compareTo(book1.getBookAuthorName());
        }
    }

