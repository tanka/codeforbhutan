package com.tanka.fastdial.adapter;

import java.util.List;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tanka.fastdial.R;
import com.tanka.fastdial.pojo.ContactData;

public class ListplacesAdapter extends ArrayAdapter<ContactData> {

	private final List<ContactData> list;
	private final Activity context;
	private ContactData dataPlace;
	private int mViewId;

	// ResponseCallback key;

	/*
	 * public ResponseCallback getKey() { return key; }
	 * 
	 * public void setKey(ResponseCallback key) { this.key = key; }
	 */

	public ListplacesAdapter(Activity context, int textViewResourceId,
			List<ContactData> list) {
		super(context, R.layout.row_list_contacts, list);
		this.context = context;
		this.list = list;
		mViewId = textViewResourceId;
	}

	static class ViewHolder {
		protected TextView name;
		protected TextView descr;
		protected LinearLayout layoutFacilities;
		protected LinearLayout layoutOffer;
		protected ImageView imgRef;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(mViewId, null);
			final ViewHolder viewHolder = new ViewHolder();
			viewHolder.name = (TextView) view.findViewById(R.id.place_info);
			viewHolder.descr = (TextView) view.findViewById(R.id.place_name);
			viewHolder.imgRef = (ImageView) view.findViewById(R.id.img_ref);
			
			view.setTag(viewHolder);
		} else {
			view = convertView;
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		dataPlace = list.get(position);	

		if (dataPlace.getName() != null) {
			holder.name.setText(dataPlace.getName());
			Log.v("Test", dataPlace.getName());
		}

		if (dataPlace.getNumber() != null) {
			holder.descr.setText(dataPlace.getNumber());
			Log.v("Test", dataPlace.getNumber());
		}

		if (dataPlace.getImgRef()!=0) {
			holder.imgRef.setImageResource(dataPlace.getImgRef());
			Log.v("Test", dataPlace.getImgRef()+"");
			
		}
		return view;
	}
}