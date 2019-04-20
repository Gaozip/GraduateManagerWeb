package org.whale.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
  public static String getProperty(String propertiesFileName, String key) {
    Properties props = new Properties();
    try {
      props.load(PropertiesUtil.class.getResourceAsStream("resource/" + 
        propertiesFileName));
    } catch (IOException e) {
      System.out.println("ERROR:-->找不到文件：" + 
        PropertiesUtil.class.getResourceAsStream(new StringBuilder("resource/")
        .append(propertiesFileName).toString()));
      e.printStackTrace();
    }
    return (String)props.get(key);
  }

  public static void setProperty(String propertiesFileName, String key, String value) {
    Properties props = new Properties();
    OutputStream os = null;
    try {
      String classRootPath = PropertiesUtil.class.getResource("/")
        .toString();
      if ("Windows".indexOf(System.getProperty("os.name")) != -1) {
        classRootPath = classRootPath.replace("file:/", "");
      } else {
        classRootPath = classRootPath.replace("file:", "");
      }
      props.load(PropertiesUtil.class.getResourceAsStream("/" + 
        propertiesFileName));
      os = new FileOutputStream(classRootPath + propertiesFileName);
      props.put(key, value);
      props.store(os, "");
    } catch (Exception e) {
      e.printStackTrace();

      if (os != null) {
		try {
		  os.close();
		} catch (IOException e1) {
		  e1.printStackTrace();
		}
      }
    } finally {
      if (os != null)
        try {
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
  }

  public static List<Map.Entry<Object, Object>> prop2List(String fileAllPath) {
    List<Map.Entry<Object, Object>> reList = null;
    try {
      Properties props = new Properties();
      props.load(PropertiesUtil.class.getResourceAsStream(fileAllPath));
      Iterator<Map.Entry<Object, Object>> it = props.entrySet().iterator();
      reList = new ArrayList<Map.Entry<Object, Object>>();
      while (it.hasNext()) {
        Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>)it.next();
        reList.add(entry);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return reList;
  }
}