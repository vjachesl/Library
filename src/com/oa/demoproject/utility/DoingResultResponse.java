package com.oa.demoproject.utility;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by viacheslav on 22.09.15.
 */
public class DoingResultResponse {

    public static void doingResultResponse(HttpServletResponse resp, String responseBody, int responsestatus) {
        resp.setStatus(responsestatus);
        OutputStream outputStream = null;
        try {
            outputStream = resp.getOutputStream();
            outputStream.write(responseBody.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
