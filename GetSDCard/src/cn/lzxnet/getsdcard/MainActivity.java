package cn.lzxnet.getsdcard;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.Formatter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取控件
		TextView tv_total_size = (TextView) findViewById(R.id.textView1);
		TextView tv_usable_size = (TextView) findViewById(R.id.textView2);
		//获取SD卡总大小和可用空间
		File file = Environment.getExternalStorageDirectory();
		long totalSpace = file.getTotalSpace();
		long usableSpace = file.getUsableSpace();
		//转换数据格式
		String formatTotalSpace = Formatter.formatFileSize(this, totalSpace);
		String formatUsableSpace = Formatter.formatFileSize(this,usableSpace);
		//设置TextView文本内容
		tv_total_size.setText("总·大小: "+formatTotalSpace);
		tv_usable_size.setText("可用大小: "+formatUsableSpace);
	}


}
