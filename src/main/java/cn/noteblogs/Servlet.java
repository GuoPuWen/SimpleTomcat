package cn.noteblogs;

/**
 * @author 四五又十
 * @create 2021/1/12 15:41
 */
public interface Servlet {
    void init() throws Exception;
    void destory() throws Exception;
    void service(Request request, Response response) throws Exception;
}
