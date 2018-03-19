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
		 * 找到关心的控件，最好在类变量中声明 DatePicker TimePicker TextView
		 */
		dp = (DatePicker) findViewById(R.id.dp);
		tp = (TimePicker) findViewById(R.id.tp);
		tv = (TextView) findViewById(R.id.tv);

		/*
		 * 获取日历
		 */
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);

		/*
		 * 获取当前时间
		 */
		Time t = new Time();
		t.setToNow();

		/*
		 * 初始化DatePicker 设置监听器
		 */
		dp.init(year, month, date, new DatePicker.OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				updateTextView();
			}
		});
		
		/*
		 * 初始化TimePicker 设置监听器
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
	 * TextView显示函数
	 */
	private void updateTextView() {
		int year =dp.getYear();
		int month = dp.getMonth();
		int date = dp.getDayOfMonth();
		int hour = tp.getCurrentHour();
		int minute = tp.getCurrentMinute();
		tv.setText(year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分");
		
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
