package hmus.courseTable;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutHtml {


    public static void outputPage(Document document) throws IOException {
        File page = new File("./log/", "coursetable.html");
        if (!page.exists()) new File("./log").mkdir();
        FileOutputStream fos = new FileOutputStream(page);
        fos.write(document.select("table").toString().getBytes());
        fos.close();
    }

    public static void outputPage(Document document,int i) throws IOException {
        String s="returnPage000"+i+".txt" ;
        File page = new File("./log/", s);
        if (!page.exists()) new File("./log").mkdir();
        FileOutputStream fos = new FileOutputStream(page);
        fos.write(document.toString().getBytes());
        fos.close();
    }

    public static void outputCookie(Connection.Response rs) throws IOException {
        File cookies = new File("./log/", "rs.txt");
        if (!cookies.exists()) new File("./log").mkdir();
        FileOutputStream fos = new FileOutputStream(cookies);
        fos.write(rs.body().getBytes());
        fos.close();
    }
}
