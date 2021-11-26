package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicationTestException extends RuntimeException {

	public ApplicationTestException( String message ) {

		super( message );
	}


	public ApplicationTestException notFound() {

		return new ApplicationTestException( "ApplicationTest not found" );
	}


	public ApplicationTestException alreadyExists() {

		return new ApplicationTestException( "ApplicationTest already exists" );
	}


	public ApplicationTestException requiredFields( String... fields ) {

		return new ApplicationTestException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicationTestException nullApplicationTestException() {

		return new ApplicationTestException( "ApplicationTest cannot be null" );
	}

}
