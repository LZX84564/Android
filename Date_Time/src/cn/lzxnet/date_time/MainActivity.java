package cn.lzxnet.date_time;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	DatePicker dp;
	TimePicker tp;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * �ҵ����ĵĿؼ������������������� DatePicker TimePicker TextView
		 */
		dp = (DatePicker) findViewById(R.id.dp);
		tp = (TimePicker) findViewById(R.id.tp);
		tv = (TextView) findViewById(R.id.tv);

		/*
		 * ��ȡ����
		 */
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);

		/*
		 * ��ȡ��ǰʱ��
		 */
		Time t = new Time();
		t.setToNow();

		/*
		 * ��ʼ��DatePicker ���ü�����
		 */
		dp.init(year, month, date, new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				updateTextView();
			}
		});
		
		/*
		 * ��ʼ��TimePicker ���ü�����
		 */
		tp.setCurrentHour(t.hour);
		tp.setCurrentMinute(t.minute);
		tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			
			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				updateTextView();
			}
		});
		
		
		
	}

	/*
	 * TextView��ʾ����
	 */
	private void updateTextView() {
		int year =dp.getYear();
		int month = dp.getMonth();
		int date = dp.getDayOfMonth();
		int hour = tp.getCurrentHour();
		int minute = tp.getCurrentMinute();
		tv.setText(year+"��"+month+"��"+date+"��"+hour+"ʱ"+minute+"��");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
