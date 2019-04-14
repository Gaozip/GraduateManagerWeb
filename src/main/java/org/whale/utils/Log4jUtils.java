package org.whale.utils;

import sun.reflect.Reflection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @ClassName： Log4jUtils 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年2月3日
 */
@SuppressWarnings("restriction")
public class Log4jUtils {

	public static Logger getLogger() {
		Logger logger = null;
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		if (null == logger) {
			// Java8 废弃了Reflection.getCallerClass()
			logger = Logger.getLogger("[" + bf.format(date) + "  " + Reflection.getCallerClass().getName() + "]");
			logger.debug("[" + Reflection.getCallerClass().getName() + "]");
		}
		return logger;
	}

	public static void main(String[] args) {
		Log4jUtils.getLogger().debug("debug---->>>>>");
		Log4jUtils.getLogger().info("info---->>>>>");
		Log4jUtils.getLogger().error("error---->>>>>");
	}

}