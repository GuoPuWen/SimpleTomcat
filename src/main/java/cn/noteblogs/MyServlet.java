package cn.noteblogs;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) throws IOException, InterruptedException {
        String content = "GET业务请求";
        response.outPutStr(content);
        //try { TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        String content = "<h2> POST业务请求 </h2>";
        response.outPutStr(content);
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void destory() throws Exception {

    }
}
