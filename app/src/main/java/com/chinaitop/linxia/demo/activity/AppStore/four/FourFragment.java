package com.chinaitop.linxia.demo.activity.AppStore.four;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chinaitop.linxia.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourFragment extends Fragment {


    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_one, container, false);
        getActivity().setTitle("消息中心");
        return root;
    }

}
