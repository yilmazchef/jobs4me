package be.intec.services.exceptions;


import java.util.Arrays;

public class RecruiterException extends RuntimeException {

	public RecruiterException( String message ) {

		super( message );
	}


	public RecruiterException notFound() {

		return new RecruiterException( "Recruiter not found" );
	}


	public RecruiterException alreadyExists() {

		return new RecruiterException( "Recruiter already exists" );
	}


	public RecruiterException requiredFields( String... fields ) {

		return new RecruiterException( "Required fields: " + Arrays.toString( fields ) );
	}


	public RecruiterException nullRecruiterException() {

		return new RecruiterException( "Recruiter cannot be null" );
	}

}
