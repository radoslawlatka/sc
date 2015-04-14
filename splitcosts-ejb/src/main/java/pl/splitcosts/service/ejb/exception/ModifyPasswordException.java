package pl.splitcosts.service.ejb.exception;

public class ModifyPasswordException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public ModifyPasswordException() {
	}

	public ModifyPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModifyPasswordException(String message) {
		super(message);
	}

	public ModifyPasswordException(Throwable cause) {
		super(cause);
	}

}
