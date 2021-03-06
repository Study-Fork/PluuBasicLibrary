package com.pluu.pluubasiclibrary.pluu.base;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * BaseActionBar Activity
 * Created by PLUUSYSTEM on 2015-02-03.
 */
public class BaseActivity extends AppCompatActivity {

	protected void initToolbar(Toolbar toolbar) {
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	protected boolean baseOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		} else {
			return false;
		}
	}
}
