package com.example.e_commerce.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import com.example.e_commerce.R;
import com.example.e_commerce.SliderItem;

import com.example.e_commerce.adapter.slider_adapter;
import com.example.e_commerce.databinding.HomeBinding;


public class Home extends Fragment
{
    //HomeViewModel mViewModel;
    SearchView searchView;
    ImageView cart;

    SliderView sliderView;
    private slider_adapter adapter;
    HomeBinding homeBinding;
    DrawerLayout drawerLayout;

    CardView chipsCV,drinksCV,foodCV;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
      // View view = inflater.inflate(R.layout.home,container,false);

        homeBinding = DataBindingUtil.inflate(inflater, R.layout.home, container, false);
        View view = homeBinding.getRoot();

        cart = homeBinding.cart;
        searchView = homeBinding.searchView;
        sliderView = homeBinding.imageSlider;
        chipsCV = view.findViewById(R.id.chipsCardView);
        drinksCV = view.findViewById(R.id.drinksCardView);
        foodCV = view.findViewById(R.id.foodCardView);


        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.purple));

        chipsCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), all_categories.class);
                i.putExtra("id",0);
                startActivity(i);
            }
        });
        drinksCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), all_categories.class);
                i.putExtra("id",1);
                startActivity(i);
            }
        });

        foodCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), all_categories.class);
                i.putExtra("id",2);
                startActivity(i);

            }
        });




       // mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
      //  mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


       // mViewModel.init();

        /*mViewModel.getUsers().observe(this, users -> {
            // update UI
        });*/

      /*  mViewModel.getUsers().observe(getContext(), new Observer<VolumesResponse>()
        {
            @Override
            public void onChanged(VolumesResponse volumesResponse)
            {
                // update the ui.
                if(volumesResponse != null)
                    adapter.setResults(volumesResponse.getItems());
            }
        });*/


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                if(query.equals("shoes"))
                {
                    Intent intent = new Intent(getContext(), search_result.class);
                    startActivity(intent);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

        cart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });



        adapter = new slider_adapter(getContext());

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener()
        {
            @Override
            public void onIndicatorClicked(int position)
            {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });

        addNewItem(view);
        renewItems(view);
        removeLastItem(view);

        return view;
    }

    public void renewItems(View view)
    {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++)
        {
            SliderItem sliderItem = new SliderItem();
            if (i % 2 == 0)
            {
                sliderItem.setImageUrl("https://img.freepik.com/free-photo/big-sandwich-hamburger-with-juicy-beef-burger-cheese-tomato-red-onion-wooden-table_2829-19631.jpg?size=626&ext=jpg&ga=GA1.2.1803494769.1691327612&semt=sph");
            }
            else
            {
                sliderItem.setImageUrl("https://img.freepik.com/free-photo/fresh-pasta-with-hearty-bolognese-parmesan-cheese-generated-by-ai_188544-9469.jpg?size=626&ext=jpg");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renewItems(sliderItemList);
    }

    public void removeLastItem(View view)
    {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(View view)
    {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescription("Slider Item Added Manually");
        sliderItem.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.addItem(sliderItem);
    }
}