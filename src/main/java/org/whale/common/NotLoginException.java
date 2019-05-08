package org.whale.common;
/**
* @ClassName： NotLoginException
* @Description：
* @author： 皮卡尔稽
* @date：2019年4月30日
*/
public class NotLoginException extends RuntimeException{

	private static final long serialVersionUID = -8221113401276422371L;

	public NotLoginException(String message){
		super(message);
	}
}

