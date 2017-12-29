package com.chinaitop.linxia.demo.activity.ZhiFa.one;


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
public class Zhifa1Fragment extends Fragment {
    Fragment left, middle, right;
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
    @BindView(R.id.tv_middle)
    TextView tvMiddle;
    @BindView(R.id.iv_middle)
    View viewMiddle;
    @BindView(R.id.rrl_middle)
    RelativeLayout rrlMiddle;

    private ViewPager mViewPager;
    private FragmentPagerAdapter pagerAdapter;

    public Zhifa1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zhifa1, container, false);
        getActivity().setTitle("执法查询");
        unbinder = ButterKnife.bind(this, root);
        initViews(root);
        return root;
    }

    private void initViews(View root) {
        //viewPager
        mViewPager = (ViewPager) root.findViewById(R.id.viewPager);
        left = new Zhifa11Fragment();
        middle = new Zhifa12Fragment();
        right = new Zhifa13Fragment();

        pagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return left;
                    case 1:
                        return middle;
                    default:
                        return right;
                }
            }


            @Override
            public int getCount() {
                return 3;
            }

        };
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        chooseLeft();
                        break;
                    case 1:
                        chooseMiddle();
                        break;
                    case 2:
                        chooseRight();
                        break;
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
        rrlMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        rrlRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
    }


    private void chooseLeft() {
        viewLeft.setVisibility(View.VISIBLE);
        viewMiddle.setVisibility(View.INVISIBLE);
        viewRight.setVisibility(View.INVISIBLE);
        tvLeft.setTextSize(16);
        tvMiddle.setTextSize(15);
        tvRight.setTextSize(15);
        tvLeft.setTextColor(Color.parseColor("#13a2e2"));
        tvMiddle.setTextColor(Color.parseColor("#666666"));
        tvRight.setTextColor(Color.parseColor("#666666"));
    }

    private void chooseMiddle() {
        viewLeft.setVisibility(View.INVISIBLE);
        viewMiddle.setVisibility(View.VISIBLE);
        viewRight.setVisibility(View.INVISIBLE);
        tvRight.setTextSize(15);
        tvMiddle.setTextSize(16);
        tvLeft.setTextSize(15);
        tvLeft.setTextColor(Color.parseColor("#666666"));
        tvMiddle.setTextColor(Color.parseColor("#13a2e2"));
        tvRight.setTextColor(Color.parseColor("#666666"));
    }

    private void chooseRight() {
        viewLeft.setVisibility(View.INVISIBLE);
        viewMiddle.setVisibility(View.INVISIBLE);
        viewRight.setVisibility(View.VISIBLE);
        tvLeft.setTextSize(15);
        tvMiddle.setTextSize(15);
        tvRight.setTextSize(16);
        tvLeft.setTextColor(Color.parseColor("#666666"));
        tvMiddle.setTextColor(Color.parseColor("#666666"));
        tvRight.setTextColor(Color.parseColor("#13a2e2"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
