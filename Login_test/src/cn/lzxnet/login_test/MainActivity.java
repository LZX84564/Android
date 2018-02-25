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
		 * �ҵ���Ҫ�Ŀؼ���findViewById���� Android�еĿؼ����Ǽ̳���View�����Կ�ǿ������ת������ΪAndroid�ؼ�����
		 * ��Ҫ����Ϊ��Ա�������ں�������������ʹ��
		 */
		et_name = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		cb_ischeck = (CheckBox) findViewById(R.id.cb_ischeck);
		Map<String, String> maps = UserInfoUtils.readInfo(MainActivity.this);
		if (maps != null) {
			// ��name��pwd ȡ����
			String name = maps.get("name");
			String pwd = maps.get("pwd");
			// ��ʾ��EditText�ؼ���
			et_name.setText(name);
			et_password.setText(pwd);
		}

	}

	/*
	 * ��ť����¼�
	 */
	public void login(View v) {
		/*
		 * ��ȡ�û�������
		 */
		String name = et_name.getText().toString().trim();
		String pwd = et_password.getText().toString().trim();
		/*
		 * �ж�name��pwd�Ƿ�Ϊ�� Android��API�ṩһ��������TextUtils isEmpty�����п�
		 */
		if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(MainActivity.this, "�û��������벻��Ϊ��", Toast.LENGTH_LONG).show();

		} else {
			// ���е�¼���߼�
			System.out.println("��¼");
			if (cb_ischeck.isChecked()) {
				// �������ݴ洢����
				boolean result = UserInfoUtils.saveInfo(MainActivity.this,name, pwd);
				if (result) {
					Toast.makeText(MainActivity.this, "����ɹ�", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(MainActivity.this, "����ʧ��", Toast.LENGTH_SHORT).show();
				}
			} else {
				Toast.makeText(MainActivity.this, "�û�������δ����", Toast.LENGTH_SHORT).show();
			}
		}

	}

}