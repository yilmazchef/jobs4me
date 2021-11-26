package be.intec.services.exceptions;


import java.util.Arrays;

public class JobPlatformException extends RuntimeException {

	public JobPlatformException( String message ) {

		super( message );
	}


	public JobPlatformException notFound() {

		return new JobPlatformException( "JobPlatform not found" );
	}


	public JobPlatformException alreadyExists() {

		return new JobPlatformException( "JobPlatform already exists" );
	}


	public JobPlatformException requiredFields( String... fields ) {

		return new JobPlatformException( "Required fields: " + Arrays.toString( fields ) );
	}


	public JobPlatformException nullJobPlatformException() {

		return new JobPlatformException( "JobPlatform cannot be null" );
	}

}
