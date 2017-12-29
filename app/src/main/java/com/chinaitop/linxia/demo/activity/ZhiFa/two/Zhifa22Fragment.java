package com.chinaitop.linxia.demo.activity.ZhiFa.two;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa22Fragment extends Fragment {


    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;

    Zhifa22[] data=new Zhifa22[]{
            new Zhifa22(),
            new Zhifa22("石家庄","56","5","9%"),
            new Zhifa22("保定","23","6","26%"),
            new Zhifa22("廊坊","12","8","67%"),
            new Zhifa22("邢台","56","6","11%"),
            new Zhifa22("衡水","34","5","15%"),
            new Zhifa22("承德","23","4","11%"),
            new Zhifa22("秦皇岛","67","3","4%"),
            new Zhifa22("唐山","45","24","53%"),
            new Zhifa22("沧州","34","23","68%"),
            new Zhifa22("邯郸","23","12","52%"),
            new Zhifa22("张家口","52","3","6%"),
    };
    public Zhifa22Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa22, container, false);
        unbinder = ButterKnife.bind(this, root);
        lvMain.setAdapter(new Zhifa22Adapter(getContext(),data));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
