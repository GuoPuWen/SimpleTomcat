package cn.noteblogs;

import cn.noteblogs.util.HttpUtil;
import cn.noteblogs.util.Resourceutil;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private OutputStream outputStream;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void outPutStr(String conent) throws IOException {
        outputStream.write(HttpUtil.res_200(conent).getBytes());
        outputStream.flush();
        outputStream.close();
    }
    public void outPutHtml(String url) throws IOException {
        if(url.equals("/favicon.ico")){
            return;
        }
        outputStream.write(HttpUtil.res_200(Resourceutil.readFile(url)).getBytes());
        outputStream.flush();
        outputStream.close();
    }

}
