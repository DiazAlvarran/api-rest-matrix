package pe.interseguro.backend.rest.matrix.exception;

import lombok.NoArgsConstructor;

/**
 * <h1>InvalidMatrixException!</h1>
 * This class is used to catch the exception of an invalid matrix.
 *
 * @author Jorge Victor Diaz Alvarran
 * @version 1.0
 * @since 2021-12-08
 */
@NoArgsConstructor
public class InvalidMatrixException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidMatrixException(String message) {
		super(message);
	}

}
