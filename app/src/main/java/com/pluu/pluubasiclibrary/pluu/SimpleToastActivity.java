package com.pluu.pluubasiclibrary.pluu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.pluu.pluubasiclibrary.R;
import com.pluu.pluubasiclibrary.pluu.base.BaseActivity;
import com.pluu.pluubasiclibrary.pluu.base.SimpleToast;
import com.pluu.pluubasiclibrary.pluu.base.SimpleToast.COLOR_TYPE;

public class SimpleToastActivity extends BaseActivity {

	@Bind(R.id.toolbar)
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_toast);
		ButterKnife.bind(this);

		initToolbar(toolbar);

		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.content, new MyFragment())
			.commit();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (baseOptionsItemSelected(item)) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private class MyFragment extends ListFragment {
		@Override
		public void onActivityCreated(@Nullable Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);

			COLOR_TYPE[] values = COLOR_TYPE.values();
			String[] list = new String[values.length];
			for (int i = 0; i < list.length; i++) {
				list[i] = values[i].name();
			}

			setListAdapter(new ArrayAdapter<>(getActivity(),
				android.R.layout.simple_list_item_1, list));
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);

			COLOR_TYPE type = COLOR_TYPE.values()[position];
			SimpleToast.show(getActivity(),
				type,
				"Show Simple Toast\ntype=" + type.name());
		}
	}

}
