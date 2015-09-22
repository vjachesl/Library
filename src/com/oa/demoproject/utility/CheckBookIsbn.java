package com.oa.demoproject.utility;

import com.oa.demoproject.dao.LibraryDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.oa.demoproject.utility.Constants.*;

/**
 * Created by viacheslav on 22.09.15.
 */
public class CheckBookIsbn {
    public static int checkBookISBN (HttpServletRequest request, HttpServletResponse response, LibraryDao libDao){
        int bookIsbn = 0;
        try {
            bookIsbn = Integer.parseInt(request.getParameter(KEY_ARG_BOOK_ISBN));
        } catch (NumberFormatException e) {
            DoingResultResponse.doingResultResponse(response, "Invalid request", 400);
        }
        return bookIsbn;
    }
}
