package cn.noteblogs;

public class MyThread implements Runnable{
    private HttpServlet httpServlet;
    private Response response;
    private Request request;
    public MyThread(){
    }

    public MyThread(HttpServlet httpServlet,  Request request,Response response) {
        this.httpServlet = httpServlet;
        this.response = response;
        this.request = request;
    }

    @Override
    public void run() {
        try {
            httpServlet.service(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
