package com.poly.myapplication.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        progressDialog = new ProgressDialog(this);
        initViews();
        initAction();
    }

    public abstract int setLayoutId();

    public abstract void initViews();

    public abstract void initAction();

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
        if (progressDialog != null) {
            progressDialog.show();
            progressDialog.setMessage("Loading...");
        }
    }

    public void hideLoading() {
        if (progressDialog != null)
            progressDialog.hide();
        showToast("Finished");
    }

}
