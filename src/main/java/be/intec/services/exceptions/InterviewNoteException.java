package be.intec.services.exceptions;


import java.util.Arrays;

public class InterviewNoteException extends RuntimeException {

	public InterviewNoteException( String message ) {

		super( message );
	}


	public InterviewNoteException notFound() {

		return new InterviewNoteException( "InterviewNote not found" );
	}


	public InterviewNoteException alreadyExists() {

		return new InterviewNoteException( "InterviewNote already exists" );
	}


	public InterviewNoteException requiredFields( String... fields ) {

		return new InterviewNoteException( "Required fields: " + Arrays.toString( fields ) );
	}


	public InterviewNoteException nullInterviewNoteException() {

		return new InterviewNoteException( "InterviewNote cannot be null" );
	}

}
