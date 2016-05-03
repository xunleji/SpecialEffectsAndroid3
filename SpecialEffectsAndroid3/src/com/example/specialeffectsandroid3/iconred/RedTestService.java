package com.example.specialeffectsandroid3.iconred;

import com.example.specialeffectsandroid3.Diary;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class RedTestService extends IntentService {

	public RedTestService() {
		super("testservice");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Diary.print("state==" + intent.getExtras().getInt("state"));
		if (intent.getExtras().getInt("state") == 1) {
			Intent intents = new Intent(
					"com.example.specialeffectsandroid3.iconred");
			sendBroadcast(intents);
		} else {
			Diary.print("ddddddd");
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Diary.print("TestService=" + i + "");
				if (i > 8) {
					Diary.print("TestService=setBadgeCount");
					BadgeUtil.setBadgeCount(this, 3);
				}
			}

		}
	}

}
