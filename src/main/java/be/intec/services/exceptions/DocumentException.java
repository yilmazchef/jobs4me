package be.intec.services.exceptions;


import java.util.Arrays;

public class DocumentException extends RuntimeException {

	public DocumentException( String message ) {

		super( message );
	}


	public DocumentException notFound() {

		return new DocumentException( "Document not found" );
	}


	public DocumentException alreadyExists() {

		return new DocumentException( "Document already exists" );
	}


	public DocumentException requiredFields( String... fields ) {

		return new DocumentException( "Required fields: " + Arrays.toString( fields ) );
	}


	public DocumentException nullDocumentException() {

		return new DocumentException( "Document cannot be null" );
	}

}
