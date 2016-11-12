package com.zhuanghongji.mpchartexample.notimportant;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

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
        initToolbar();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    protected abstract int getLayoutResID();
    protected void initToolbar(){};

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
