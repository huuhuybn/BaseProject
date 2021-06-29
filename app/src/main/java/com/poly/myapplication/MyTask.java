package com.poly.myapplication;

import android.os.AsyncTask;

import com.poly.myapplication.base.OnProgressListener;

// tham so 1 : kieu gia tri cua du lieu dau vao
// tham so 2 : gia tri tien trinh Integer
// tham so 3 : kieu gia tri cua ket qua tra ve
public class MyTask extends AsyncTask<String, Integer, String> {


    OnProgressListener onProgressListener;

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    // phuong thuc trong thread
    @Override
    protected String doInBackground(String... strings) {
        for (int i = 0; i < 100; i++) {
            onProgressListener.onProgress(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // ket thuc thread : tuong tac- cap nhat toi giao dien
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onProgressListener.finish(s);
    }

    // cap nhat tien trinh
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    // trc khi start thread
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
