package be.intec.services.exceptions;


import java.util.Arrays;

public class StepException extends RuntimeException {

	public StepException( String message ) {

		super( message );
	}


	public StepException notFound() {

		return new StepException( "Step not found" );
	}


	public StepException alreadyExists() {

		return new StepException( "Step already exists" );
	}


	public StepException requiredFields( String... fields ) {

		return new StepException( "Required fields: " + Arrays.toString( fields ) );
	}


	public StepException nullStepException() {

		return new StepException( "Step cannot be null" );
	}

}
