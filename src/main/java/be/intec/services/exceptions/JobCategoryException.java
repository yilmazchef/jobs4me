package be.intec.services.exceptions;


import java.util.Arrays;

public class JobCategoryException extends RuntimeException {

	public JobCategoryException( String message ) {

		super( message );
	}


	public JobCategoryException notFound() {

		return new JobCategoryException( "JobCategory not found" );
	}


	public JobCategoryException alreadyExists() {

		return new JobCategoryException( "JobCategory already exists" );
	}


	public JobCategoryException requiredFields( String... fields ) {

		return new JobCategoryException( "Required fields: " + Arrays.toString( fields ) );
	}


	public JobCategoryException nullJobCategoryException() {

		return new JobCategoryException( "JobCategory cannot be null" );
	}

}
