package com.chinaitop.linxia.demo.activity.AppStore.one;


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
public class OneFragment extends Fragment {


    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_one, container, false);
        getActivity().setTitle("我的应用");
        unbinder = ButterKnife.bind(this, root);

        lvMain.setAdapter(new StoreAppsAdapter(Apps.one, getActivity()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
