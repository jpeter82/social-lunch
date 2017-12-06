package com.peanuts.sociallunch.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptBean {
    public static PasswordEncoder encryptBean;

    public EncryptBean() {
        this.encryptBean = new BCryptPasswordEncoder();
    }
}
