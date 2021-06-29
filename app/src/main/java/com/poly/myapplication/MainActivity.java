package com.poly.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.poly.myapplication.base.BaseActivity;
import com.poly.myapplication.base.OnProgressListener;

public class MainActivity extends BaseActivity {
    private Button button;
    private ProgressBar progressBar;

    @Override
    public void initAction() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                MyTask myTask = new MyTask();
                myTask.setOnProgressListener(new OnProgressListener() {
                    @Override
                    public void onProgress(int process) {
                        progressBar.setProgress(process);
                    }

                    @Override
                    public void finish(String result) {
                        hideLoading();
                    }
                });
                myTask.execute();
            }
        });
    }
    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
    }
}