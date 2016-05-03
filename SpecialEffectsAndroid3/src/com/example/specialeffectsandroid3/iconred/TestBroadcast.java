package com.example.specialeffectsandroid3.iconred;

import com.example.specialeffectsandroid3.Diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Diary.print("TestBroadcast");
		if (intent.getAction().equals("com.example.specialeffectsandroid3.iconred")) {
			Intent intents = new Intent(context, RedTestService.class);
			intents.putExtra("state", 2);
			context.startService(intents);
		}
	}

}
