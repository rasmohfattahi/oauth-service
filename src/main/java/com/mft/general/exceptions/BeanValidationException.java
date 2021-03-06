package com.mft.general.exceptions;

import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * To be thrown when there is a validation error. Validation is done by JSR and
 * user-defined annotations. In this project, AOP will take the responsibility
 * to do so, and if there is any validation error, this exception will be thrown
 * and controllerAdvice will handle it.
 *
 * @author mohsenfattahi81@gmail.com
 */
public class BeanValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BindingResult bindingResult;
	private List<BindingResult> bindingResults;

	public BeanValidationException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}

	public BeanValidationException(List<BindingResult> bindingResults) {
		super();
		this.bindingResults = bindingResults;
	}

	public BeanValidationException() {
		super();
	}

	public BeanValidationException(String message) {
		super(message);
	}

	public BeanValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public List<BindingResult> getBindingResults() {
		return bindingResults;
	}

}
