package be.intec.models.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class InterviewEntity implements Serializable, Comparable< InterviewEntity > {

	private Integer id;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer applicationId;


	public InterviewEntity() {

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


	public InterviewEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public InterviewEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public InterviewEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public InterviewEntity withoutParsedId( String id ) {

		this.setId( null );
		return this;
	}


	public Timestamp getStartTime() {

		return startTime;
	}


	public void setStartTime( Timestamp startTime ) {

		this.startTime = startTime;
	}


	public void parseAndSetStartTime( String startTime ) {

		this.startTime = java.sql.Timestamp.valueOf( startTime );
	}


	public InterviewEntity withStartTime( Timestamp startTime ) {

		this.setStartTime( startTime );
		return this;
	}


	public InterviewEntity withParsedStartTime( String startTime ) {

		this.parseAndSetStartTime( startTime );
		return this;
	}


	public InterviewEntity withoutStartTime( Timestamp startTime ) {

		this.setStartTime( null );
		return this;
	}


	public InterviewEntity withoutParsedStartTime( String startTime ) {

		this.setStartTime( null );
		return this;
	}


	public Timestamp getEndTime() {

		return endTime;
	}


	public void setEndTime( Timestamp endTime ) {

		this.endTime = endTime;
	}


	public void parseAndSetEndTime( String endTime ) {

		this.endTime = java.sql.Timestamp.valueOf( endTime );
	}


	public InterviewEntity withEndTime( Timestamp endTime ) {

		this.setEndTime( endTime );
		return this;
	}


	public InterviewEntity withParsedEndTime( String endTime ) {

		this.parseAndSetEndTime( endTime );
		return this;
	}


	public InterviewEntity withoutEndTime( Timestamp endTime ) {

		this.setEndTime( null );
		return this;
	}


	public InterviewEntity withoutParsedEndTime( String endTime ) {

		this.setEndTime( null );
		return this;
	}


	public Integer getApplicationId() {

		return applicationId;
	}


	public void setApplicationId( Integer applicationId ) {

		this.applicationId = applicationId;
	}


	public void parseAndSetApplicationId( String applicationId ) {

		this.applicationId = Integer.parseInt( applicationId );
	}


	public InterviewEntity withApplicationId( Integer applicationId ) {

		this.setApplicationId( applicationId );
		return this;
	}


	public InterviewEntity withParsedApplicationId( String applicationId ) {

		this.parseAndSetApplicationId( applicationId );
		return this;
	}


	public InterviewEntity withoutApplicationId( Integer applicationId ) {

		this.setApplicationId( null );
		return this;
	}


	public InterviewEntity withoutParsedApplicationId( String applicationId ) {

		this.setApplicationId( null );
		return this;
	}


	@Override
	public int compareTo( InterviewEntity otherInterview ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof InterviewEntity ) ) {
        return false;
      }
		InterviewEntity otherInterview = ( InterviewEntity ) obj;
		return
				this.getId().equals( otherInterview.getId() )
						&& this.getStartTime().equals( otherInterview.getStartTime() )
						&& this.getEndTime().equals( otherInterview.getEndTime() )
						&& this.getApplicationId().equals( otherInterview.getApplicationId() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getStartTime()
				, this.getEndTime()
				, this.getApplicationId()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"startTime:" + this.getStartTime() + ", " +
				"endTime:" + this.getEndTime() + ", " +
				"applicationId:" + this.getApplicationId() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getStartTime() == null &&
				this.getEndTime() == null &&
				this.getApplicationId() == null );
	}

}
