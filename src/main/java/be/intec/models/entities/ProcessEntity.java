package be.intec.models.entities;


import java.io.Serializable;
import java.util.Objects;

public class ProcessEntity implements Serializable, Comparable< ProcessEntity > {

	private Integer id;
	private String code;
	private String description;
	private Integer recruiterId;


	public ProcessEntity() {

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


	public ProcessEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public ProcessEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public ProcessEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public ProcessEntity withoutParsedId( String id ) {

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


	public ProcessEntity withCode( String code ) {

		this.setCode( code );
		return this;
	}


	public ProcessEntity withParsedCode( String code ) {

		this.parseAndSetCode( code );
		return this;
	}


	public ProcessEntity withoutCode( String code ) {

		this.setCode( null );
		return this;
	}


	public ProcessEntity withoutParsedCode( String code ) {

		this.setCode( null );
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


	public ProcessEntity withDescription( String description ) {

		this.setDescription( description );
		return this;
	}


	public ProcessEntity withParsedDescription( String description ) {

		this.parseAndSetDescription( description );
		return this;
	}


	public ProcessEntity withoutDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public ProcessEntity withoutParsedDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public Integer getRecruiterId() {

		return recruiterId;
	}


	public void setRecruiterId( Integer recruiterId ) {

		this.recruiterId = recruiterId;
	}


	public void parseAndSetRecruiterId( String recruiterId ) {

		this.recruiterId = Integer.parseInt( recruiterId );
	}


	public ProcessEntity withRecruiterId( Integer recruiterId ) {

		this.setRecruiterId( recruiterId );
		return this;
	}


	public ProcessEntity withParsedRecruiterId( String recruiterId ) {

		this.parseAndSetRecruiterId( recruiterId );
		return this;
	}


	public ProcessEntity withoutRecruiterId( Integer recruiterId ) {

		this.setRecruiterId( null );
		return this;
	}


	public ProcessEntity withoutParsedRecruiterId( String recruiterId ) {

		this.setRecruiterId( null );
		return this;
	}


	@Override
	public int compareTo( ProcessEntity otherProcess ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof ProcessEntity ) ) {
        return false;
      }
		ProcessEntity otherProcess = ( ProcessEntity ) obj;
		return
				this.getId().equals( otherProcess.getId() )
						&& this.getCode().equals( otherProcess.getCode() )
						&& this.getDescription().equals( otherProcess.getDescription() )
						&& this.getRecruiterId().equals( otherProcess.getRecruiterId() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getCode()
				, this.getDescription()
				, this.getRecruiterId()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"code:" + this.getCode() + ", " +
				"description:" + this.getDescription() + ", " +
				"recruiterId:" + this.getRecruiterId() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getCode() == null &&
				this.getDescription() == null &&
				this.getRecruiterId() == null );
	}

}
