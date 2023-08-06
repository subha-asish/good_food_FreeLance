package com.example.e_commerce.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.e_commerce.R;
import com.example.e_commerce.model.AllCategory;
import com.example.e_commerce.view.show_product;


public class AllCategoryAdapter extends BaseAdapter
{
    Context context;
    ArrayList<AllCategory> gridPojos;



    public AllCategoryAdapter(Context context,ArrayList<AllCategory> gridPojos)
    {
        this.context = context;
        this.gridPojos = gridPojos;
    }

    @Override
    public int getCount()
    {
        return gridPojos.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        view = LayoutInflater.from(context).inflate(R.layout.all_categories_item,viewGroup,false);

        TextView title = view.findViewById(R.id.title);
        ImageView image = view.findViewById(R.id.imageview);
        GridView gridView = view.findViewById(R.id.gridlayout);

        title.setText(gridPojos.get(i).getTitle());
        image.setImageResource(gridPojos.get(i).getImages());





        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, show_product.class);
                AllCategory allCategory = gridPojos.get(i);
                intent.putExtra("title",allCategory.getTitle());
                intent.putExtra("image",allCategory.getImages());
                intent.putExtra("desc",allCategory.getDesc());
                intent.putExtra("price",allCategory.getPrice());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
