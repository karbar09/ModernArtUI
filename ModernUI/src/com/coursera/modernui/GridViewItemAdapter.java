package com.coursera.modernui;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridViewItemAdapter extends BaseAdapter {

	 private Context mContext;
	 private ArrayList<View> arrayList;

	 public GridViewItemAdapter(Context c) {
		 mContext = c;
		 arrayList = new ArrayList<View>(256);
	 }

	 // Total number of things contained within the adapter
	 public int getCount() {
		 return arrayList.size();
	 }

	 public View getItem(int position) {
		 return arrayList.get(position);
	 }
	 
	 public void setItem(int position,View v) {
		 arrayList.set(position, v);
	 }

	 // Require for structure, not really used in my code. Can
	 // be used to get the id of an item in the adapter for 
	 // manual control. 
	 public long getItemId(int position) {
		 return position;
	 }
	 

	 public View getView(int position, View convertView, ViewGroup parent) {
		 
		 View gridItemView = null;
		 LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		 if (convertView == null) {
			 gridItemView = new View(mContext);
			 gridItemView = inflater.inflate(R.layout.grid_item, null);			 
		 } else {
			 gridItemView = convertView;
		 }
		 TextView textView = (TextView) gridItemView.findViewById(R.id.grid_frame);			 
		 
		 if (Math.random()<=.5) {
			 textView.setBackgroundColor(Color.RED);
		 } else {
			 textView.setBackgroundColor(Color.BLUE);
		 }
		 //arrayList.add(position, gridItemView);
		 return gridItemView;
	 }
}
