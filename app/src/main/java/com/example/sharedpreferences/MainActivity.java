package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPrerencesFileName="config";

    private final static String username="username";
    private final static String number="2014";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences(SharedPrerencesFileName,MODE_PRIVATE);
        editor=preferences.edit();

        Button Write=(Button)findViewById(R.id.writebutton);
        Button Read=(Button)findViewById(R.id.readbutton);
        Write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(username,"李先华");
                editor.putInt(number,2014011125);

                editor.apply();
            }
        });

        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username=preferences.getString(username,null);
                int Number=preferences.getInt(number,0);
                if(Username!=null&&Number!=0)
                    Toast.makeText(MainActivity.this,"姓名："+Username+"学号："+Number,Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
            }
        });

    }
}
