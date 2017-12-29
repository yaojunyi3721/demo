package com.chinaitop.linxia.demo.activity.ZhiFa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinaitop.linxia.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa4Fragment extends Fragment {


    public Zhifa4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  root=inflater.inflate(R.layout.fragment_zhifa4, container, false);
        getActivity().setTitle("我的");
        return root;
    }

}
