package org.whale.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.whale.common.AuthLogin;
import org.whale.constant.Constant;
import org.whale.pojo.MailInfo;
import org.whale.pojo.User;
import org.whale.service.UserService;
import org.whale.utils.Log4jUtils;
import org.whale.utils.MD5Utils;
import org.whale.utils.MailUtils;
import org.whale.utils.StringUtils;
import org.whale.utils.UUIDUtils;
import org.whale.utils.WebUtils;

/**
* @ClassName： UserController
* @Description：
* @author： 皮卡尔稽
* @date：2019年2月3日
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Resource
	private MailUtils mailUtils;
	
	/**
	 * 判断是否被注册
	 * @param request
	 * @param response
	 * @param userName:用户名
	 * @param email:邮箱
	 */
	@RequestMapping("/IsRegister")
	public void IsRegister(HttpServletRequest request,HttpServletResponse response,String userName,String email){
		
		try {
			int num = userService.IsRegister(userName,email);
			Map<String, Integer> map = new HashMap<>();
			map.put("num", num);
			WebUtils.printSuccess(request, response,map);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "数据查询失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param user
	 * @throws Exception 
	 */
	@RequestMapping("/doSave")
	public void doRegister(HttpServletRequest request,HttpServletResponse response,User user){
		
		try {
			//用户名，密码，邮箱非空校验
			if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())||StringUtils.isBlank(user.getEmail())||StringUtils.isBlank(user.getEmail())){
				WebUtils.printFail(request, response, "请将表单填写完整！");
			}
			
			user.setPassword(MD5Utils.md5(user.getPassword()));
			user.setState((short) Constant.USER_IS_NOT_ACTIVE);
			user.setCode(UUIDUtils.getCode());

			//发送邮箱strMail,strText
			String mail = user.getEmail();
			String title = "【毕业生就业管理系统】Email地址验证";
			String content = "<br/>尊敬的用户：<br/><br/>"+
			"您好：<br/><br/>"+
			"感谢您注册毕业生就业管理系统，请点击以下链接完成注册："+
			"<a href='http://localhost/managersystem/user/doActive?userName="+user.getUsername()+"&code="+user.getCode()+"'>http://localhost/managersystem/user/doActive?userName="+user.getUsername()+"&code="+user.getCode()+"</a><br/><br/>"+
			"毕业生就业管理系统团队祝您使用愉快！<br/><br/>"+
			"系统发信,请勿回复<br/><br/>"+
			"如果您有什么疑问可以联系管理员，Email: 13115912059@163.com";
		
			MailInfo info = new MailInfo();
			info.setToAddress(mail);
	        info.setSubject(title);
	        info.setContent(content);
	        
			mailUtils.sendHtmlMail(info);
			userService.addUser(user);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "邮件发送失败!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @param userName:用户名
	 * @param password：密码
	 * @param verityCode：验证码
	 * @param rmbUser:是否记住用户名
	 */
	@RequestMapping("/doLogin")
	public void doLogin(HttpServletRequest request,HttpServletResponse response,String userName,String password,String verityCode){
		
		String sessionCode = (String) request.getSession().getAttribute("sessionCode");
		
		//用户名及密码非空校验
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            WebUtils.printFail(request, response, "请输入用户名或密码！");
            return;
        }
        //验证码非空校验
        if(StringUtils.isBlank(verityCode)){
        	WebUtils.printFail(request, response, "请输入验证码！");
        	return;
        }
        //验证码校验
		if(!verityCode.equalsIgnoreCase(sessionCode)){
			WebUtils.printFail(request, response, "验证码输入错误！");
			return;
		}
		
		User user = new User();
		user.setUsername(userName);
		user.setPassword(MD5Utils.md5(password));
		User user1 = userService.doLogin(user);
		
		//用户名密码校验
		if(user1 == null){
			WebUtils.printFail(request, response, "用户名或密码错误，或该用户不存在！");
			return;
		}
		
		//用户账号激活校验
		if(user1.getState() != Constant.USER_IS_ACTIVE){
			WebUtils.printFail(request, response, "该账号还未激活，请到指定邮箱进行激活！");
			return;
		}
		//登录成功
		request.getSession().setAttribute("user", user1);
		WebUtils.printSuccess(request, response);
	}
	
	/**
	 * 用户账号激活
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/doActive")
	public ModelAndView active(HttpServletRequest request,HttpServletResponse response,String userName,String code) throws IOException{
		Log4jUtils.getLogger().info("doActive!");
		
		//获取账户对应的激活码
		String activeCode = userService.getCode(userName);
		
		//激活失败校验
		if(!code.equals(activeCode)){
			return new ModelAndView("notActive","msg","账号激活失败！");
		}
		//激活成功，修改激活状态为1
		userService.updateState(userName);
		return new ModelAndView("active","msg","账号激活成功！");
	}
	
	/**
	 * 主界面header获取用户名
	 * @param request
	 * @param response
	 */
	@AuthLogin
	@RequestMapping("/getUserName")
	public void getUserName(HttpServletRequest request,HttpServletResponse response){
		
		try {
			User user = (User) request.getSession().getAttribute("user");
			
			String path = this.userService.getUserHeadPath(user.getPkUserId());
			Map<String, Object> map = new HashMap<>();
			map.put("userName", user.getUsername());
			map.put("headPath", path);
			WebUtils.printSuccess(request, response, map);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "获取数据失败！");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 */
	@AuthLogin
	@RequestMapping("/loginOut")
	public String loginOut(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute("user");
		return "login";
	}
	
	/**
	 * 修改用户名
	 * @param request
	 * @param response
	 * @param userName
	 */
	@AuthLogin
	@RequestMapping("/changeUserName")
	public void changeUserName(HttpServletRequest request,HttpServletResponse response,@RequestParam("userName") String userName){

		if(userName == null){
			return;
		}
		Long pkUserId = ((User)request.getSession().getAttribute("user")).getPkUserId();
		userService.changeUserName(userName,pkUserId);

		((User)request.getSession().getAttribute("user")).setUsername(userName);
		
		WebUtils.printSuccess(request, response);
	}
	
	/**
	 * 修改用户密码
	 * @param request
	 * @param response
	 * @param password
	 * @param newPassword:新密码
	 * @param rePassword:确认密码
	 */
	@AuthLogin
	@RequestMapping("/changePassword")
	public void changePassword(HttpServletRequest request,HttpServletResponse response,String password,String newPassword,String rePassword ){
		if(StringUtils.isBlank(password) || StringUtils.isBlank(newPassword) || StringUtils.isBlank(rePassword)){
			return;
		}
		User user = ((User)request.getSession().getAttribute("user"));
		String oldPassword = user.getPassword();
		
		if(!MD5Utils.md5(password).equals(oldPassword)){
			WebUtils.printFail(request, response, "旧密码输入错误！");
		}
		if(!newPassword.equals(rePassword)){
			WebUtils.printFail(request, response, "两次密码不一致!");
		}
		userService.changePassword(MD5Utils.md5(newPassword),user.getPkUserId());
		request.getSession().removeAttribute("user");
		WebUtils.printSuccess(request, response);
	}
	
	@AuthLogin
	@RequestMapping("/getUserRole")
	public void getUserRole(HttpServletRequest request,HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		WebUtils.printSuccess(request, response, user.getRole());
	}
	
	/**
	 * 上传用户头像
	 * @param request
	 * @param response
	 * @param file
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@AuthLogin
	@RequestMapping(value="/uploadUserHeadImage",method=RequestMethod.POST)
	public void uploadUserHeadImage(HttpServletRequest request,HttpServletResponse response,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

		//图片存放路径
		String path = "/UserImages/";
		
		//如果已有头像，则先删除已有头像
		String head = userService.haveUserHeadPath(this.getUserId(request));
		if(head != null){
			new File(path+head.replace("/upload/", "")).delete();
		}
		
		if(!file.isEmpty()) {
        	//设置图片名称
			String headPath = "/upload/";
        	String fileName =UUIDUtils.getCode()+".jpg";
        	
        	//将头像路径存入数据库
			Long pkUserId = this.getUserId(request);
			
			userService.uploadUserHeadImage(pkUserId,headPath+fileName);
        	
			file.transferTo(new File(path+fileName));
			
        }else{
        	WebUtils.printFail(request, response, "请选择上传图片");
        }
	}
	
	@AuthLogin
	@RequestMapping("/doRegisterAdminUser")
	public void doRegisterAdminUser(HttpServletRequest request,HttpServletResponse response,User user){
		
		//用户名，密码非空校验
		if(StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
			WebUtils.printFail(request, response, "请将表单填写完整！");
		}
		
		try {
			user.setPassword(MD5Utils.md5(user.getPassword()));
			this.userService.doRegisterAdminUser(user);
			WebUtils.printSuccess(request, response);
		} catch (Exception e) {
			WebUtils.printFail(request, response, "用户注册失败！");
			e.printStackTrace();
		}
	}
}

