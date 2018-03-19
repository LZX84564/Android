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
		//��ȡ�ؼ�
		TextView tv_total_size = (TextView) findViewById(R.id.textView1);
		TextView tv_usable_size = (TextView) findViewById(R.id.textView2);
		//��ȡSD���ܴ�С�Ϳ��ÿռ�
		File file = Environment.getExternalStorageDirectory();
		long totalSpace = file.getTotalSpace();
		long usableSpace = file.getUsableSpace();
		//ת�����ݸ�ʽ
		String formatTotalSpace = Formatter.formatFileSize(this, totalSpace);
		String formatUsableSpace = Formatter.formatFileSize(this,usableSpace);
		//����TextView�ı�����
		tv_total_size.setText("�ܡ���С: "+formatTotalSpace);
		tv_usable_size.setText("���ô�С: "+formatUsableSpace);
	}


}
