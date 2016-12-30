package cn.techouse.ims.exception;

public class UserIsExistedException extends BaseException {
	private static final long serialVersionUID = 1L;

	public UserIsExistedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserIsExistedException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserIsExistedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserIsExistedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserIsExistedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
