package hmus.courseTable;

import java.util.Scanner;

public class Config {
    Scanner scanner=new Scanner(System.in);

    private static String LoginUrl = "http://bkjw2.guet.edu.cn/student/public/login.asp";
    private static String logoutUrl = "";
    private static String selectUrl = "http://bkjw2.guet.edu.cn/student/selectterm.asp";
    private static String checkNetUrl = "https://www.baidu.com";
    private static String UserAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";
    private static String Connection = "keep-alive";
    private static String UserFormName="username";
    private static String PasswdFormName="passwd";
    private static String OtherFormName="term";
    private  String userName = "";
    private  String passwd = "" ;

    public static String getSelectUrl() {
        return selectUrl;
    }

    public static String getCheckNetUrl() {
        return checkNetUrl;
    }

    public static String getLoginUrl() {
        return LoginUrl;
    }

    public static String getLogoutUrl() {
        return logoutUrl;
    }

    public static String getUserAgent() {
        return UserAgent;
    }

    public static String getConnection() {
        return Connection;
    }

    public static String getUserFormName() {
        return UserFormName;
    }

    public static String getPasswdFormName() {
        return PasswdFormName;
    }

    public static String getOtherFormName() {
        return OtherFormName;
    }

    public String getUserName() {
        return userName;
    }

    public String setUserName() {
        System.out.print("ID:");
        userName = scanner.next();
        return userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public String setPasswd() {
        System.out.print("Password:");
        passwd = scanner.next();
        return userName;
    }
}
