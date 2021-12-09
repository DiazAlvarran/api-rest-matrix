package pe.interseguro.backend.rest.matrix.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.interseguro.backend.rest.matrix.util.Constants;

/**
* <h1>ResponseExceptionHandler!</h1>
* This class catches exceptions and returns a custom response.
*
* @author  Jorge Victor Diaz Alvarran
* @version 1.0
* @since   2021-12-08
*/
@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * This method catches an exception of type InvalidMatrixException.
	 * 
	 * @param exception This is a exception.
	 * @return ResponseEntity<Map<String, Object>> This returns a custom response.
	 */
	@ExceptionHandler(InvalidMatrixException.class)
	protected ResponseEntity<Map<String, Object>> invalidMatrixException(InvalidMatrixException exception) {
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		errorResponse.put(Constants.ERROR_HTTP_STATUS, HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.put(Constants.ERROR_DESCRIPTION, exception.getMessage());
		errorResponse.put(Constants.ERROR_TYPE, Constants.ERROR_FUNCIONAL);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}

}
