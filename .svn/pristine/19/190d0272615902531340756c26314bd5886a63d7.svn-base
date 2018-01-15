package com.chinaitop.linxia.demo.activity.ZhiFa.one;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa13Fragment extends Fragment {
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.lv_main)
    ListView lvMain;
    Unbinder unbinder;
    private ZhifaInfo[] data = new ZhifaInfo[]{
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮", true),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
            new ZhifaInfo("石家庄粮食公司", "HGGHI3749827", "张先生", "地方储备粮"),
    };

    public Zhifa13Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa13, container, false);
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
        Zhifa13Adapter adapter = new Zhifa13Adapter(data, getContext());
        lvMain.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public static class Zhifa13Adapter extends BaseAdapter {
        private ZhifaInfo[] data;
        private Context mContext;

        public Zhifa13Adapter(ZhifaInfo[] data, Context mContext) {
            this.data = data;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public ZhifaInfo getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView==null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_zhifa13, parent, false);
                holder=new ViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolder) convertView.getTag();
            }
            ZhifaInfo item = getItem(position);
            holder.tvCompany.setText(item.company);
            holder.tvId.setText(item.id);
            holder.tvPerson.setText("法人："+item.legalPerson);
            holder.tvType.setText("检查类型："+item.type);
            if (item.current){
                holder.ivCurrent.setVisibility(View.VISIBLE);
            }else{
                holder.ivCurrent.setVisibility(View.INVISIBLE);
            }
            return convertView;
        }

        static class ViewHolder {
            @BindView(R.id.iv_current)
            ImageView ivCurrent;
            @BindView(R.id.tv_company)
            TextView tvCompany;
            @BindView(R.id.tv_id)
            TextView tvId;
            @BindView(R.id.tv_person)
            TextView tvPerson;
            @BindView(R.id.tv_type)
            TextView tvType;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
