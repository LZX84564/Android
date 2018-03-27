package cn.lzxnet.bmicalculater;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText height;
	EditText weight;
	Button button;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * 找到关心的控件
		 */
		height = (EditText) findViewById(R.id.et_height);
		weight = (EditText) findViewById(R.id.et_weight);
		button = (Button) findViewById(R.id.btn_calculate);
		text = (TextView) findViewById(R.id.tv_bmi);

		/*
		 * Button监听器设置
		 */
		button.setOnClickListener(new calculate());
	}

	class calculate implements View.OnClickListener {

		//按钮点击事件
		@Override
		public void onClick(View v) {
			/*
			 * 捕捉异常：输入为空，数值转换异常
			 * 用吐司弹出提示
			 */
			try {
				double dheight = Double.parseDouble(height.getText().toString());
				double dweight = Double.parseDouble(weight.getText().toString());
				/*
				 * 自定义Calculate类，调用BmiCalculate方法
				 * 处理并计算数据，保留两位小数以字符串形式返回
				 */
				text.setText(Calculate.BmiCalculate(dweight, dheight));
			} catch (NumberFormatException e) {
				Toast.makeText(MainActivity.this, "请输入正确的身高体重",Toast.LENGTH_SHORT).show();
			}
			
		}

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
