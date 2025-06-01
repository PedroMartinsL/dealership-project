package com.dealership.project.presentation.exceptions;

public class AssociationInUseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public AssociationInUseException(String msg) {
		super(msg);
	}
}
