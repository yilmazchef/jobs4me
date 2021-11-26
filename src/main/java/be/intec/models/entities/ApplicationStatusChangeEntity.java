package be.intec.models.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ApplicationStatusChangeEntity implements Serializable, Comparable< ApplicationStatusChangeEntity > {

	private Integer id;
	private Timestamp dateChanged;
	private Integer applicationStatusId;
	private Integer applicationId;


	public ApplicationStatusChangeEntity() {

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


	public ApplicationStatusChangeEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public ApplicationStatusChangeEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public ApplicationStatusChangeEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public ApplicationStatusChangeEntity withoutParsedId( String id ) {

		this.setId( null );
		return this;
	}


	public Timestamp getDateChanged() {

		return dateChanged;
	}


	public void setDateChanged( Timestamp dateChanged ) {

		this.dateChanged = dateChanged;
	}


	public void parseAndSetDateChanged( String dateChanged ) {

		this.dateChanged = java.sql.Timestamp.valueOf( dateChanged );
	}


	public ApplicationStatusChangeEntity withDateChanged( Timestamp dateChanged ) {

		this.setDateChanged( dateChanged );
		return this;
	}


	public ApplicationStatusChangeEntity withParsedDateChanged( String dateChanged ) {

		this.parseAndSetDateChanged( dateChanged );
		return this;
	}


	public ApplicationStatusChangeEntity withoutDateChanged( Timestamp dateChanged ) {

		this.setDateChanged( null );
		return this;
	}


	public ApplicationStatusChangeEntity withoutParsedDateChanged( String dateChanged ) {

		this.setDateChanged( null );
		return this;
	}


	public Integer getApplicationStatusId() {

		return applicationStatusId;
	}


	public void setApplicationStatusId( Integer applicationStatusId ) {

		this.applicationStatusId = applicationStatusId;
	}


	public void parseAndSetApplicationStatusId( String applicationStatusId ) {

		this.applicationStatusId = Integer.parseInt( applicationStatusId );
	}


	public ApplicationStatusChangeEntity withApplicationStatusId( Integer applicationStatusId ) {

		this.setApplicationStatusId( applicationStatusId );
		return this;
	}


	public ApplicationStatusChangeEntity withParsedApplicationStatusId( String applicationStatusId ) {

		this.parseAndSetApplicationStatusId( applicationStatusId );
		return this;
	}


	public ApplicationStatusChangeEntity withoutApplicationStatusId( Integer applicationStatusId ) {

		this.setApplicationStatusId( null );
		return this;
	}


	public ApplicationStatusChangeEntity withoutParsedApplicationStatusId( String applicationStatusId ) {

		this.setApplicationStatusId( null );
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


	public ApplicationStatusChangeEntity withApplicationId( Integer applicationId ) {

		this.setApplicationId( applicationId );
		return this;
	}


	public ApplicationStatusChangeEntity withParsedApplicationId( String applicationId ) {

		this.parseAndSetApplicationId( applicationId );
		return this;
	}


	public ApplicationStatusChangeEntity withoutApplicationId( Integer applicationId ) {

		this.setApplicationId( null );
		return this;
	}


	public ApplicationStatusChangeEntity withoutParsedApplicationId( String applicationId ) {

		this.setApplicationId( null );
		return this;
	}


	@Override
	public int compareTo( ApplicationStatusChangeEntity otherApplicationStatusChange ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof ApplicationStatusChangeEntity ) ) {
        return false;
      }
		ApplicationStatusChangeEntity otherApplicationStatusChange = ( ApplicationStatusChangeEntity ) obj;
		return
				this.getId().equals( otherApplicationStatusChange.getId() )
						&& this.getDateChanged().equals( otherApplicationStatusChange.getDateChanged() )
						&& this.getApplicationStatusId().equals( otherApplicationStatusChange.getApplicationStatusId() )
						&& this.getApplicationId().equals( otherApplicationStatusChange.getApplicationId() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getDateChanged()
				, this.getApplicationStatusId()
				, this.getApplicationId()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"dateChanged:" + this.getDateChanged() + ", " +
				"applicationStatusId:" + this.getApplicationStatusId() + ", " +
				"applicationId:" + this.getApplicationId() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getDateChanged() == null &&
				this.getApplicationStatusId() == null &&
				this.getApplicationId() == null );
	}

}
