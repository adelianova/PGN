package adel.co.asyst.test.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtils {


    Context mContext;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SessionUtils(Context context) {
        this.mContext = context;
        preferences = context.getSharedPreferences("task", 0);

        editor = preferences.edit();
    }

    public void saveLogin(String username, String password) {
        editor.putString(Constant.KEY_USERNAME, username);
        editor.putString(Constant.KEY_PASSWORD, password);

        editor.commit();

    }

    public void saveIsLogin(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String loadUsername() {
        String uname = preferences.getString(Constant.KEY_USERNAME, "");
        return uname;
    }

    public String loadPassword() {
        String pass = preferences.getString(Constant.KEY_PASSWORD, "");
        return pass;
    }

    public Boolean isLogin() {

        return preferences.getBoolean(Constant.ISLOGIN, false);
    }
}
