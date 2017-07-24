package net.geecity.hisenseplus.util;

import android.text.TextUtils;

public class Validator {

    public Validator() {
        super();
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    public boolean validPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}
