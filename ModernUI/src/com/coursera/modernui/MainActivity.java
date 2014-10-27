package com.coursera.modernui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private static final String url = "http://www.moma.org";
	private DialogFragment mDialog;
	private GridView gridView;
	private SeekBar mSeekBar;
	private static final int ALERTTAG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new GridViewItemAdapter(this));
       // mSeekBar = (SeekBar) findViewById(R.id.main_view_seek_bar);
        /*mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
        	@Override
        	public void onProgressChanged(SeekBar seekBar, int progress,
        			boolean fromUser) {
        		/*
        		int length = gridView.getAdapter().getCount();
        		for (int i = 0;i<length;i++) {
        			View gridItem = (View) gridView.getAdapter().getItem(i);
        			
        			if (Math.random() > .5) {
        		        gridItem.setBackgroundColor(Color.BLACK);
        			} else {
        				gridItem.setBackgroundColor(Color.BLUE);
        			}
        			
        		}	
        	}

        	@Override
        	public void onStartTrackingTouch(SeekBar seekBar) {
        		// TODO Auto-generated method stub
        		
        	}

        	@Override
        	public void onStopTrackingTouch(SeekBar seekBar) {
        		// TODO Auto-generated method stub
        		
        	}
        });*/
        
    }

	// Show desired Dialog
	void showDialogFragment(int dialogID) {

		switch (dialogID) {

		// Show AlertDialog
		case ALERTTAG:

			// Create a new AlertDialogFragment
			mDialog = AlertDialogFragment.newInstance();

			// Show AlertDialogFragment
			mDialog.show(getFragmentManager(), "Alert");

			break;

		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        ActionBar mActionBar = this.getActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(0xff00DDED));
        mActionBar.setTitle(R.string.actionbar_title);
        mActionBar.setDisplayShowTitleEnabled(true);
        mActionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            this.showDialogFragment(ALERTTAG);
        	return true;
            
        }
        return super.onOptionsItemSelected(item);
    }
    
 // Class that creates the AlertDialog
 	public static class AlertDialogFragment extends DialogFragment {

 		public static AlertDialogFragment newInstance() {
 			return new AlertDialogFragment();
 		}

 		// Build AlertDialog using AlertDialog.Builder
 		@Override
 		public Dialog onCreateDialog(Bundle savedInstanceState) {
 			return new AlertDialog.Builder(getActivity())
 					.setMessage(R.string.learn_more)
 					
 					// User cannot dismiss dialog by hitting back button
 					.setCancelable(false)

 					.setNegativeButton("Not Now",
 							new DialogInterface.OnClickListener() {
 								public void onClick(DialogInterface dialog,
 										int id) {
 									Toast.makeText(getActivity(), "A man walks into a bar ... oh no there's not enough time", Toast.LENGTH_SHORT).show();
 								}
 							})
 							
 					.setPositiveButton("Visit MOMA",
 							new DialogInterface.OnClickListener() {
 								public void onClick(
 										final DialogInterface dialog, int id) {
 									Intent momaWebPageIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
 									startActivity(momaWebPageIntent);
 								}
 							}).create();
 		}
 	}

	

}
