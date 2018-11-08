package com.example.helenkellercompute.guokun.entity;

import java.util.List;

/**
 * Created by Carson_Ho on 17/3/20.
 */
public class Translation {

    private int status;

    public TranslationEntity content;
    public static class TranslationEntity {
        public String from;
        public String to;
        public String vendor;
        public String out;
        public String ph_tts_mp3;
        public List word_mean;
        public int errNo;
    }
}
