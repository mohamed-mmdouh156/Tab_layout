package com.example.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class first_fragment extends Fragment {


    private String mParam1;
    private static final String ARG_PARAM1 = "name";
    private OnFragmentListener listener ;

    public first_fragment() {
        // Required empty public constructor

    }

    public static first_fragment newInstance(String param1) {

        first_fragment fragment = new first_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnFragmentListener) {
            listener = (OnFragmentListener) context;
        }
        else {
            throw new ClassCastException("your activity not implements OnFragmentListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_first_fragment, container, false);

        ListView lv = v.findViewById(R.id.name_list);

        final ArrayList<String> names = new ArrayList<>();

        names.add("Ahmed");
        names.add("mohamed");
        names.add("Hassan");
        names.add("Mmdouh");

        ArrayAdapter<String> Adapter = new ArrayAdapter<>(getActivity() , android.R.layout.simple_list_item_1 , names);
        lv.setAdapter(Adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                listener.FragmentInteraction(names.get(position));

            }
        });

        return v;
    }

    public interface OnFragmentListener {
        void FragmentInteraction (String name);
    }

}


