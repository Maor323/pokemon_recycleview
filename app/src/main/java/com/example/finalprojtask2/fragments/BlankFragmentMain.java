package com.example.finalprojtask2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojtask2.adapters.CustomAdapter;
import com.example.finalprojtask2.models.DataModel;
import com.example.finalprojtask2.storage.MyData;
import com.example.finalprojtask2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentMain extends Fragment {

    //global variables
    private ArrayList<DataModel> dataSet;//the DataModel arraylist object we will create which we will 'throw' to the adapter
    private RecyclerView recycleView;//create object of recycleview
    private LinearLayoutManager layoutManager;
    private CustomAdapter addapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentMain newInstance(String param1, String param2) {
        BlankFragmentMain fragment = new BlankFragmentMain();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank_main, container, false);

        initRecycleView(view);//initiate the recycle view
        getDataFromDataBase();//create the arraylist objects
        startAdapter();//'throw' the array to the adapter and start the adapter

        return view;
    }

    void initRecycleView(View view){
        recycleView=view.findViewById(R.id.mRecycleViewMain);

        layoutManager = new LinearLayoutManager(getContext()); //thw cards will be displayed in horizontal position
        recycleView.setLayoutManager(layoutManager);//

        recycleView.setItemAnimator(new DefaultItemAnimator());
    }

    void getDataFromDataBase(){
        dataSet = new ArrayList<DataModel>();

        //build the array, every cell is a character "card"
        for(int i = 0; i< MyData.nameArray.length ; i++)
        {
            dataSet.add(new DataModel(MyData.nameArray[i],
                    MyData.versionArray[i], MyData.id_[i],
                    MyData.drawableArray[i]));
        }
    }

    void startAdapter(){
        addapter = new CustomAdapter(dataSet);//'throw' the array into the adapter
        recycleView.setAdapter(addapter);//initiate the adapter
    }
}