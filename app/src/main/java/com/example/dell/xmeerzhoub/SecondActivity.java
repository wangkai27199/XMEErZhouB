package com.example.dell.xmeerzhoub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity implements View.OnClickListener{

    private TextView login_name;
    private TextView login_pwd;
    private Button query;
    private boolean memory_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        init();
    }

    private void init() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pwd = intent.getStringExtra("pwd");
        memory_pwd = intent.getBooleanExtra("memory_pwd", true);

        login_name.setText(name);

        login_pwd.setText(pwd);
    }

    private void initView() {
        login_name = (TextView) findViewById(R.id.login_name);
        login_pwd = (TextView) findViewById(R.id.login_pwd);
        query = (Button) findViewById(R.id.query);

        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query:

                if (memory_pwd) {
                    new MyToast(SecondActivity.this, "你选择的是记住密码");

                } else {
                    new MyToast(SecondActivity.this, "你未选择记住密码");
                }

                break;
        }
    }
    public class MyToast {

        public MyToast(Context context, String prompt) {
            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            View view = View.inflate(context, R.layout.mytoast, null);
            TextView tvPrompt = (TextView) view.findViewById(R.id.tv_prompt);
            tvPrompt.setText(prompt);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }
}
