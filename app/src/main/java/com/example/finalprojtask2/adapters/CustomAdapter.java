package com.example.finalprojtask2.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojtask2.models.DataModel;
import com.example.finalprojtask2.R;

import java.util.ArrayList;

//we use the arraylist from DataModel, create cards and put it into the recycle
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    //create arraylist
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet) {

        //objects array we will work on
        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        CardView cardView;
        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder (View itemView )
        {
            super(itemView);

            //extract all the data from the layout "cards_layout"
            cardView = itemView.findViewById(R.id.cardCardsLayoutView);
            textViewName = itemView.findViewById(R.id.nameTextViewCardsLayoutPage);
            textViewVersion = itemView.findViewById(R.id.aboutTextViewCardsLayoutPage);
            imageViewIcon = itemView.findViewById(R.id.imageViewCardsLayoutPage);
        }
    }


    //operator the onBindViewHolder func
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        //inflate the card
        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        //return the array to the onBindViewHolder func
        return myViewHolder;
    }

    //extract the data from the arraylist by the position in the array and get into the card
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {

        //extract the data
        TextView textViewName = viewHolder.textViewName;
        TextView textViewVersion = viewHolder.textViewVersion;
        ImageView imageView = viewHolder.imageViewIcon;

        //put the data into the arraylist by each position
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getDesc());
        imageView.setImageResource(dataSet.get(listPosition).getImage());


        Bundle bundle = new Bundle();//create bundle object
        bundle.putInt("id",dataSet.get(listPosition).getId());//put the id of the object from the array
        bundle.putInt("image",dataSet.get(listPosition).getImage());//put the image of the object from the array

        //what happend when click on the card
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate((R.id.action_blankFragmentMain_to_blankFragmentAbout),bundle);
            }
        });
    }

    //data size in the recycle view
    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}