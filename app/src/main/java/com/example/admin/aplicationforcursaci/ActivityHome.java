package com.example.admin.aplicationforcursaci;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Iterator;
import java.util.ListIterator;

public class ActivityHome extends AppCompatActivity {

    ListIterator<Product> listIterator = Product.products.listIterator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        for(final Product a:Product.products){
            if(listIterator.hasNext()){
                final int index=a.getProductId();
                LinearLayout.LayoutParams paramsForView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                LinearLayout.LayoutParams paramsForLinearLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                Button buttonForRemoving = new Button(this);
                Button buttonForOrdering = new Button(this);

                ImageView img = new ImageView(ActivityHome.this);

                final LinearLayout lnr = new LinearLayout(ActivityHome.this);   //общий Контейнер для товара (horizontal)
                LinearLayout lnrVertical = new LinearLayout(ActivityHome.this);   //Контейнер для информации по товару (vertical)
                final LinearLayout space = new LinearLayout(ActivityHome.this);   //общий Контейнер для товара (horizontal)
                LinearLayout linearLayoutForButtons = new LinearLayout(ActivityHome.this);  // Контейнер для кнопок



                final TextView txt = new TextView(ActivityHome.this);   //Название товара
                TextView txt2 = new TextView(ActivityHome.this);    //Цена товара

                txt.setText(a.getProductName());
                txt2.setText(a.getPrice());
                txt.setTextSize(20);
                txt2.setTextSize(18);
                txt.setTextColor(Color.BLACK);
                txt2.setTextColor(Color.rgb(255,136,0));
                lnrVertical.setOrientation(LinearLayout.VERTICAL);
                lnr.setBackgroundColor(Color.WHITE);
                space.setPadding(0,0,0,10);
                space.setBackgroundColor(Color.TRANSPARENT);
                lnr.setPadding(0,0,0,5);
                img.setImageDrawable(a.getImage());
                img.setPadding(0,0,0,0);
                buttonForOrdering.setText("Заказать");
                buttonForRemoving.setText("Удалить");

                buttonForRemoving.setLayoutParams(paramsForView);
                buttonForOrdering.setLayoutParams(paramsForView);
                buttonForOrdering.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ActivityHome.this,Order_Activity.class);
                        intent.putExtra("productId",index);
                        startActivity(intent);
                    }
                });
                buttonForRemoving.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lnr.removeAllViews();
                        lnr.setVisibility(View.INVISIBLE);
                        lnr.setPadding(0,0,0,0);
                        space.setPadding(0,0,0,0);
                        space.setVisibility(View.INVISIBLE);
                       Iterator<Product> iterator = Product.products.iterator();
                        while (iterator.hasNext()){
                            Product value = iterator.next();
                            if(value.getProductName().equals(txt.getText().toString())){
                                iterator.remove();
                                break;
                            }
                        }
                    }
                });
                txt.setLayoutParams(paramsForView);        //Границы
                txt2.setLayoutParams(paramsForView);
                linearLayoutForButtons.setLayoutParams(paramsForLinearLayout);
                space.setLayoutParams(paramsForLinearLayout);
                lnr.setLayoutParams(paramsForLinearLayout);
                lnrVertical.setLayoutParams(new LinearLayout.LayoutParams(300,ViewGroup.LayoutParams.WRAP_CONTENT,2));
                img.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,1));

                linearLayoutForButtons.addView(buttonForOrdering);
                linearLayoutForButtons.addView(buttonForRemoving);
                lnrVertical.addView(txt);
                lnrVertical.addView(txt2);
                lnrVertical.addView(linearLayoutForButtons);
                lnr.addView(img);
                lnr.addView(lnrVertical);
                addTextViewInActivity(lnr);
                addTextViewInActivity(space);

                listIterator.next();
            }
        }
        Button btn = new Button(this);
        btn.setLayoutParams( new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        LinearLayout lnr = findViewById(R.id.linr1);
        lnr.addView(btn);
        btn.setVisibility(View.INVISIBLE); //Чтобы не было видно только половина картинки последнего товара добавленного в корзину
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void addTextViewInActivity(LinearLayout linr){
        LinearLayout lnr = findViewById(R.id.linr1);
        lnr.addView(linr);

    }

}
