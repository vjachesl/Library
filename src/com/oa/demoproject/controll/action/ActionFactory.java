package com.oa.demoproject.controll.action;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Action factory for action classes new object creating.
 *
 * @author Viacheslav Chichin
 * @version 1.0  June 10, 2015.
 */

public class ActionFactory {

   private static final Map<String, Action> actions;

    static {
        actions = new HashMap<String, Action>();
        actions.put("book_isbn", new BookByIsbn());
        actions.put("all_books", new AllBooks());
        actions.put("books_by_author", new BooksByAuthor());
        actions.put("books_sort", new BooksSort());
        actions.put("authors", new Authors());

    }

    public static Action getAction(HttpServletRequest request) {
        return actions.get(request.getParameterNames().nextElement());
    }
}
