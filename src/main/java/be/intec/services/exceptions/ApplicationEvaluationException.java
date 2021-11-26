package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicationEvaluationException extends RuntimeException {

	public ApplicationEvaluationException( String message ) {

		super( message );
	}


	public ApplicationEvaluationException notFound() {

		return new ApplicationEvaluationException( "ApplicationEvaluation not found" );
	}


	public ApplicationEvaluationException alreadyExists() {

		return new ApplicationEvaluationException( "ApplicationEvaluation already exists" );
	}


	public ApplicationEvaluationException requiredFields( String... fields ) {

		return new ApplicationEvaluationException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicationEvaluationException nullApplicationEvaluationException() {

		return new ApplicationEvaluationException( "ApplicationEvaluation cannot be null" );
	}

}
