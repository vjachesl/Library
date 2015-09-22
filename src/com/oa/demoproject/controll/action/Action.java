package com.oa.demoproject.controll.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for different actions joining purposes.
 * Used for fabric creating different action classes
 *
 * @author Viacheslav Chichin
 * @version 1.0  June 10, 2015.
 */

public interface Action {

 void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
