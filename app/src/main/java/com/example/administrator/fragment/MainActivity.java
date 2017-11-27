package com.example.administrator.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 精选
     */
    private TextView mJing;
    /**
     * 专题
     */
    private TextView mZhuan;
    /**
     * 我的
     */
    private TextView mMy;
    /**
     * 发现
     */
    private TextView mFa;
    private FrameLayout fl;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Fragment01 fragment01 = new Fragment01();
        getFragment("fragment01",fragment01);
    }

    private void initView() {
        mJing = (TextView) findViewById(R.id.jing);
        mZhuan = (TextView) findViewById(R.id.zhuan);
        mMy = (TextView) findViewById(R.id.my);
        mFa = (TextView) findViewById(R.id.fa);
        mJing.setOnClickListener(this);
        mZhuan.setOnClickListener(this);
        mMy.setOnClickListener(this);
        mFa.setOnClickListener(this);
        fl = (FrameLayout) findViewById(R.id.fl);
    }

    @Override
    public void onClick(View v) {
        fragment = new Fragment();
        switch (v.getId()) {
            case R.id.jing:
                fragment = new Fragment01();
                getFragment("fragment01",fragment);
                break;
            case R.id.zhuan:
                fragment = new Fragment02();
                getFragment("fragment02",fragment);
                break;
            case R.id.fa:
                fragment = new Fragment03();
                getFragment("fragment03",fragment);
                break;
            case R.id.my:
                fragment = new Fragment04();
                getFragment("fragment04",fragment);
                break;
        }
    }

    public void getFragment(String name,Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl,fragment);
        transaction.addToBackStack(name);
        transaction.commit();
    }
}
