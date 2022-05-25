package com.hungphamcom.lab4_bt1_asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private TextView mTextView;

    @Override
    protected String doInBackground(Void... voids) {

        Random r=new Random();
        int n=r.nextInt(11);

        int s=n*500;

        try{
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake at last after sleeping for "+ s + " milliseconds!";

    }

    @Override
    protected void onPostExecute(String s) {
        mTextView.setText(s);
    }

    public SimpleAsyncTask(TextView tv){
        mTextView=tv;
    }
}
