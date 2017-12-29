package com.chinaitop.linxia.demo.activity.ZhiFa.one;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;
import com.chinaitop.linxia.demo.activity.Apps;
import com.chinaitop.linxia.demo.adapter.StoreAppsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa11Fragment extends Fragment {


    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;
    @BindView(R.id.search_view)
    SearchView searchView;
    ZhifaInfo[] data = new ZhifaInfo[]{
            new ZhifaInfo(),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
            new ZhifaInfo("2016-11-30","aa","bb","地方储备粮","没有问题","无需处理"),
    };

    public Zhifa11Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa11, container, false);
        unbinder = ButterKnife.bind(this, root);
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getActivity(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        lvMain.setAdapter(new Zhifa11Adapter(getContext(), data));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
