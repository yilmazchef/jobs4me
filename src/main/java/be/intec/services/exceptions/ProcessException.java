package be.intec.services.exceptions;


import java.util.Arrays;

public class ProcessException extends RuntimeException {

	public ProcessException( String message ) {

		super( message );
	}


	public ProcessException notFound() {

		return new ProcessException( "Process not found" );
	}


	public ProcessException alreadyExists() {

		return new ProcessException( "Process already exists" );
	}


	public ProcessException requiredFields( String... fields ) {

		return new ProcessException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ProcessException nullProcessException() {

		return new ProcessException( "Process cannot be null" );
	}

}
