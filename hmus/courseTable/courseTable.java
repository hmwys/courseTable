package hmus.courseTable;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;


public class courseTable {
    public static void main(String[] args) throws IOException {
        Config config = new Config();
//        config.setUserName();
//        config.setPasswd();



        WebClient webClient = new WebClient();
        webClient.addRequestHeader("UserAgent", Config.getUserAgent());
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        webClient.waitForBackgroundJavaScript(30000);

        HtmlPage htmlPage = webClient.getPage(Config.getLoginUrl());

        Document document = Jsoup.parse(htmlPage.asXml());
        HtmlForm form = htmlPage.getForms().get(0);
        form.getInputByName(Config.getUserFormName()).setDefaultValue(config.getUserName());
        form.getInputByName(Config.getPasswdFormName()).setDefaultValue(config.getPasswd());
        form.getInputByName("login").click();
        htmlPage = webClient.getPage(Config.getSelectUrl());

        form = htmlPage.getForms().get(0);
        form.getSelectByName(Config.getOtherFormName()).setDefaultValue("2018-2019_2");
        htmlPage = form.getInputByValue("²éÑ¯").click();
//        document = Jsoup.parse(new String(htmlPage.asXml().getBytes("iso8859-1"),"utf8"));
        document =Jsoup.parse(new String(htmlPage.asXml().getBytes("ISO-8859-1"),"GBK"));
        System.out.println(document.select("table"));

        OutPutHtml.outputPage(document);

    }


    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }
}
