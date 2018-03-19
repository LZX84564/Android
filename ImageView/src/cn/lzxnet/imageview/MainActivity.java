package cn.lzxnet.imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btn_click;
	EditText et_name;
	TextView tv_name;
	ImageView iv_photo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_click = (Button) findViewById(R.id.btn_click);
		et_name = (EditText) findViewById(R.id.et_name);
		tv_name = (TextView) findViewById(R.id.tv_name);
		iv_photo = (ImageView) findViewById(R.id.iv_photo);
		btn_click.setOnClickListener(new getname());
		

	
	}
	class getname implements View.OnClickListener
	{
		public void onClick(View v) 
		{
			// TODO Auto-generated method stub
			String name = et_name.getText().toString().trim();
			tv_name.setText("这是"+name+"的照片");
			Bitmap pic = BitmapFactory.decodeResource(getResources(), R.drawable.img_photo);
			//查询bitmap的宽和高
			int w = pic.getWidth();
			int h = pic.getHeight();
			//缩放图片
			Bitmap scaled = Bitmap.createScaledBitmap(pic, 200, 200*h/w, false);
			iv_photo.setImageBitmap(scaled);
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
