package cn.lzxnet.dicegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button btnStart;
	Button btnExit;
	EditText etNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * 找到控件
		 */
		btnStart = (Button) findViewById(R.id.btn_start);
		btnExit = (Button) findViewById(R.id.btn_exit);
		/*
		 * 设置开始按钮监听器
		 */
		btnStart.setOnClickListener(new OnClickListener() {

			@SuppressLint("InflateParams")
			@Override
			public void onClick(View arg0) {
				// 开始按钮点击事件
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View dialogView = inflater.inflate(R.layout.dialog_start, null);
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				etNum = (EditText) dialogView.findViewById(R.id.et_num);
				builder.setTitle("输入");
				builder.setView(dialogView);
				/*
				 * 设置提交按钮
				 */
				builder.setPositiveButton("提交答案", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
						// 点击事件
						int points = (int) (Math.random()*5)+1;
						int pointsGuess = Integer.parseInt(etNum.getText().toString());
						if (pointsGuess==points) {
							Toast.makeText(MainActivity.this,"您的答案是"+pointsGuess+"点，实际是"+points+"点，您答对了",Toast.LENGTH_SHORT).show();
						}
						else {
							Toast.makeText(MainActivity.this,"您的答案是"+pointsGuess+"点，实际是"+points+"点，您答错了",Toast.LENGTH_SHORT).show();
						}
						/*
						 * Notification显示
						 */
						PendingIntent contentIntent=PendingIntent.getActivity(MainActivity.this,0,new Intent(MainActivity.this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
						Notification.Builder builder1=new Notification.Builder(MainActivity.this);
						builder1.setContentIntent(contentIntent);
						builder1.setSmallIcon(android.R.drawable.star_on);
						builder1.setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.ic_launcher));
						builder1.setTicker("竞猜结果");
						builder1.setWhen(System.currentTimeMillis());
						builder1.setAutoCancel(true);
						builder1.setContentTitle("输入点数为"+pointsGuess);
						builder1.setContentText("实际点数为"+points);
						Notification msg=builder1.build();
						NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
						manager.notify(1,msg);
					}
				});
				builder.show();
				
			}
		});

		/*
		 * 退出按钮设置监听器
		 */
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// 点击事件
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("提示");
				builder.setMessage("是否退出").setIcon(R.drawable.ic_launcher);
				builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
				});
				builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						
					}
				});
				builder.show();
			}
		});
	}

}
