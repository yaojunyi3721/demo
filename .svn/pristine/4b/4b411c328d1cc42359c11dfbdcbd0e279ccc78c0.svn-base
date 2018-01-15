package com.chinaitop.linxia.demo.activity.AppStore.two;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.Apps;
import com.chinaitop.linxia.demo.adapter.StoreAppsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoLeftFragment extends Fragment {


    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;

    public TwoLeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two_left, container, false);
        unbinder = ButterKnife.bind(this, root);
        lvMain.setAdapter(new StoreAppsAdapter(Apps.twoLeft,getActivity()));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
