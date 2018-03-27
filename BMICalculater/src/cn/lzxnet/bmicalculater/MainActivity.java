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
		 * �ҵ����ĵĿؼ�
		 */
		height = (EditText) findViewById(R.id.et_height);
		weight = (EditText) findViewById(R.id.et_weight);
		button = (Button) findViewById(R.id.btn_calculate);
		text = (TextView) findViewById(R.id.tv_bmi);

		/*
		 * Button����������
		 */
		button.setOnClickListener(new calculate());
	}

	class calculate implements View.OnClickListener {

		//��ť����¼�
		@Override
		public void onClick(View v) {
			/*
			 * ��׽�쳣������Ϊ�գ���ֵת���쳣
			 * ����˾������ʾ
			 */
			try {
				double dheight = Double.parseDouble(height.getText().toString());
				double dweight = Double.parseDouble(weight.getText().toString());
				/*
				 * �Զ���Calculate�࣬����BmiCalculate����
				 * �����������ݣ�������λС�����ַ�����ʽ����
				 */
				text.setText(Calculate.BmiCalculate(dweight, dheight));
			} catch (NumberFormatException e) {
				Toast.makeText(MainActivity.this, "��������ȷ���������",Toast.LENGTH_SHORT).show();
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
