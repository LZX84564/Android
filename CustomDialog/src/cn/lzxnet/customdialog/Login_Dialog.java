package cn.lzxnet.customdialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;

public class Login_Dialog {
	@SuppressLint("InflateParams")
	public Dialog dialogLogin(Context context) {
		LayoutInflater inflater =  LayoutInflater.from(context);
		final View textEntryView = inflater.inflate(R.layout.dialog_text_entry,null );
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("输入").setView(textEntryView);
		builder.setPositiveButton("确认", 
				new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				});
		builder.setNegativeButton("取消", 
				new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
		
		
		return builder.create();
		
	}

}
