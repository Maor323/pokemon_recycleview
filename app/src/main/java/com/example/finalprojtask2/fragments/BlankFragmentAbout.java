package com.example.finalprojtask2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalprojtask2.storage.MyData;
import com.example.finalprojtask2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentAbout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentAbout extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentAbout() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentAbout.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentAbout newInstance(String param1, String param2) {
        BlankFragmentAbout fragment = new BlankFragmentAbout();
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
        View view= inflater.inflate(R.layout.fragment_blank_about, container, false);

        TextView aboutCharacterText=view.findViewById(R.id.aboutTextViewAboutPage);//extract the info of the character
        ImageView imageView=view.findViewById(R.id.imageViewAboutPage);//extract the image of the character

        //set the info of the character
        aboutCharacterText.setText(MyData.aboutArray[getArguments().getInt("id")]);
        //set the image of the character
        imageView.setImageResource(getArguments().getInt("image"));

        return view;
    }
}