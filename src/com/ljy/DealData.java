package com.ljy;

import com.ljy.dao.DataBase_Dao;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.ljy.common.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

public class DealData {
	public void dealData() {
		DataBase_Dao a = new DataBase_Dao();
		List<AfterDataInstance> res = null;
		res = a.getDao();
		StringBuffer sb = new StringBuffer(64);
		AfterDataInstance data = null;
		int size = res.size();
		if (size > 0) {
			System.err.println("数据库没有数据");
			return;
		}
		for (int i = 0; i < size; i++) {
			data = res.get(i);
			data.setOrigin(deal(data.getOrigin(), sb));
		}
	}

	public String deal(String a, StringBuffer sb) {
		sb.setLength(0);
		sb.append(a);
		if (sb.indexOf("atg") == -1 || (sb.indexOf("") == -1 && sb.indexOf("") == -1 && sb.indexOf("") == -1)) {
			return "";
		}

		return "";
		// TODO 对数据进行处理
	}

	/**
	 * 将String拆分 每三个是一个 元素
	 * 
	 * @param str
	 * @param n
	 * @return
	 */
	public String[] StringSplitArr(String str, int n) {
		String[] res = new String[str.length() / n];
		for (int i = 0; i < res.length; i++) {
			res[i] = str.substring(i, i + n);
		}
		return res;
	}

	/**
	 * 工具方法 str里面有没有s
	 * 
	 * @param str
	 * @param s
	 * @return
	 */
	public boolean contain(String[] str, String s) {
		if (str.length == 0 || s == null || s.equals("")) {
			return false;
		}
		for (int i = 0; i < str.length; i++) {
			if (s.equals(str[i])) {
				return true;
			}
		}
		return false;
	}

	public int containInt(String[] str, String s) {
		if (str.length == 0 || s == null || s.equals("")) {
			return -1;
		}
		for (int i = 0; i < str.length; i++) {
			if (s.equals(str[i])) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		return -1;
	}

	/**
	 * 获取有效基因片段
	 * 
	 * @param s
	 * @param start
	 * @param end
	 * @param sb
	 * @return
	 */
	public String getResStr(String[] s, int start, int end, StringBuffer sb) {
		if (start > end || end > s.length || start < 0 || end < 0) {
			return "";
		}
		sb.setLength(0);
		for (int i = start; i < end; i++) {
			sb.append(s[i]);
		}
		return sb.toString();

	}

	/**
	 * 从n开始查找起始子的位置并返回
	 * 
	 * @param n
	 * @param str
	 * @return
	 */
	public int initiator(int n, String[] str) {
		if (str.length == 0) {
			return -1;
		}
		for (int i = n; i < str.length; i++) {
			if (str[i].equals("atg")) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 从n开始查找终止子的位置 并返回
	 * 
	 * @param n
	 * @param str
	 * @return
	 */
	public int terminator(int n, String[] str) {
		if (str.length == 0) {
			return -1;
		}
		for (int i = n; i < str.length; i++) {
			if (str[i].equals("tga") || str[i].equals("tag") || str[i].equals("taa")) {
				return i;
			}
		}
		return -1;
	}

	public void deal(String[] str) {
		if (contain(str, "ATG") && (contain(str, "TGA") || contain(str, "TAG") || contain(str, "TAA"))) {
			deal1(str);
		}
	}

	public void deal1(String[] str) {

	}

	public void get(String[] str, String s) {

	}

	/**
	 * 实现方法：
	 * 
	 */
	/**
	 * 将orgin数组拆分成有效数据
	 * 
	 * @return
	 */
	public List<String> getDataRes(String[] s) {
		int start = 0;
		int end = 0;
		List<String> res = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		while (end < s.length) {
			start = initiator(start, s);
			if(start ==-1){
				break;
			}
			end = terminator(start, s);
			res.add(getResStr(s, start, end, sb));
			start = end;
			
		}
		return res;
	}

	@Test
	public void Test() throws IOException {
		String fileName = "D:/ab.txt";
		File file = new File(fileName); // 找到目标文件
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // 建立数据通道
		int length = 0;
		int i = 0;
		byte[] buf = new byte[204800];// 建立缓存数组，缓存数组的大小一般都是1024的整数倍，理论上越大效率越好
		StringBuffer s = new StringBuffer();
		while ((length = fileInputStream.read(buf)) != -1) {
			s.append(new String(buf, 0, length));

		}
		fileInputStream.close();
		String a = s.toString();
		StringUtil st = new StringUtil();
		DataInstance di = new DataInstance("");
		a = di.dealOrign(a);
		a = st.translation(a);
		System.out.println(a.length());
		StringBuffer sb = new StringBuffer(64);
		deal(a, sb);
		String[] b = StringSplitArr(a, 3);
//		containInt(b, "atg");
//		containInt(b, "taa");
//		containInt(b, "tag");
//		containInt(b, "gta");
		List<String> res = getDataRes(b);
		System.out.println(res.size());
		for(int j=0;j<res.size();j++){
			System.out.print(res.get(j));
			System.out.println();
		}

	}
}
