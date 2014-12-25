package com.telolahy.guitarmemo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by stephanohuguestelolahy on 12/8/14.
 */
public class TextUtil {

    public static String readRawTextFile(Context context, String filePath) {
        StringBuilder text = new StringBuilder();
        try {
            InputStream inputStream = context.getAssets().open(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
}
