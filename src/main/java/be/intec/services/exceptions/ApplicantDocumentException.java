package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicantDocumentException extends RuntimeException {

	public ApplicantDocumentException( String message ) {

		super( message );
	}


	public ApplicantDocumentException notFound() {

		return new ApplicantDocumentException( "ApplicantDocument not found" );
	}


	public ApplicantDocumentException alreadyExists() {

		return new ApplicantDocumentException( "ApplicantDocument already exists" );
	}


	public ApplicantDocumentException requiredFields( String... fields ) {

		return new ApplicantDocumentException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicantDocumentException nullApplicantDocumentException() {

		return new ApplicantDocumentException( "ApplicantDocument cannot be null" );
	}

}
