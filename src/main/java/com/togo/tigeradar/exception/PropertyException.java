package com.togo.tigeradar.exception;

public class PropertyException extends RuntimeException {

	/**long serialVersionUID: TODO属性声明*/
	private static final long serialVersionUID = -4871501539217189538L;

	public PropertyException() {
		super();
	}
	
	public PropertyException(String msg) {
		super(msg);
	}
}
