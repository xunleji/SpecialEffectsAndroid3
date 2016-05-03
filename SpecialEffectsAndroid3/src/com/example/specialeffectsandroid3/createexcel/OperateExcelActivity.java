package com.example.specialeffectsandroid3.createexcel;

import java.io.File;

import com.example.specialeffectsandroid3.R;
import com.example.specialeffectsandroid3.Until;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 在SD卡中创建excel表
 * 
 * @author xujuan
 * 
 */
public class OperateExcelActivity extends Activity {

	private String path = "/android3/";
	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createexcel_main);

		tv = (TextView) findViewById(R.id.textView1);
		write();
	}

	private void write() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				writeExcel();
				final String str1 = readExcel(1, 1);
				final String str2 = readExcel(2, 2);
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						tv.setText(str1 + str2);
					}
				});
			}
		}).start();
	}

	private String readExcel(int i, int j) {
		// TODO Auto-generated method stub
		String content = "";
		File file = new File(Until.getSDPath() + path);
		if (!file.exists()) {
			return "";
		}
		try {
			Workbook book = Workbook.getWorkbook(new File(Until.getSDPath()
					+ path + "gz.xls"));
			Sheet sheet = book.getSheet(0);
			// 得到x行y列所在单元格的内容
			String cellStr = sheet.getRow(i)[j].getContents();
			content = cellStr;
		} catch (Exception e) {
			content = "";
			e.printStackTrace();
		}
		return content;
	}

	private void writeExcel() {
		// TODO Auto-generated method stub
		File file = new File(Until.getSDPath() + path);
		if (!file.exists()) {
			file.mkdirs();
		}
		WritableWorkbook wwb = null;
		try {
			// 创建一个可写入的工作薄(Workbook)对象
			wwb = Workbook.createWorkbook(new File(Until.getSDPath() + path
					+ "gz.xls"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (wwb != null) {
			// 第一个参数是工作表的名称，第二个是工作表在工作薄中的位置
			WritableSheet ws = wwb.createSheet("sheet1", 0);
			Label lbl1 = new Label(1, 1, "louiskoo");
			Label lbl2 = new Label(2, 2, "的操作");
			try {
				ws.addCell(lbl1);
				ws.addCell(lbl2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				// 从内存中写入文件中
				wwb.write();
				wwb.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}