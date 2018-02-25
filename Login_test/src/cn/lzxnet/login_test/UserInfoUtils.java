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
	 * 保存用户名密码的业务方法
	 */
	public static boolean saveInfo(Context context, String username, String pwd) {

		try {
			//获取文件保存目录
			String path = context.getFilesDir().getPath();
			String result = username + "##" + pwd;
			/*
			 * 创建file类指定数据存储位置： data/data/应用清单文件的包名/文件名
			 */
//			File file = new File("data/data/cn.lzxnet.login_test/info.txt");
			File file = new File(path,"info.txt");
			// 创建一个文件的输出流
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

	// 读取用户的信息
	public static Map<String, String> readInfo(Context context) {
		try {
			String path = context.getFilesDir().getPath();
			// 定义map
			Map<String, String> maps = new HashMap<String, String>();
			File file = new File(path,"info.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bufr = new BufferedReader(new InputStreamReader(fis));

			String content = bufr.readLine();
			// 切割字符串发哦map集合中
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