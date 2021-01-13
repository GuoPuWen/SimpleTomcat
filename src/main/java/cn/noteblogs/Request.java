package cn.noteblogs;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    /**
     * 请求方法
     */
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 请求url
     */
    private String url;
    /**
     * 输入流
     */
    private InputStream inputStream;
    public Request(){}

    public Request(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        int count = 0;
        while(count == 0){
            count = inputStream.available();
        }
        byte[] b = new byte[count];
        inputStream.read(b);
        String reqStr = new String(b);
        System.out.println("请求体：" + reqStr);
        String[] split = reqStr.split("\n");
        //System.out.println(split[0]);   //第一行信息 GET /index.html HTTP/1.1  GET /favicon.ico HTTP/1.1
        String reqInfo[] = split[0].split(" ");
        System.out.println("请求方法：" + reqInfo[0]);
        System.out.println("请求路径：" + reqInfo[1]);
        this.method = reqInfo[0];
        this.url = reqInfo[1];
    }
}
