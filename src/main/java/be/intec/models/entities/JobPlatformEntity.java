package be.intec.models.entities;


import java.io.Serializable;
import java.util.Objects;

public class JobPlatformEntity implements Serializable, Comparable< JobPlatformEntity > {

	private Integer id;
	private String code;
	private String name;
	private String description;


	public JobPlatformEntity() {

	}


	public Integer getId() {

		return id;
	}


	public void setId( Integer id ) {

		this.id = id;
	}


	public void parseAndSetId( String id ) {

		this.id = Integer.parseInt( id );
	}


	public JobPlatformEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public JobPlatformEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public JobPlatformEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public JobPlatformEntity withoutParsedId( String id ) {

		this.setId( null );
		return this;
	}


	public String getCode() {

		return code;
	}


	public void setCode( String code ) {

		this.code = code;
	}


	public void parseAndSetCode( String code ) {

		this.code = code;
	}


	public JobPlatformEntity withCode( String code ) {

		this.setCode( code );
		return this;
	}


	public JobPlatformEntity withParsedCode( String code ) {

		this.parseAndSetCode( code );
		return this;
	}


	public JobPlatformEntity withoutCode( String code ) {

		this.setCode( null );
		return this;
	}


	public JobPlatformEntity withoutParsedCode( String code ) {

		this.setCode( null );
		return this;
	}


	public String getName() {

		return name;
	}


	public void setName( String name ) {

		this.name = name;
	}


	public void parseAndSetName( String name ) {

		this.name = name;
	}


	public JobPlatformEntity withName( String name ) {

		this.setName( name );
		return this;
	}


	public JobPlatformEntity withParsedName( String name ) {

		this.parseAndSetName( name );
		return this;
	}


	public JobPlatformEntity withoutName( String name ) {

		this.setName( null );
		return this;
	}


	public JobPlatformEntity withoutParsedName( String name ) {

		this.setName( null );
		return this;
	}


	public String getDescription() {

		return description;
	}


	public void setDescription( String description ) {

		this.description = description;
	}


	public void parseAndSetDescription( String description ) {

		this.description = description;
	}


	public JobPlatformEntity withDescription( String description ) {

		this.setDescription( description );
		return this;
	}


	public JobPlatformEntity withParsedDescription( String description ) {

		this.parseAndSetDescription( description );
		return this;
	}


	public JobPlatformEntity withoutDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public JobPlatformEntity withoutParsedDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	@Override
	public int compareTo( JobPlatformEntity otherJobPlatform ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof JobPlatformEntity ) ) {
        return false;
      }
		JobPlatformEntity otherJobPlatform = ( JobPlatformEntity ) obj;
		return
				this.getId().equals( otherJobPlatform.getId() )
						&& this.getCode().equals( otherJobPlatform.getCode() )
						&& this.getName().equals( otherJobPlatform.getName() )
						&& this.getDescription().equals( otherJobPlatform.getDescription() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getCode()
				, this.getName()
				, this.getDescription()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"code:" + this.getCode() + ", " +
				"name:" + this.getName() + ", " +
				"description:" + this.getDescription() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getCode() == null &&
				this.getName() == null &&
				this.getDescription() == null );
	}

}
