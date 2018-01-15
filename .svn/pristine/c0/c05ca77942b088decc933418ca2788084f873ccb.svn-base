package com.chinaitop.linxia.demo.activity.ZhiFa.two;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chinaitop.linxia.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zhifa2Fragment extends Fragment {
    Fragment left, right;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.iv_left)
    View viewLeft;
    @BindView(R.id.rrl_left)
    RelativeLayout rrlLeft;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.iv_right)
    View viewRight;
    @BindView(R.id.rrl_right)
    RelativeLayout rrlRight;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;

    private ViewPager mViewPager;
    private FragmentPagerAdapter pagerAdapter;

    public Zhifa2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa2, container, false);
        getActivity().setTitle("统计分析");
        unbinder = ButterKnife.bind(this, root);
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        //viewPager
        mViewPager = (ViewPager) root.findViewById(R.id.viewPager);
        left = new Zhifa21Fragment();
        right = new Zhifa22Fragment();

        pagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return left;
                }
                return right;
            }


            @Override
            public int getCount() {
                return 2;
            }

        };
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    chooseLeft();
                } else {
                    chooseRight();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //others
        rrlLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        rrlRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }

    private void chooseRight() {
        viewLeft.setVisibility(View.INVISIBLE);
        viewRight.setVisibility(View.VISIBLE);
        tvRight.setTextSize(16);
        tvLeft.setTextSize(15);
        tvRight.setTextColor(Color.parseColor("#13a2e2"));
        tvLeft.setTextColor(Color.parseColor("#666666"));
    }

    private void chooseLeft() {
        viewLeft.setVisibility(View.VISIBLE);
        viewRight.setVisibility(View.INVISIBLE);
        tvLeft.setTextSize(16);
        tvRight.setTextSize(15);
        tvLeft.setTextColor(Color.parseColor("#13a2e2"));
        tvRight.setTextColor(Color.parseColor("#666666"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
