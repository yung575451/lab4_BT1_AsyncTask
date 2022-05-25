package com.hungphamcom.lab4_bt1_asynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = null;
    private TextView textView;
    private Button startTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView1);
        startTask=findViewById(R.id.startTask);

        if(savedInstanceState!=null){
            textView.setText(savedInstanceState.getString(TEXT_STATE));
        }

        startTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Napping... ");
                new SimpleAsyncTask(textView).execute();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TEXT_STATE, textView.getText().toString());
    }
}