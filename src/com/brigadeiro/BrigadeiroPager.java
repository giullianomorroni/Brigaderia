package com.brigadeiro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BrigadeiroPager extends FragmentPagerAdapter {

	private static int TOTAL_BRIGADEIROS = 8;
	
	public BrigadeiroPager(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = new BrigadeiroView();
		Bundle args = new Bundle();
		args.putInt(BrigadeiroView.ARG_SECTION_NUMBER, position);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {
		return TOTAL_BRIGADEIROS;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Sabor sabor = new Sabor(position);
		return sabor.titulo();
	}

}
