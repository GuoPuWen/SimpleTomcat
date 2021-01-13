package cn.noteblogs;

public abstract class HttpServlet implements Servlet{
    public abstract void doGet(Request request, Response response) throws Exception;
    public abstract void doPost(Request request, Response response) throws Exception;

    @Override
    public void service(Request request, Response response) throws Exception {
        if(request.getMethod().equalsIgnoreCase("GET")){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }
}
