package com.example.administrator.teamwork.PersonSetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/21.
 */
public class NewDrawboardActivity extends Activity {
    ImageButton back;
    ImageView save;
    EditText boradTitle;
    TextView description;
    TextView kind;
    public EditText getBoradTitle() {
        return boradTitle;
    }

    public void setBoradTitle(EditText boradTitle) {
        this.boradTitle = boradTitle;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawboard_new_layout);
    back= (ImageButton) findViewById(R.id.ib_back_transPond);
        boradTitle= (EditText) findViewById(R.id.ed_borad_name);
        save= (ImageView) findViewById(R.id.ib_true_new_board);
        kind= (TextView) findViewById(R.id.ed_classify);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=boradTitle.getText().toString();

                 if (name==null){
                     Toast.makeText(NewDrawboardActivity.this,"请填写画板名称",Toast.LENGTH_SHORT).show();
                 }else if (kind==null){
                     Toast.makeText(NewDrawboardActivity.this,"请选择画板",Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(NewDrawboardActivity.this,"创建完成",Toast.LENGTH_SHORT).show();

                 }
            }
        });

    }
}
