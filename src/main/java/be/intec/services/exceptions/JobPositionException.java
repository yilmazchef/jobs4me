package be.intec.services.exceptions;


import java.util.Arrays;

public class JobPositionException extends RuntimeException {

	public JobPositionException( String message ) {

		super( message );
	}


	public JobPositionException notFound() {

		return new JobPositionException( "JobPosition not found" );
	}


	public JobPositionException alreadyExists() {

		return new JobPositionException( "JobPosition already exists" );
	}


	public JobPositionException requiredFields( String... fields ) {

		return new JobPositionException( "Required fields: " + Arrays.toString( fields ) );
	}


	public JobPositionException nullJobPositionException() {

		return new JobPositionException( "JobPosition cannot be null" );
	}

}
