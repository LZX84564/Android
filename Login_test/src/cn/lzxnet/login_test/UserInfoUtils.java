package cn.lzxnet.login_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;

public class UserInfoUtils {

	/*
	 * �����û��������ҵ�񷽷�
	 */
	public static boolean saveInfo(Context context, String username, String pwd) {

		try {
			//��ȡ�ļ�����Ŀ¼
			String path = context.getFilesDir().getPath();
			String result = username + "##" + pwd;
			/*
			 * ����file��ָ�����ݴ洢λ�ã� data/data/Ӧ���嵥�ļ��İ���/�ļ���
			 */
//			File file = new File("data/data/cn.lzxnet.login_test/info.txt");
			File file = new File(path,"info.txt");
			// ����һ���ļ��������
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(result.getBytes());
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	// ��ȡ�û�����Ϣ
	public static Map<String, String> readInfo(Context context) {
		try {
			String path = context.getFilesDir().getPath();
			// ����map
			Map<String, String> maps = new HashMap<String, String>();
			File file = new File(path,"info.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));

			String content = bufr.readLine();
			// �и��ַ�����Ŷmap������
			String[] splits = content.split("##");
			String name = splits[0];
			String pwd = splits[1];
			maps.put("name", name);
			maps.put("pwd", pwd);
			fis.close();
			return maps;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}