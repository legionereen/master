package com.example.admin.aplicationforcursaci;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

public class Order_Activity extends AppCompatActivity {
    private static final String TAG = "MyPersonalLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);

        Log.e(TAG,"step 1");
        int productId= getIntent().getIntExtra("productId",0);
        Iterator<Product> iterator;

        if(!Product.orders.isEmpty()){
            iterator = Product.orders.iterator();
        }
        else
        iterator = Product.products.iterator();

        while (iterator.hasNext()){
            Product value = iterator.next();
            Log.e(TAG,"step 2");
            if(value.getProductId()==productId){

                LinearLayout.LayoutParams paramsForView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams paramsForLinearLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                Log.e(TAG,"step 3");
                ImageView img = new ImageView(Order_Activity.this);

                final LinearLayout lnr = new LinearLayout(Order_Activity.this);   //общий Контейнер для товара (horizontal)
                LinearLayout lnrVertical = new LinearLayout(Order_Activity.this);   //Контейнер для информации по товару (vertical)
                LinearLayout linearLayoutForButtons = new LinearLayout(Order_Activity.this);  // Контейнер для кнопок
                Log.e(TAG,"step 4");

                final TextView txt = new TextView(Order_Activity.this);   //Название товара
                TextView txt2 = new TextView(Order_Activity.this);    //Цена товара

                txt.setText(value.getProductName());
                txt2.setText(value.getPrice());
                txt.setTextSize(20);
                txt2.setTextSize(18);
                txt.setTextColor(Color.BLACK);
                txt2.setTextColor(Color.rgb(255,136,0));
                lnrVertical.setOrientation(LinearLayout.VERTICAL);
                lnr.setBackgroundColor(Color.WHITE);
                lnr.setPadding(0,0,0,5);
                img.setImageDrawable(value.getImage());
                Log.e(TAG,"step 5");
                txt.setLayoutParams(paramsForView);        //Границы
                txt2.setLayoutParams(paramsForView);
                linearLayoutForButtons.setLayoutParams(paramsForLinearLayout);
                lnr.setLayoutParams(paramsForLinearLayout);
                lnrVertical.setLayoutParams(new LinearLayout.LayoutParams(300,
                        ViewGroup.LayoutParams.WRAP_CONTENT,2));
                img.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,1));
                Log.e(TAG,"step 6");
                lnrVertical.addView(txt);
                lnrVertical.addView(txt2);
                lnrVertical.addView(linearLayoutForButtons);
                lnr.addView(img);
                lnr.addView(lnrVertical);
                LinearLayout linr = findViewById(R.id.new_linr1);
                linr.addView(lnr);
                Log.e(TAG,"step 6");
                break;
            }

        }
        Product.orders.removeAll(Product.orders);

    }




    public void onButtonOrderClick(View view) {
        EditText editText1 = findViewById(R.id.editText);       //Имя
        EditText editText2 = findViewById(R.id.editText5);      //мобильный тлф
        EditText editText3 = findViewById(R.id.editText6);      //Город
        EditText editText4 = findViewById(R.id.editText7);      //Улица
        EditText editText5 = findViewById(R.id.editText8);      //Почтовый индекс
        EditText editText6 = findViewById(R.id.editText9);      //Количество


        String ed1,ed2,ed3,ed4,ed5,ed6;
        ed1=editText1.getText().toString();
        ed2=editText2.getText().toString();
        ed3=editText3.getText().toString();
        ed4=editText4.getText().toString();
        ed5=editText5.getText().toString();
        ed6=editText6.getText().toString();


        if(ed1.length()>0&&ed2.length()>9&&ed3.length()>0&&ed4.length()>0&&ed5.length()>0&&ed6.length()>0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Ваш заказ успешно оформлен", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 100);
            toast.show();
        }
    }

    public void onButtonCancelClick(View view) {
        finish();
    }
}
