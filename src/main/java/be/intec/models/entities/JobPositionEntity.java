package be.intec.models.entities;


import java.io.Serializable;
import java.util.Objects;

public class JobPositionEntity implements Serializable, Comparable< JobPositionEntity > {

	private Integer id;
	private String code;
	private String name;
	private String description;


	public JobPositionEntity() {

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


	public JobPositionEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public JobPositionEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public JobPositionEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public JobPositionEntity withoutParsedId( String id ) {

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


	public JobPositionEntity withCode( String code ) {

		this.setCode( code );
		return this;
	}


	public JobPositionEntity withParsedCode( String code ) {

		this.parseAndSetCode( code );
		return this;
	}


	public JobPositionEntity withoutCode( String code ) {

		this.setCode( null );
		return this;
	}


	public JobPositionEntity withoutParsedCode( String code ) {

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


	public JobPositionEntity withName( String name ) {

		this.setName( name );
		return this;
	}


	public JobPositionEntity withParsedName( String name ) {

		this.parseAndSetName( name );
		return this;
	}


	public JobPositionEntity withoutName( String name ) {

		this.setName( null );
		return this;
	}


	public JobPositionEntity withoutParsedName( String name ) {

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


	public JobPositionEntity withDescription( String description ) {

		this.setDescription( description );
		return this;
	}


	public JobPositionEntity withParsedDescription( String description ) {

		this.parseAndSetDescription( description );
		return this;
	}


	public JobPositionEntity withoutDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public JobPositionEntity withoutParsedDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	@Override
	public int compareTo( JobPositionEntity otherJobPosition ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof JobPositionEntity ) ) {
        return false;
      }
		JobPositionEntity otherJobPosition = ( JobPositionEntity ) obj;
		return
				this.getId().equals( otherJobPosition.getId() )
						&& this.getCode().equals( otherJobPosition.getCode() )
						&& this.getName().equals( otherJobPosition.getName() )
						&& this.getDescription().equals( otherJobPosition.getDescription() )
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
