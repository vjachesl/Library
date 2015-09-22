package com.oa.demoproject.controll.action;



import com.oa.demoproject.dao.LibraryDao;
import com.oa.demoproject.dao.LibraryDataImpl;
import com.oa.demoproject.entity.Book;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.oa.demoproject.utility.DoingResultResponse.doingResultResponse;

public class AllBooks implements Action {


    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LibraryDao libDao = LibraryDataImpl.getInstance();
        List<Book> findedBooks = libDao.getAllBooks();
        JSONObject obj = new JSONObject();
            for (int i = 0; i < findedBooks.size(); i++) {
                obj.put("isbn " + i, findedBooks.get(i).getBookIsbn());
                obj.put("author " + i, findedBooks.get(i).getBookAuthorName());
                obj.put("name " + i, findedBooks.get(i).getBookName());
            }
        doingResultResponse(response, obj.toString(), 200);
    }
}
