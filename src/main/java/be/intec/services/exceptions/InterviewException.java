package be.intec.services.exceptions;


import java.util.Arrays;

public class InterviewException extends RuntimeException {

	public InterviewException( String message ) {

		super( message );
	}


	public InterviewException notFound() {

		return new InterviewException( "Interview not found" );
	}


	public InterviewException alreadyExists() {

		return new InterviewException( "Interview already exists" );
	}


	public InterviewException requiredFields( String... fields ) {

		return new InterviewException( "Required fields: " + Arrays.toString( fields ) );
	}


	public InterviewException nullInterviewException() {

		return new InterviewException( "Interview cannot be null" );
	}

}
