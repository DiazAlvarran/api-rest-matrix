package pe.interseguro.backend.rest.matrix.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import pe.interseguro.backend.rest.matrix.business.MatrixService;
import pe.interseguro.backend.rest.matrix.model.api.request.MatrixRequest;

/**
 * <h1>MatrixController!</h1> 
 * This interface defines the end points of the rest service.
 *
 * @author Jorge Victor Diaz Alvarran
 * @version 1.0
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/matrix")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class MatrixController {

	@Autowired
	private MatrixService matrixService;

	/**
	 * This method defines the end point to rotate a matrix.
	 * 
	 * @param body This is a Body Request.
	 * @return Single<ResponseEntity<Integer[][]>> This returns a matrix rotated 90 degrees.
	 */
	@PostMapping(value = "/rotate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ResponseEntity<Integer[][]>> rotateMatrix(@Valid @RequestBody MatrixRequest body) {
		return matrixService.rotateMatrix(body)
				.map(ResponseEntity::ok);
	}

}
