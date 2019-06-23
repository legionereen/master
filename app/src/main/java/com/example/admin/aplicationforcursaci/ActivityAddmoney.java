package com.example.admin.aplicationforcursaci;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ActivityAddmoney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmoney);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceAsColor")
    public void onAddMoneybuttonClick(View view) {
        int val;
        boolean flag = true;
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Button btnAlpha = findViewById(R.id.btnAlpha);
        btnAlpha.startAnimation(animAlpha);

        @SuppressLint("ResourceType")

        EditText edText1 = findViewById(R.id.editText2);  //номер тлф
        EditText edText2 = findViewById(R.id.editText3);   //сумма
        EditText edText3 = findViewById(R.id.editText4); //номер карты


        if (edText1.length() != 9) {
            flag = false;
            edText1.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style_error));
        } else edText1.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style));

        if (edText2.length() < 2) {
            flag = false;
            edText2.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style_error));
        } else edText2.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style));

        if (edText3.length() < 6) {
            flag = false;
            edText3.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style_error));
        } else edText3.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_style));

        if (flag) {
            val = Integer.parseInt(edText2.getText().toString());
            Toast toast = Toast.makeText(getApplicationContext(), "Вы успешно пополнили свой счет на " + val + " лей", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 385);
            toast.show();
            edText1.setText("");
            edText2.setText("");
            edText3.setText("");

            final LinearLayout lnr = findViewById(R.id.lnr1);
            RelativeLayout rlt = findViewById(R.id.relativeLayout);
            lnr.setVisibility(LinearLayout.INVISIBLE);
            final Animation animEnlarge = AnimationUtils.loadAnimation(this, R.anim.enlarge);
            rlt.setAnimation(animEnlarge);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    lnr.setVisibility(LinearLayout.VISIBLE);
                }
            }, 2000);


        }


    }
}
