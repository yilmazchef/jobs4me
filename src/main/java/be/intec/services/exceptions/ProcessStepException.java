package be.intec.services.exceptions;


import java.util.Arrays;

public class ProcessStepException extends RuntimeException {

	public ProcessStepException( String message ) {

		super( message );
	}


	public ProcessStepException notFound() {

		return new ProcessStepException( "ProcessStep not found" );
	}


	public ProcessStepException alreadyExists() {

		return new ProcessStepException( "ProcessStep already exists" );
	}


	public ProcessStepException requiredFields( String... fields ) {

		return new ProcessStepException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ProcessStepException nullProcessStepException() {

		return new ProcessStepException( "ProcessStep cannot be null" );
	}

}
