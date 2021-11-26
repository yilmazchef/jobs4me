package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicationStatusException extends RuntimeException {

	public ApplicationStatusException( String message ) {

		super( message );
	}


	public ApplicationStatusException notFound() {

		return new ApplicationStatusException( "ApplicationStatus not found" );
	}


	public ApplicationStatusException alreadyExists() {

		return new ApplicationStatusException( "ApplicationStatus already exists" );
	}


	public ApplicationStatusException requiredFields( String... fields ) {

		return new ApplicationStatusException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicationStatusException nullApplicationStatusException() {

		return new ApplicationStatusException( "ApplicationStatus cannot be null" );
	}

}
