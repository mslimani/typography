package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import typography.TypographyConfig;

/**
 * Created by mehdi on 31/01/2016.
 */
public class TypographyAppCompatDelegate extends AppCompatDelegate implements LayoutInflaterFactory {

    private final TypographyConfig mConfiguration;
    private final AppCompatActivity mAppCompatActivity;
    private final AppCompatDelegate mAppCompatDelegate;

    public TypographyAppCompatDelegate(AppCompatActivity appCompatActivity, AppCompatDelegate appCompatDelegate, TypographyConfig config) {
        mAppCompatActivity = appCompatActivity;
        mAppCompatDelegate = appCompatDelegate;
        mConfiguration = config;
    }

    public TypographyAppCompatDelegate(AppCompatActivity appCompatActivity, AppCompatDelegate appCompatDelegate) {
        mAppCompatActivity = appCompatActivity;
        mAppCompatDelegate = appCompatDelegate;
        mConfiguration = TypographyConfig.getInstance();
    }

    @Override
    public ActionBar getSupportActionBar() {
        return mAppCompatDelegate.getSupportActionBar();
    }

    @Override
    public void setSupportActionBar(Toolbar toolbar) {
        mAppCompatDelegate.setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return mAppCompatDelegate.getMenuInflater();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mAppCompatDelegate.onCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        mAppCompatDelegate.onPostCreate(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mAppCompatDelegate.onConfigurationChanged(newConfig);
    }

    @Override
    public void onStop() {
        mAppCompatDelegate.onStop();
    }

    @Override
    public void onPostResume() {
        mAppCompatDelegate.onPostResume();
    }

    @Override
    public void setContentView(View v) {
        mAppCompatDelegate.setContentView(v);
    }

    @Override
    public void setContentView(int resId) {
        mAppCompatDelegate.setContentView(resId);
    }

    @Override
    public void setContentView(View v, ViewGroup.LayoutParams lp) {
        mAppCompatDelegate.setContentView(v, lp);
    }

    @Override
    public void addContentView(View v, ViewGroup.LayoutParams lp) {
        mAppCompatDelegate.addContentView(v, lp);
    }

    @Override
    public void setTitle(CharSequence title) {
        mAppCompatDelegate.setTitle(title);
    }

    @Override
    public void invalidateOptionsMenu() {
        mAppCompatDelegate.invalidateOptionsMenu();
    }

    @Override
    public void onDestroy() {
        mAppCompatDelegate.onDestroy();
    }

    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return mAppCompatDelegate.getDrawerToggleDelegate();
    }

    @Override
    public boolean requestWindowFeature(int featureId) {
        return mAppCompatDelegate.requestWindowFeature(featureId);
    }

    @Override
    public boolean hasWindowFeature(int featureId) {
        return mAppCompatDelegate.hasWindowFeature(featureId);
    }

    @Override
    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return mAppCompatDelegate.startSupportActionMode(callback);
    }

    @Override
    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from(mAppCompatActivity);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory(layoutInflater, this);
        }
    }

    @Override
    public View createView(View parent, String name, Context context, AttributeSet attrs) {
        View view = mAppCompatDelegate.createView(parent, name, context, attrs);
        setTypeface(view, context, attrs);
        return view;
    }

    @Override
    public void setHandleNativeActionModesEnabled(boolean enabled) {
        mAppCompatDelegate.setHandleNativeActionModesEnabled(enabled);
    }

    @Override
    public boolean isHandleNativeActionModesEnabled() {
        return mAppCompatDelegate.isHandleNativeActionModesEnabled();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        if (mAppCompatDelegate instanceof AppCompatDelegateImplV7) {
            if ("fragment".equals(name)) {
                return null;
            }

            View view = ((AppCompatDelegateImplV7) mAppCompatDelegate).onCreateView(parent, name, context, attrs);
            setTypeface(view, context, attrs);
            return view;
        }
        return null;
    }

    private void setTypeface(View view, Context context, AttributeSet attrs) {
        if (view == null || ! (view instanceof TextView)) {
            return;
        }


        TextView textView = (TextView) view;
        int[] attrsCustom = { android.R.attr.fontFamily };
        TypedArray appearance = context.obtainStyledAttributes(attrs, attrsCustom);
        String font = appearance.getString(0);
        appearance.recycle();

        Typeface typeface = mConfiguration.get(font);
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
    }


}

