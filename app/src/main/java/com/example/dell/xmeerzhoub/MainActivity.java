package com.example.dell.xmeerzhoub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText name;
    private EditText pwd;
    private CheckBox memory_pwd;
    private CheckBox automatic_login;
    private CheckBox fuwu;
    private TextView tiaokuan;
    private LinearLayout activity_main;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        memory_pwd = (CheckBox) findViewById(R.id.memory_pwd);
        automatic_login = (CheckBox) findViewById(R.id.automatic_login);
        fuwu = (CheckBox) findViewById(R.id.fuwu);
        tiaokuan = (TextView) findViewById(R.id.tiaokuan);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

    }

    private void submit() {
        // validate
        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwdString = pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwdString)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("pwd", pwd.getText().toString());
        intent.putExtra("memory_pwd", memory_pwd.isChecked());

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                submit();
                break;
        }
    }
}
