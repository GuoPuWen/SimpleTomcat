package cn.noteblogs.util;

public class HttpUtil {
    /**
     * 响应体报文格式：状态行、首部行、和实体体
     *
     *
     * @return
     */
    public static String addHeader(int len){
        StringBuffer sb = new StringBuffer("HTTP/1.1 200 OK\n");
        sb.append("Content-Type: text/html; charset=UTF-8 \n");
        sb.append("Content-Length: " + len + " \n" + "\r\n");   //http响应体中用\r\n换行
        return sb.toString();
    }
    public static String res_200(String content){
        return addHeader(content.length()) + content;
    }
}
