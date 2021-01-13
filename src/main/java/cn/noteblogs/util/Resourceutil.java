package cn.noteblogs.util;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import sun.nio.cs.StandardCharsets;

import java.io.*;

public class Resourceutil {

    public static String readFile(String url) throws IOException {
        String file = Resourceutil.class.getClassLoader().getResource("").getFile();
        String filePath = file + url.substring(1,url.length());
        System.out.println(filePath);
        File file1 = new File(filePath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file1), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String contentLine = "";
        StringBuffer sb = new StringBuffer();
        while((contentLine = bufferedReader.readLine()) != null){
            sb.append(contentLine);
        }
        bufferedReader.close();
        reader.close();
        return sb.toString();
    }
}
