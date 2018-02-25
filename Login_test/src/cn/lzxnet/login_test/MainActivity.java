package cn.lzxnet.login_test;

import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_password;
	private CheckBox cb_ischeck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * 找到需要的控件：findViewById方法 Android中的控件都是继承于View，所以可强制类型转化类型为Android控件类型
		 * 需要声明为成员变量用于后面其它方法中使用
		 */
		et_name = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		cb_ischeck = (CheckBox) findViewById(R.id.cb_ischeck);
		Map<String, String> maps = UserInfoUtils.readInfo(MainActivity.this);
		if (maps != null) {
			// 把name和pwd 取出来
			String name = maps.get("name");
			String pwd = maps.get("pwd");
			// 显示到EditText控件上
			et_name.setText(name);
			et_password.setText(pwd);
		}

	}

	/*
	 * 按钮点击事件
	 */
	public void login(View v) {
		/*
		 * 获取用户名密码
		 */
		String name = et_name.getText().toString().trim();
		String pwd = et_password.getText().toString().trim();
		/*
		 * 判断name和pwd是否为空 Android的API提供一个工具类TextUtils isEmpty方法判空
		 */
		if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(MainActivity.this, "用户名和密码不能为空", Toast.LENGTH_LONG).show();

		} else {
			// 进行登录的逻辑
			System.out.println("登录");
			if (cb_ischeck.isChecked()) {
				// 调用数据存储方法
				boolean result = UserInfoUtils.saveInfo(MainActivity.this,name, pwd);
				if (result) {
					Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(MainActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(MainActivity.this, "用户名密码未保存", Toast.LENGTH_SHORT).show();
			}
		}

	}

}