package com.example.admin.aplicationforcursaci;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;


public class ActivityShop extends AppCompatActivity {


    public final int MENU_BUTTON_ORDER=112233;
    public final int MENU_BUTTON_BOX=221133;


        TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12,txt13,txt14,txt15,txt16,txt17,txt18,txt19,txt20;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       txt1=findViewById(R.id.textView1);
        txt2=findViewById(R.id.textView2);
        txt3=findViewById(R.id.textView3);
        txt4=findViewById(R.id.textView4);
        txt5=findViewById(R.id.textView5);
        txt6=findViewById(R.id.textView6);
        txt7=findViewById(R.id.textView11);
        txt8=findViewById(R.id.textView22);
        txt9=findViewById(R.id.textView33);
        txt10=findViewById(R.id.textView44);
        txt11=findViewById(R.id.textView55);
        txt12=findViewById(R.id.textView66);
        txt13=findViewById(R.id.textView111);
        txt14=findViewById(R.id.textView222);
        txt15=findViewById(R.id.textView333);
        txt16=findViewById(R.id.textView444);
        txt17=findViewById(R.id.textView555);
        txt18=findViewById(R.id.textView666);
        txt19=findViewById(R.id.textView777);
        txt20=findViewById(R.id.textView888);

        registerForContextMenu(txt1);
        registerForContextMenu(txt2);
        registerForContextMenu(txt3);
        registerForContextMenu(txt4);
        registerForContextMenu(txt5);
        registerForContextMenu(txt6);
        registerForContextMenu(txt7);
        registerForContextMenu(txt8);
        registerForContextMenu(txt9);
        registerForContextMenu(txt10);
        registerForContextMenu(txt11);
        registerForContextMenu(txt12);
        registerForContextMenu(txt13);
        registerForContextMenu(txt14);
        registerForContextMenu(txt15);
        registerForContextMenu(txt16);
        registerForContextMenu(txt17);
        registerForContextMenu(txt18);
        registerForContextMenu(txt19);
        registerForContextMenu(txt20);

       if(Product.keys.isEmpty()){
            Product.keys.put(R.id.textView1,R.id.textView14);
            Product.keys.put(R.id.textView2,R.id.textView13);
            Product.keys.put(R.id.textView3,R.id.textView17);
            Product.keys.put(R.id.textView4,R.id.textView15);
            Product.keys.put(R.id.textView5,R.id.textView18);
            Product.keys.put(R.id.textView6,R.id.textView16);
            Product.keys.put(R.id.textView11,R.id.textView19);
            Product.keys.put(R.id.textView22,R.id.textView20);
            Product.keys.put(R.id.textView33,R.id.textView21);
            Product.keys.put(R.id.textView44,R.id.textView23);
            Product.keys.put(R.id.textView55,R.id.textView24);
            Product.keys.put(R.id.textView66,R.id.textView25);
            Product.keys.put(R.id.textView111,R.id.textView26);
            Product.keys.put(R.id.textView222,R.id.textView27);
            Product.keys.put(R.id.textView333,R.id.textView28);
            Product.keys.put(R.id.textView444,R.id.textView29);
            Product.keys.put(R.id.textView555,R.id.textView30);
            Product.keys.put(R.id.textView666,R.id.textView31);
            Product.keys.put(R.id.textView777,R.id.textView32);
            Product.keys.put(R.id.textView888,R.id.textView34);
            //Product.keys.put(key,value)
       }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        TextView txt = findViewById(item.getGroupId());
        int id = item.getItemId();

        switch (id){
            case MENU_BUTTON_ORDER:

                Intent intent = new Intent(ActivityShop.this,Order_Activity.class);
                onItemShopClick(Product.orders,txt);

                intent.putExtra("productId",txt.getId());
                startActivity(intent);
            break;
            case MENU_BUTTON_BOX :
                onItemShopClick(Product.products,txt);
                Toast toast = Toast.makeText(getApplicationContext(), "Товар успешно добавлен в корзину", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 100);
                toast.show();
            break;

        }
        return super.onContextItemSelected(item);
    }



    public void onItemShopClick(List<Product> list ,View v) {
        TextView textView = findViewById(v.getId());
        int key = getValue(v.getId());
        TextView text3 = findViewById(key);
        String price = text3.getText().toString();
        String name = (textView.getText().toString()).replaceAll("\n"," ");
        Drawable [] drawable = textView.getCompoundDrawables();
        Drawable d =drawable[1];
        list.add(new Product(textView.getId(),d,name,price));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){

        menu.add(v.getId(),MENU_BUTTON_ORDER,0,"Заказать");
        menu.add(v.getId(),MENU_BUTTON_BOX,0,"Добавить в корзину");
    }

    public  Integer getValue(Integer key){
        for( Map.Entry<Integer,Integer> entry : Product.keys.entrySet()){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void onClickTextView(View view) {
        openContextMenu(view);
    }
}