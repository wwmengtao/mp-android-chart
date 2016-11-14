package com.zhuanghongji.mpchartexample.notimportant;

import android.app.Activity;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zhuanghongji.mpchartexample.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static butterknife.ButterKnife.bind;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        initViews();
        initEvents();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    protected abstract int getLayoutResID();
    protected abstract void initViews();
    protected abstract void initEvents();

    protected void setupToolbar(@NonNull final Toolbar toolbar,
                                @StringRes int title,
                                @StringRes int subtitle,
                                @MenuRes int menu,
                                boolean isNavigationEnable){
        if (title != 0) {
            toolbar.setTitle(title);
        }
        if (subtitle != 0) {
            toolbar.setSubtitle(subtitle);
        }
        if (menu != 0){
            toolbar.inflateMenu(menu);
        }
        if (isNavigationEnable) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity)(toolbar.getContext())).finish();
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
