package be.intec.services.exceptions;


import java.util.Arrays;

public class AnswersException extends RuntimeException {

	public AnswersException( String message ) {

		super( message );
	}


	public AnswersException notFound() {

		return new AnswersException( "Answers not found" );
	}


	public AnswersException alreadyExists() {

		return new AnswersException( "Answers already exists" );
	}


	public AnswersException requiredFields( String... fields ) {

		return new AnswersException( "Required fields: " + Arrays.toString( fields ) );
	}


	public AnswersException nullAnswersException() {

		return new AnswersException( "Answers cannot be null" );
	}

}
