package pe.interseguro.backend.rest.matrix.business;

import io.reactivex.Single;
import pe.interseguro.backend.rest.matrix.model.api.request.MatrixRequest;

/**
 * <h1>MatrixService!</h1> 
 * This interface defines the methods for handling an matrix.
 *
 * @author Jorge Victor Diaz Alvarran
 * @version 1.0
 * @since 2021-12-08
 */
public interface MatrixService {

	Single<Integer[][]> rotateMatrix(MatrixRequest body);

}
