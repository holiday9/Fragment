package com.example.testfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private PagerAdapter mPagerAdapter;
	private TabWidget mTabWidget;

	private int mCount = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

		initTableWidget();
		initViewPaper();
	}

	private void initViewPaper() {
		mPagerAdapter = new MyPageAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(mOnPageChangeListener);
	}

	private void initTableWidget() {
		for (int i = 0; i < mCount; i++) {
			Button btn1 = new Button(this);
			btn1.setTag(i);
			btn1.setText(String.valueOf(i));
			mTabWidget.addView(btn1);
			btn1.setOnClickListener(mTabClickListener);
		}
	}

	private void initView() {
		mTabWidget = (TabWidget) findViewById(R.id.tabwidget);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
	}

	private View.OnClickListener mTabClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			int index = (Integer) v.getTag();
			System.out.println(index);

			mViewPager.setCurrentItem(index);
		}
	};

	private OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {

		@Override
		public void onPageSelected(int index) {
			System.out.println("onPageSelected.index = " + index);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	private class MyPageAdapter extends FragmentStatePagerAdapter {

		public MyPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			System.out.println("position = " + position);
			return MyFragment.create(position);
		}

		@Override
		public int getCount() {
			return mCount;
		}

	}

	private static class MyFragment extends Fragment {
		public static MyFragment create(int index) {
			MyFragment f = new MyFragment();
			Bundle b = new Bundle();
			b.putInt("index", index);
			f.setArguments(b);
			return f;
		}


		private int index;

		public MyFragment() {
		}
		
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onCreate
		//
		////////////////////////////////////////////////////////////////////
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			index = getArguments().getInt("index");
			
			p("------------------------------onAttach, index = " + index);
		}

		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			p("------------------------------onCreate, index = " + index);
		}

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			p("------------------------------onCreateView, index = " + index);

			View rootView = inflater.inflate(R.layout.fragment_main, null);
			TextView textView = (TextView) rootView.findViewById(R.id.text);
			textView.setText(String.valueOf(index));

			return rootView;

		}
		
		public void onActivityCreated(Bundle savedInstanceState) {
			p("------------------------------onActivityCreated, index = " + index);

			super.onActivityCreated(savedInstanceState);
		}
		
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onStart
		//
		////////////////////////////////////////////////////////////////////
		public void onStart() {
			p("------------------------------onStart, index = " + index);

			super.onStart();
		}
		
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onResume
		//
		////////////////////////////////////////////////////////////////////
		public void onResume() {
			p("------------------------------onResume, index = " + index);

			super.onResume();
		}
		
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onPause
		//
		////////////////////////////////////////////////////////////////////
		public void onPause() {
			p("------------------------------onPause, index = " + index);

			super.onPause();
		}
		
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onStop
		//
		////////////////////////////////////////////////////////////////////
		public void onStop() {
			p("------------------------------onStop, index = " + index);

			super.onStop();
		}
		////////////////////////////////////////////////////////////////////
		//
		//  during activity's onDestroy
		//
		////////////////////////////////////////////////////////////////////
		public void onDestroyView() {
			p("------------------------------onDestroyView, index = " + index);

			super.onDestroyView();
		}
		
		public void onDestroy() {
			p("------------------------------onDestory, index = " + index);

			super.onDestroy();
		}
		
		public void onDetach() {
			p("------------------------------onDetach, index = " + index);

			super.onDetach();
		}
		

		private void p(String s) {
			Log.d("htyuan", s);
		}
	}
}
