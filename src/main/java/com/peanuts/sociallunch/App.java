package com.peanuts.sociallunch;

public class App {

    public static void main(String[] args) {

        DIContainer cont = new DIContainer();
        SocialLunch app = cont.init();
        app.start();

    }


}
