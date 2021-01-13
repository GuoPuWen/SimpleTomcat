package cn.noteblogs.util;

import cn.noteblogs.HttpServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Xmlutil {
    public static HashMap loadServlet(){
        InputStream inputStream = Xmlutil.class.getClassLoader().getResourceAsStream("web.xml");
        SAXReader saxReader = new SAXReader();
        HashMap<String, HttpServlet> urlPatternMap = new HashMap<String, HttpServlet>();
        try {
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> servletNode = rootElement.selectNodes("//servlet");
            for (Element element : servletNode) {
                String servletName = ((Element)element.selectSingleNode("servlet-name")).getStringValue();
                String servletClass = ((Element)element.selectSingleNode("servlet-class")).getStringValue();
                Element servletMapping = (Element)rootElement.selectSingleNode("/web-app/servlet-mapping[servlet-name='" + servletName + "']");
                String urlPattern = servletMapping.selectSingleNode("url-pattern").getStringValue();
                urlPatternMap.put(urlPattern, (HttpServlet)Class.forName(servletClass).newInstance());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return urlPatternMap;
    }

    public static void main(String[] args) {
        System.out.println(loadServlet());
    }
}
