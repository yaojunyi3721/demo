package com.chinaitop.linxia.demo.activity.ZhiFa.one;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.chinaitop.linxia.demo.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa12Fragment extends Fragment {
    @BindView(R.id.bt_upload)
    Button btUpload;
    private String[] titles = {
            "中国公务员执法检查法第1条",
            "中国公务员执法检查法第2条",
            "中国公务员执法检查法第3条",
            "中国公务员执法检查法第4条",
            "中国公务员执法检查法第5条",
            "中国公务员执法检查法第6条",
            "中国公务员执法检查法第7条",
            "中国公务员执法检查法第8条",
    };

    private String[] details = {
            "为了完善公务员职位分类，建立符合行政执法类公务员特点的管理制度，提高管理效能和科学化水平，建设高素质公务员队伍，根据公务员法及有关法律、法规，制定本规定。",
            "本规定所称行政执法类公务员，是指依照法律、法规对行政相对人直接履行行政许可、行政处罚、行政强制、行政征收、行政收费、行政检查等执法职责的公务员，其职责具有执行性、强制性。",
            "行政执法类公务员的管理，坚持党管干部原则，坚持德才兼备、以德为先，坚持注重实绩、群众公认，坚持监督约束与激励保障并重，注重提高执法效能。\n" +
                    "行政执法类公务员的管理，坚持公开、平等、竞争、择优的原则，依照法定的权限、条件、标准和程序进行。",
            "行政执法类公务员应当模范遵守宪法和法律，按照规定的权限和程序认真履行职责，坚持依法行政，做到严格规范公正文明执法。",
            "中央公务员主管部门负责全国行政执法类公务员的综合管理工作。县级以上地方各级公务员主管部门负责本辖区内行政执法类公务员的综合管理工作。上级公务员主管部门指导下级公务员主管部门的行政执法类公务员管理工作。各级公务员主管部门指导同级机关的行政执法类公务员管理工作。",
            "行政执法类公务员职位根据工作性质、执法职能和管理需要，在以行政执法工作为主要职责的机关或者内设机构设置。\n" +
                    "行政执法类公务员职位设置范围由中央公务员主管部门确定。",
            "机关依照职能、国家行政编制和中央公务员主管部门确定的职位设置范围等，制定本机关行政执法类公务员职位设置方案，并确定职位的具体工作职责和任职资格条件。",
            "中央和国家机关直属机构行政执法类公务员职位设置方案，报中央公务员主管部门审批；省级以下机关及其直属机构行政执法类公务员职位设置方案，由省级公务员主管部门审批后报中央公务员主管部门备案。"
    };
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.lv_expand)
    ExpandableListView lvExpand;
    Unbinder unbinder;

    public Zhifa12Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa12, container, false);
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
        ExpandAdapter adapter = new ExpandAdapter(titles, details, getContext());
        lvExpand.setAdapter(adapter);
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("请稍候...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCanceledOnTouchOutside(false);
        btUpload.setVisibility(View.VISIBLE);
        btUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "数据同步完成", Toast.LENGTH_SHORT).show();
                            }
                        });
                        this.cancel();
                    }
                }, 1000);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class ExpandAdapter extends BaseExpandableListAdapter {
        private String[] parents;
        private String[] children;
        private Context mContext;

        public ExpandAdapter(String[] parents, String[] children, Context mContext) {
            this.parents = parents;
            this.children = children;
            this.mContext = mContext;
        }

        @Override
        public int getGroupCount() {
            return parents.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public String getGroup(int groupPosition) {
            return parents[groupPosition];
        }

        @Override
        public String getChild(int groupPosition, int childPosition) {
            return children[groupPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.parent_zhifa12, parent, false);
            TextView tv1 = convertView.findViewById(R.id.expandable_group_textview);
            tv1.setText(getGroup(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.child_zhifa12, parent, false);
            TextView tv1 = convertView.findViewById(R.id.expandable_child_textview);
            tv1.setText(getChild(groupPosition, childPosition));
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
