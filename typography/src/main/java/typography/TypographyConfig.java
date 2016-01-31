package typography;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mehdi on 31/01/2016.
 */
public class TypographyConfig {

    private static TypographyConfig sInstance;

    private Map<String, Typeface> mTypefaceMap = new HashMap<>();
    private String mDefault;

    public Typeface get(String name) {
        if (mTypefaceMap.containsKey(name)) {
            return mTypefaceMap.get(name);
        }
        return getDefault();
    }

    public static TypographyConfig getInstance() {
        if (sInstance == null) {
            return new TypographyConfig();
        }
        return sInstance;
    }

    public Typeface getDefault() {
        return mTypefaceMap.get(mDefault);
    }

    public static class Builder {

        private Context mContext;
        private TypographyConfig mFontConfiguration;

        public Builder(Context context) {
            mContext = context.getApplicationContext();
            mFontConfiguration = new TypographyConfig();
        }

        public Builder defaultFont(String fontName) {
            mFontConfiguration.mDefault = fontName;
            return this;
        }

        public Builder addFont(String fontName, String assetName) {
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), assetName);
            if (typeface != null) {
                mFontConfiguration.mTypefaceMap.put(fontName, typeface);
            }
            return this;
        }

        public TypographyConfig build() {
            return mFontConfiguration;
        }

        public TypographyConfig buildSingleton() {
            sInstance = mFontConfiguration;
            return sInstance;
        }

    }

}
