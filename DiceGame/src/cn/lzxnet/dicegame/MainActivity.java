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
		 * �ҵ��ؼ�
		 */
		btnStart = (Button) findViewById(R.id.btn_start);
		btnExit = (Button) findViewById(R.id.btn_exit);
		/*
		 * ���ÿ�ʼ��ť������
		 */
		btnStart.setOnClickListener(new OnClickListener() {

			@SuppressLint("InflateParams")
			@Override
			public void onClick(View arg0) {
				// ��ʼ��ť����¼�
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View dialogView = inflater.inflate(R.layout.dialog_start, null);
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				etNum = (EditText) dialogView.findViewById(R.id.et_num);
				builder.setTitle("����");
				builder.setView(dialogView);
				/*
				 * �����ύ��ť
				 */
				builder.setPositiveButton("�ύ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
						// ����¼�
						int points = (int) (Math.random()*5)+1;
						int pointsGuess = Integer.parseInt(etNum.getText().toString());
						if (pointsGuess==points) {
							Toast.makeText(MainActivity.this,"���Ĵ���"+pointsGuess+"�㣬ʵ����"+points+"�㣬�������",Toast.LENGTH_SHORT).show();
						}
						else {
							Toast.makeText(MainActivity.this,"���Ĵ���"+pointsGuess+"�㣬ʵ����"+points+"�㣬�������",Toast.LENGTH_SHORT).show();
						}
						/*
						 * Notification��ʾ
						 */
						PendingIntent contentIntent=PendingIntent.getActivity(MainActivity.this,0,new Intent(MainActivity.this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
						Notification.Builder builder1=new Notification.Builder(MainActivity.this);
						builder1.setContentIntent(contentIntent);
						builder1.setSmallIcon(android.R.drawable.star_on);
						builder1.setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.ic_launcher));
						builder1.setTicker("���½��");
						builder1.setWhen(System.currentTimeMillis());
						builder1.setAutoCancel(true);
						builder1.setContentTitle("�������Ϊ"+pointsGuess);
						builder1.setContentText("ʵ�ʵ���Ϊ"+points);
						Notification msg=builder1.build();
						NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
						manager.notify(1,msg);
					}
				});
				builder.show();
				
			}
		});

		/*
		 * �˳���ť���ü�����
		 */
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// ����¼�
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("��ʾ");
				builder.setMessage("�Ƿ��˳�").setIcon(R.drawable.ic_launcher);
				builder.setPositiveButton("��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						MainActivity.this.finish();
					}
				});
				builder.setNegativeButton("��", new DialogInterface.OnClickListener() {
					
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
