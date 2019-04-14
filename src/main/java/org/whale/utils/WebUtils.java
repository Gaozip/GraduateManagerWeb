package org.whale.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @ClassName： WebUtils @Description： @author： 皮卡尔稽 @date：2019年2月10日
 */
public class WebUtils {

	public static void printSuccess(HttpServletRequest request, HttpServletResponse response) {
		printSuccess(request, response, "操作成功", null);
	}

	public static void printSuccess(HttpServletRequest request, HttpServletResponse response, String msg) {
		printSuccess(request, response, msg, null);
	}

	public static void printSuccess(HttpServletRequest request, HttpServletResponse response, Object obj) {
		printSuccess(request, response, "操作成功", obj);
	}

	public static void printSuccess(HttpServletRequest request, HttpServletResponse response, String msg, Object obj) {
		doPrint(request, response, buildRs(true, msg, obj));
	}

	public static void printFail(HttpServletRequest request, HttpServletResponse response, String msg) {
		printFail(request, response, msg, null);
	}

	public static void printFail(HttpServletRequest request, HttpServletResponse response, Object obj) {
		printFail(request, response, "操作失败", obj);
	}

	public static void printFail(HttpServletRequest request, HttpServletResponse response, String msg, Object obj) {
		doPrint(request, response, buildRs(false, msg, obj));
	}

	private static String buildRs(boolean success, String msg, Object datas) {
		return new Result(success, msg, datas).toString();
	}

	public static void print(HttpServletRequest request, HttpServletResponse response, Object obj) {
		doPrint(request, response, JSON.toJSONString(obj));
	}

	public static void doPrint(HttpServletRequest request, HttpServletResponse response, String str) {
		setDisableCacheHeader(response);
		response.setHeader("Content-type", "application/json");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static void setDisableCacheHeader(HttpServletResponse response) {
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}

	public static Integer getInt(HttpServletRequest request, String key, Integer defVal) {
		String obj = request.getParameter(key);
		if ((obj == null) || ("".equals(obj.trim()))) {
			return defVal;
		}
		try {
			return Integer.valueOf(Integer.parseInt(obj));
		} catch (NumberFormatException e) {
		}
		return defVal;
	}

	public static Long getLong(HttpServletRequest request, String key, Long defVal) {
		String obj = request.getParameter(key);
		if ((obj == null) || ("".equals(obj.trim()))) {
			return defVal;
		}
		try {
			return Long.valueOf(Long.parseLong(obj));
		} catch (NumberFormatException e) {
		}
		return defVal;
	}
}

class Result {
	private boolean rs = true;

	private String msg;
	private Object datas;

	public Result() {
	}

	public Result(boolean rs, String msg) {
		this.rs = rs;
		this.msg = msg;
	}

	public Result(boolean rs, String msg, Object datas) {
		this.rs = rs;
		this.msg = msg;
		this.datas = datas;
	}

	public boolean isRs() {
		return this.rs;
	}

	public void setRs(boolean rs) {
		this.rs = rs;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getDatas() {
		return this.datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public String toString() {
		StringBuilder strb = new StringBuilder("{\"rs\":");
		strb.append(this.rs ? "true" : "false").append(",\"msg\":\"").append(this.msg == null ? "" : this.msg)
				.append("\",\"datas\":").append(this.datas == null ? "{}"
						: JSON.toJSONString(this.datas, SerializerFeature.DisableCircularReferenceDetect))
				.append("}");
		return strb.toString();
	}
}
