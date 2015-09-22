package com.oa.demoproject.controll.action;

import com.oa.demoproject.dao.LibraryDao;
import com.oa.demoproject.dao.LibraryDataImpl;
import com.oa.demoproject.entity.Book;

import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.oa.demoproject.utility.CheckBookIsbn.checkBookISBN;
import static com.oa.demoproject.utility.DoingResultResponse.doingResultResponse;

public class BookByIsbn implements Action {


    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LibraryDao libDao = LibraryDataImpl.getInstance();
        int bookIsbn = checkBookISBN(request, response, libDao);
        System.out.println(bookIsbn);
        Book findedBook = libDao.getBookByIsbn(bookIsbn);
        if (findedBook == null)
            doingResultResponse(response, "Book was not found", 404);
        JSONObject obj = new JSONObject();
        obj.put("isbn", findedBook.getBookIsbn());
        obj.put("author", findedBook.getBookAuthorName());
        obj.put("name", findedBook.getBookName());
        doingResultResponse(response, obj.toString(), 200);
    }
}
