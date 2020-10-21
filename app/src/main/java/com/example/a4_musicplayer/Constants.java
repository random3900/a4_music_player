package com.example.a4_musicplayer;

public class Constants {
    public interface ACTION {
        public static String MAIN_ACTION = "com.example.foregroundservice.action.main";
        public static String PREV_ACTION = "com.example.foregroundservice.action.prev";
        public static String PLAY_ACTION = "com.example.foregroundservice.action.play";
        public static String NEXT_ACTION = "com.example.foregroundservice.action.next";
        public static String STARTFOREGROUND_ACTION = "com.example.foregroundservice." +
                "action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.example.foregroundservice." +
                "action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }


}

