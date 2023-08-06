package com.example.e_commerce.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce.R;


public class show_product extends AppCompatActivity
{
    Button buy_now;
    TextView priceTextView,titleTextView,descTextView;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_product);

        buy_now = findViewById(R.id.buy_now);
        priceTextView = findViewById(R.id.price);
        descTextView =findViewById(R.id.descc);
        imageView = findViewById(R.id.imagee);
        titleTextView =findViewById(R.id.title);

        Intent intent = getIntent();
        String title =intent.getStringExtra("title");
        int image = intent.getIntExtra("image",-1);
        String desc = intent.getStringExtra("desc");
        String price = intent.getStringExtra("price");

        priceTextView.setText("$"+price.toString());
       descTextView.setText(desc);
      titleTextView.setText(title);
        imageView.setImageResource(image);


        buy_now.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(show_product.this, order_placing.class);
                startActivity(intent);
            }
        });
    }
}
