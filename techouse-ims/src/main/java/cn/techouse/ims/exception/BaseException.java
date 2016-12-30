package cn.techouse.ims.exception;
/**
 * 定义程序中抛出异常的基类
 * @author 许宝众
 *
 */
public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
