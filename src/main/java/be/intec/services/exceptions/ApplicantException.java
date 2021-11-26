package be.intec.services.exceptions;


import java.util.Arrays;

public class ApplicantException extends RuntimeException {

	public ApplicantException( String message ) {

		super( message );
	}


	public ApplicantException notFound() {

		return new ApplicantException( "Applicant not found" );
	}


	public ApplicantException alreadyExists() {

		return new ApplicantException( "Applicant already exists" );
	}


	public ApplicantException requiredFields( String... fields ) {

		return new ApplicantException( "Required fields: " + Arrays.toString( fields ) );
	}


	public ApplicantException nullApplicantException() {

		return new ApplicantException( "Applicant cannot be null" );
	}

}
