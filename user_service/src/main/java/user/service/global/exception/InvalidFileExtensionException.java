package user.service.global.exception;

public class InvalidFileExtensionException extends RuntimeException{
	public InvalidFileExtensionException(String message) {
		super(message);
	}
	
	public InvalidFileExtensionException() {
		
	}
}