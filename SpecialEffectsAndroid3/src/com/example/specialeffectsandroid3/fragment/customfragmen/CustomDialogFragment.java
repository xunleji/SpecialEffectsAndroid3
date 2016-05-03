package com.example.specialeffectsandroid3.fragment.customfragmen;

import com.example.specialeffectsandroid3.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomDialogFragment extends DialogFragment {

	private Button btn;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog alert = new Dialog(getActivity(), R.style.dialog);  
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.dialogfragment_main, null);
		btn = (Button) view.findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				dismiss();
			}
		});
		alert.setContentView(view);
		return alert;
	}

}
