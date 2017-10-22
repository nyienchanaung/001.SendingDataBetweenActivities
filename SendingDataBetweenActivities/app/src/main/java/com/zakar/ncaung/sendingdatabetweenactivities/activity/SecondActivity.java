package com.zakar.ncaung.sendingdatabetweenactivities.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zakar.ncaung.sendingdatabetweenactivities.MainApplication;
import com.zakar.ncaung.sendingdatabetweenactivities.Parcel.User;
import com.zakar.ncaung.sendingdatabetweenactivities.R;

public class SecondActivity extends AppCompatActivity {
    EditText edtAge;
    EditText edtAddress;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         user = MainApplication.getUser();
         edtAge = (EditText)findViewById(R.id.edtAge);
         edtAddress =(EditText)findViewById(R.id.edtAddress);

//        Bundle args = getIntent().getExtras();
//         user = args.getParcelable("user");
//
//        Log.d("USER_NAME",String.valueOf(user.getUser_name()));
//        Log.d("USER_EMAIL",String.valueOf(user.getUser_email()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                user.setUser_age(edtAge.getText().toString());
                user.setUser_address(edtAddress.getText().toString());

                Bundle args = new Bundle();
                args.putParcelable("user",user);


                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


//    @Override
    protected void onResume() {
        super.onResume();
        if(user.getUser_age() != null){
            edtAge.setText(user.getUser_age());
            edtAge.setSelection(user.getUser_age().length());
        }
        if(user.getUser_address() != null){
            edtAddress.setText(user.getUser_address());
            edtAddress.setSelection(user.getUser_address().length());
        }
    }
}
