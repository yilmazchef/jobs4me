package be.intec.services.exceptions;


import java.util.Arrays;

public class JobException extends RuntimeException {

	public JobException( String message ) {

		super( message );
	}


	public JobException notFound() {

		return new JobException( "Job not found" );
	}


	public JobException alreadyExists() {

		return new JobException( "Job already exists" );
	}


	public JobException requiredFields( String... fields ) {

		return new JobException( "Required fields: " + Arrays.toString( fields ) );
	}


	public JobException nullJobException() {

		return new JobException( "Job cannot be null" );
	}

}
