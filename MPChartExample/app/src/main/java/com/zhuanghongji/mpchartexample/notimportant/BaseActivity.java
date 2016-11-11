package com.zhuanghongji.mpchartexample.notimportant;

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
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected void initToolbar(){
        initToolbar(R.id.toolbar);
    }

    protected void initToolbar(int toolbarId){
        mToolbar = (Toolbar) findViewById(toolbarId);
        setSupportActionBar(mToolbar);
    }

    protected abstract int getLayoutResID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
