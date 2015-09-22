package com.oa.demoproject.controll.action;

import com.oa.demoproject.dao.LibraryDao;
import com.oa.demoproject.dao.LibraryDataImpl;
import com.oa.demoproject.entity.Book;
import com.oa.demoproject.utility.sorting.SortingFactory;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

import static com.oa.demoproject.utility.DoingResultResponse.doingResultResponse;
import static com.oa.demoproject.utility.Constants.KEY_SORTING_FIELD;
import static com.oa.demoproject.utility.Constants.KEY_SORTING_ORDER;

public class BooksSort implements Action {


    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sortingKey = request.getParameter(KEY_SORTING_FIELD);
        String sortingOrder = request.getParameter(KEY_SORTING_ORDER);
        if (sortingKey==null || sortingKey.equals("")||
                sortingOrder==null || sortingOrder.equals(""))
            doingResultResponse(response, "Was no correct input made",500);
        LibraryDao libDao = LibraryDataImpl.getInstance();
        List<Book> findedBooks = libDao.getAllBooks();
        try {
            Collections.sort(findedBooks, new SortingFactory(sortingKey + sortingOrder).createSortOrder());
        } catch (NullPointerException e) {
            doingResultResponse(response, "Was no correct input made",500);
        }
        JSONObject obj = new JSONObject();
            for (int i = 0; i < findedBooks.size(); i++) {
                obj.put("isbn " + i, findedBooks.get(i).getBookIsbn());
                obj.put("author " + i, findedBooks.get(i).getBookAuthorName());
                obj.put("name " + i, findedBooks.get(i).getBookName());
            }
        doingResultResponse(response, obj.toString(), 200);
    }
}
