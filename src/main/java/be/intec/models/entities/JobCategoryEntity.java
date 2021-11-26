package be.intec.models.entities;


import java.io.Serializable;
import java.util.Objects;

public class JobCategoryEntity implements Serializable, Comparable< JobCategoryEntity > {

	private Integer id;
	private String code;
	private String name;
	private String description;


	public JobCategoryEntity() {

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


	public JobCategoryEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public JobCategoryEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public JobCategoryEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public JobCategoryEntity withoutParsedId( String id ) {

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


	public JobCategoryEntity withCode( String code ) {

		this.setCode( code );
		return this;
	}


	public JobCategoryEntity withParsedCode( String code ) {

		this.parseAndSetCode( code );
		return this;
	}


	public JobCategoryEntity withoutCode( String code ) {

		this.setCode( null );
		return this;
	}


	public JobCategoryEntity withoutParsedCode( String code ) {

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


	public JobCategoryEntity withName( String name ) {

		this.setName( name );
		return this;
	}


	public JobCategoryEntity withParsedName( String name ) {

		this.parseAndSetName( name );
		return this;
	}


	public JobCategoryEntity withoutName( String name ) {

		this.setName( null );
		return this;
	}


	public JobCategoryEntity withoutParsedName( String name ) {

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


	public JobCategoryEntity withDescription( String description ) {

		this.setDescription( description );
		return this;
	}


	public JobCategoryEntity withParsedDescription( String description ) {

		this.parseAndSetDescription( description );
		return this;
	}


	public JobCategoryEntity withoutDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public JobCategoryEntity withoutParsedDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	@Override
	public int compareTo( JobCategoryEntity otherJobCategory ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof JobCategoryEntity ) ) {
        return false;
      }
		JobCategoryEntity otherJobCategory = ( JobCategoryEntity ) obj;
		return
				this.getId().equals( otherJobCategory.getId() )
						&& this.getCode().equals( otherJobCategory.getCode() )
						&& this.getName().equals( otherJobCategory.getName() )
						&& this.getDescription().equals( otherJobCategory.getDescription() )
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
