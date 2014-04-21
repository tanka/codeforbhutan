package com.tanka.fastdial;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.tanka.constants.Constants;
import com.tanka.fastdial.adapter.ListplacesAdapter;
import com.tanka.fastdial.pojo.ContactData;

public class ContactList extends ListActivity implements Constants {

	ListplacesAdapter adapter;
	ArrayList<ContactData> contact;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_list);
		contact = new ArrayList<ContactData>();

		contact.add(new ContactData(BT, BT_NUM, R.drawable.telephone));
		contact.add(new ContactData(POLICE, POLICE_NUM, R.drawable.police));
		contact.add(new ContactData(AMBULANCE, AMBULANCE_NUM, R.drawable.ambulance));
		contact.add(new ContactData(FIRE, FIRE_NUM, R.drawable.fire));
		contact.add(new ContactData(TRAFFIC, TRAFFIC_NUM, R.drawable.traffic));

		adapter = new ListplacesAdapter(this, R.layout.row_list_contacts, contact);

		setListAdapter(adapter);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Toast.makeText(getApplicationContext(),
				 " Calling "+ contact.get(position).getName() +" for HELP", Toast.LENGTH_LONG)
				.show();
		
		String num=contact.get(position).getNumber(); 
        String number = "tel:" + num.trim();
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number)); 
        startActivity(callIntent);
		
//		Intent intent = new Intent(TELEPHONY_SERVICE,)
		/*
		 * Intent intent = new Intent(ListPlaces.this, Details.class);
		 * intent.putExtra(PLACE, places.get(position).getName());
		 * startActivity(intent);
		 */
		}
}
