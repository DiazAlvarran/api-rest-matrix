package pe.interseguro.backend.rest.matrix.business.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import io.reactivex.Single;
import pe.interseguro.backend.rest.matrix.business.MatrixService;
import pe.interseguro.backend.rest.matrix.exception.InvalidMatrixException;
import pe.interseguro.backend.rest.matrix.model.api.request.MatrixRequest;
import pe.interseguro.backend.rest.matrix.util.Constants;

/**
 * <h1>MatrixServiceImpl!</h1> 
 * This class implements methods to manipulate a square matrix and rotate it 90 degrees.
 *
 * @author Jorge Victor Diaz Alvarran
 * @version 1.0
 * @since 2021-12-08
 */
@Service
public class MatrixServiceImpl implements MatrixService {

	/**
	 * This method integrates the methods for rotating a square matrix.
	 * 
	 * @param body This is a Body Request.
	 * @return Single<Integer[][]> This returns a matrix rotated 90 degrees.
	 */
	@Override
	public Single<Integer[][]> rotateMatrix(MatrixRequest body) {
		return Single.just(body.getMatrix())
				.filter(this::validateMatrix)
				.map(this::convertMatrix)
				.toSingle();
	}

	/**
	 * This method validates if it is a square matrix.
	 * 
	 * @param matrix This is a matrix.
	 * @return Boolean This returns true if the matrix is square.
	 * @exception InvalidMatrixException If the matrix is not square.
	 */
	private Boolean validateMatrix(Integer[][] matrix) throws InvalidMatrixException {
		int size = matrix.length;
		Long errors = Stream.of(matrix)
				.filter(array -> array.length != size)
				.limit(1L)
				.count();
		if (errors.compareTo(Constants.LONG_ZERO) > Constants.INTEGER_ZERO) {
			throw new InvalidMatrixException(Constants.ERROR_MESSAGE_INVALID_MATRIX);
		}
		return true;
	}

	/**
	 * This method rotates an array by 90 degrees.
	 * 
	 * @param matrix This is a matrix.
	 * @return Integer[][] This returns a matrix rotated 90 degrees.
	 */
	private Integer[][] convertMatrix(Integer[][] matrix) {
		int size = matrix.length;
		Integer[][] rotatedMatrix = new Integer[size][size];
		for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
			for (int k = 0; k < size; k++) {
				rotatedMatrix[j][k] = matrix[k][i];
			}
		}
		return rotatedMatrix;
	}

}
