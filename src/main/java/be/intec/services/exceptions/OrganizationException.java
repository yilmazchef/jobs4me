package be.intec.services.exceptions;


import java.util.Arrays;

public class OrganizationException extends RuntimeException {

	public OrganizationException( String message ) {

		super( message );
	}


	public OrganizationException notFound() {

		return new OrganizationException( "Organization not found" );
	}


	public OrganizationException alreadyExists() {

		return new OrganizationException( "Organization already exists" );
	}


	public OrganizationException requiredFields( String... fields ) {

		return new OrganizationException( "Required fields: " + Arrays.toString( fields ) );
	}


	public OrganizationException nullOrganizationException() {

		return new OrganizationException( "Organization cannot be null" );
	}

}
