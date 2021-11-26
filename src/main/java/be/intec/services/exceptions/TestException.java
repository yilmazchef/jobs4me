package be.intec.services.exceptions;


import java.util.Arrays;

public class TestException extends RuntimeException {

	public TestException( String message ) {

		super( message );
	}


	public TestException notFound() {

		return new TestException( "Test not found" );
	}


	public TestException alreadyExists() {

		return new TestException( "Test already exists" );
	}


	public TestException requiredFields( String... fields ) {

		return new TestException( "Required fields: " + Arrays.toString( fields ) );
	}


	public TestException nullTestException() {

		return new TestException( "Test cannot be null" );
	}

}
