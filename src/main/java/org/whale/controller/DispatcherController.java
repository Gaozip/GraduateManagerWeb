package org.whale.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.whale.pojo.User;

/**
* @ClassName： DispatcherController
* @Description：
* @author： 皮卡尔稽
* @date：2019年1月14日
*/
@Controller
@RequestMapping("/")
public class DispatcherController extends BaseController{
	
	@RequestMapping("/")
	public String goLogin(HttpServletRequest request,HttpServletResponse response){
		return "login";
	}
	
	@RequestMapping("/home")
	public String goIndex(HttpServletRequest request,HttpServletResponse response){
		User user = this.getUser();
		if(user != null){
			return "index";
		}else{
			return "login";
		}
	}

	
	/**
	 * 生成验证码并返回
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/verityCodeExt")
	public void returnCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 使用java图形界面技术绘制一张图片
		int width = 120;
		int height = 36;

		// 1. 创建一张内存图片
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 2.获得绘图对象
		Graphics graphics = bufferedImage.getGraphics();

		// 3、绘制背景颜色
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);

		// 4、绘制图片边框
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 5、输出验证码内容
		graphics.setColor(Color.RED);
		graphics.setFont(new Font("宋体", Font.BOLD, 20));

		// 随机输出4个字符
		Graphics2D graphics2d = (Graphics2D) graphics;
		 String s = "ABCDEFGHGKLMNPQRSTUVWXYZ23456789";
		Random random = new Random();
		//session中要用到
		String msg="";
		int x = 5;
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(32);
			String content = String.valueOf(s.charAt(index));
			msg+=content;
			double theta = random.nextInt(45) * Math.PI / 180;
			//让字体扭曲
            graphics2d.rotate(theta, x, 18);
			graphics2d.drawString(content, x, 18);
			graphics2d.rotate(-theta, x, 18);
			x += 30;
		}
		//_将验证码放入session中
		request.getSession().setAttribute("sessionCode", msg);
		
		// 6、绘制干扰线
		graphics.setColor(Color.GRAY);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);

			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}

		// 释放资源
		graphics.dispose();

		// 图片输出 ImageIO
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}
	
}

