package cn.noteblogs;

import cn.noteblogs.util.Xmlutil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.*;

public class Bootstrap {
    /**
     * 监听端口号
     */
    private static final int port = 8080;
    private static HashMap<String, HttpServlet> urlPatternMap;
//    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20, 10L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    static {
        urlPatternMap = Xmlutil.loadServlet();
    }


    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(port);
        System.out.println("---------start port : " + port);
        while(true){
            Socket accept = socket.accept();
            Request request = new Request(accept.getInputStream());
            Response response = new Response(accept.getOutputStream());
            if(request.getUrl().contains(".html")){
                response.outPutHtml(request.getUrl());

            }else {
                if(!urlPatternMap.containsKey(request.getUrl())){
                    response.outPutStr(request.getUrl() + "is not found ...");
                }else{
                    HttpServlet httpServlet = urlPatternMap.get(request.getUrl());
                    try {
                        httpServlet.service(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            accept.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new Bootstrap().start();
    }
}
