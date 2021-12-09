package pe.interseguro.backend.rest.matrix.model.api.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
* <h1>MatrixRequest!</h1>
* This class defines a request body withn an matrix.
*
* @author  Jorge Victor Diaz Alvarran
* @version 1.0
* @since   2021-12-08
*/
@Data
public class MatrixRequest {

	@NotNull
	private Integer[][] matrix;
	
}
