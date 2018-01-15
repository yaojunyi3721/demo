package com.chinaitop.linxia.demo.activity.AnQuan.LuJing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.ZhiFa.two.Zhifa22;
import com.chinaitop.linxia.demo.activity.ZhiFa.two.Zhifa22Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LujingLeftFragment extends Fragment {


    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;

    public LujingLeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lujing_left, container, false);
        unbinder = ButterKnife.bind(this, root);
        String parentId = getArguments().getString("parentId");
        LujingItem[] data;
        if (parentId != null && parentId.equals("1")) {
            data = LujingData.ruku1;
        } else {
            data = LujingData.ruku2;
        }
        lvMain.setAdapter(new LujingItemAdapter(data,getActivity()));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
