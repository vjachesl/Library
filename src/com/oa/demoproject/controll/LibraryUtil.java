package com.oa.demoproject.controll;

import com.oa.demoproject.controll.action.Action;
import com.oa.demoproject.controll.action.ActionFactory;
import com.oa.demoproject.dao.LibraryDao;
import com.oa.demoproject.dao.LibraryDataImpl;
import com.oa.demoproject.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.oa.demoproject.utility.CheckBookIsbn.checkBookISBN;
import static com.oa.demoproject.utility.DoingResultResponse.doingResultResponse;
import static com.oa.demoproject.utility.Constants.*;

/**
 * Created by viacheslav on 17.09.15.
 */
@WebServlet(name = "library", urlPatterns = {"/library"})
public class LibraryUtil extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println(request.getParameterNames().nextElement());
        //asking action factory for result
        Action action = ActionFactory.getAction(request);
        try {
            action.execute(request, response);
        } catch (Exception ex) {
            doingResultResponse(response, ex.getMessage(),500);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryDao libDao = LibraryDataImpl.getInstance();

        String bookAuthor = request.getParameter(KEY_ARG_BOOK_AUTHOR);
        String bookTitle = request.getParameter(KEY_ARG_BOOK_Title);
        String bookIsbn = request.getParameter(KEY_ARG_BOOK_ISBN);

        int parsedBookIsbn = checkBookISBN(request, response, libDao);
        Book findedBook = libDao.getBookByIsbn(parsedBookIsbn);
        if (findedBook != null)
            doingResultResponse(response, "Book already exists", 406);
        libDao.addBook(new Book(parsedBookIsbn, bookAuthor, bookTitle));
        doingResultResponse(response, "Book already added", 201);
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LibraryDao libDao = LibraryDataImpl.getInstance();
        String bookIsbn = req.getParameter(KEY_ARG_BOOK_ISBN);
        int parsedBookIsbn = checkBookISBN(req, resp, libDao);
        System.out.println(parsedBookIsbn);
        Book findedBook = libDao.getBookByIsbn(parsedBookIsbn);
        if (findedBook != null)
            doingResultResponse(resp, "Book not Found", 404);
        libDao.deleteBookByIsbn(findedBook.getBookIsbn());
        doingResultResponse(resp, "Book already deleted", 204);
    }

}
