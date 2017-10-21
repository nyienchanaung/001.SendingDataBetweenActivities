package com.zakar.ncaung.sendingdatabetweenactivities.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.zakar.ncaung.sendingdatabetweenactivities.MainApplication;
import com.zakar.ncaung.sendingdatabetweenactivities.Parcel.User;
import com.zakar.ncaung.sendingdatabetweenactivities.R;

public class FirstActivity extends AppCompatActivity {

    User user;
    EditText edtName;
    EditText edtEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = MainApplication.getUser();
        edtName = (EditText)findViewById(R.id.edtName);
        edtEmail = (EditText)findViewById(R.id.edtEmail);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                float button အ၀ိုင်းေလးကနိှပ်ရင်   လုပ်မည် action
                 */
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                user.setUser_name(edtName.getText().toString());
                user.setUser_email(edtEmail.getText().toString());

                Bundle args = new Bundle();
                args.putParcelable("user",user);
                //go to next activity
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    //Need to generate method onResume
    /*
    second activity ကို data သယ်သွားပီး  first activity သို့ြပန်လာလျင်  မူလ data ြပန်ရေအာင်
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(user.getUser_name() != null){
            edtName.setText(user.getUser_name());
            edtName.setSelection(user.getUser_name().length());
        }
        if(user.getUser_email() != null){
            edtEmail.setText(user.getUser_email());
        }

    }
}
