package ufrpe.aula1;

import android.content.Context;
import android.content.SharedPreferences;
public class Preferencias {
    public static final String PREF_ID = "dispositivos";

    public void setBoolean(Context context, String flag, boolean on) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(flag, on);
        editor.commit();
    }

    public boolean getBoolean(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        boolean b = pref.getBoolean(flag, false);
        return b;
    }

    public void setInteger(Context context, String flag, int valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(flag, valor);
        editor.commit();
    }

    public int getInteger(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        int i = pref.getInt(flag, 0);
        return i;
    }

    public void setString(Context context, String flag, String valor) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(flag, valor);
        editor.commit();
    }

    public String getString(Context context, String flag) {
        SharedPreferences pref = context.getSharedPreferences(PREF_ID, 0);
        String s = pref.getString(flag, "");
        return s;
    }
    public void removeall(Context context)
    {
        SharedPreferences.Editor editor=context.getSharedPreferences(PREF_ID, 0).edit();
        editor.clear();
        editor.apply();
    }
}
