package com.oa.demoproject.controll.action;

import com.oa.demoproject.dao.LibraryDao;
import com.oa.demoproject.dao.LibraryDataImpl;
import com.oa.demoproject.entity.Book;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static com.oa.demoproject.utility.Constants.*;
import static com.oa.demoproject.utility.DoingResultResponse.doingResultResponse;

public class BooksByAuthor implements Action {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LibraryDao libDao = LibraryDataImpl.getInstance();
        String bookAuthor = request.getParameter(KEY_ARG_BOOK_AUTHOR);
        System.out.println(bookAuthor);
        if (bookAuthor==null || bookAuthor.equals(""))
            doingResultResponse(response, "Was no correct input made",500);
        List<Book> findedBooks = libDao.getBooksByAuthor(bookAuthor);
        if (findedBooks == null)
            doingResultResponse(response, "Books for author "+bookAuthor+ " was not found", 404);
        JSONObject obj = new JSONObject();
        for (int i = 0; i < findedBooks.size(); i++) {
            obj.put("isbn " + i, findedBooks.get(i).getBookIsbn());
            obj.put("author " + i, findedBooks.get(i).getBookAuthorName());
            obj.put("name " + i, findedBooks.get(i).getBookName());
        }
        doingResultResponse(response, obj.toString(), 200);
    }
}
