package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicationException extends RuntimeException {

	public ApplicationException( String message ) {

		super( message );
	}


	public ApplicationException notFound() {

		return new ApplicationException( "Application not found" );
	}


	public ApplicationException alreadyExists() {

		return new ApplicationException( "Application already exists" );
	}


	public ApplicationException requiredFields( String... fields ) {

		return new ApplicationException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicationException nullApplicationException() {

		return new ApplicationException( "Application cannot be null" );
	}

}
