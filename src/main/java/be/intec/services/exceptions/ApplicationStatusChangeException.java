package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicationStatusChangeException extends RuntimeException {

	public ApplicationStatusChangeException( String message ) {

		super( message );
	}


	public ApplicationStatusChangeException notFound() {

		return new ApplicationStatusChangeException( "ApplicationStatusChange not found" );
	}


	public ApplicationStatusChangeException alreadyExists() {

		return new ApplicationStatusChangeException( "ApplicationStatusChange already exists" );
	}


	public ApplicationStatusChangeException requiredFields( String... fields ) {

		return new ApplicationStatusChangeException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicationStatusChangeException nullApplicationStatusChangeException() {

		return new ApplicationStatusChangeException( "ApplicationStatusChange cannot be null" );
	}

}
