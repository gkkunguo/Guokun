package com.example.helenkellercompute.guokun.utils;

/**
 * Created by Helen keller compute on 2018/5/2.
 */

public class UtilTime {

    public String formatTime(long time) {
        time = time / 1000;
        String strHour = "" + (time / 3600);
        String strMinute = "" + time % 3600 / 60;
        String strSecond = "" + time % 3600 % 60;

        strHour = strHour.length() < 2 ? "0" + strHour : strHour;
        strMinute = strMinute.length() < 2 ? "0" + strMinute : strMinute;
        strSecond = strSecond.length() < 2 ? "0" + strSecond : strSecond;

        String strRsult = "";

        if (!strHour.equals("00")) {
            strRsult += strHour + ":";
        }

        if (!strMinute.equals("00")) {
            strRsult += strMinute + ":";
        }
        if(strHour.equals("00")&&strMinute.equals("00")){
            strRsult +=   "00:";
        }

        strRsult += strSecond;

        return strRsult;
    }

    public static void main(String[] args) {

        UtilTime de = new UtilTime();
        System.out.println(de.formatTime(6000));
    }
}
