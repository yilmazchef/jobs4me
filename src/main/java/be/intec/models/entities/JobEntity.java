package be.intec.models.entities;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class JobEntity implements Serializable, Comparable< JobEntity > {

	private Integer id;
	private String code;
	private String name;
	private String description;
	private Timestamp datePublished;
	private Timestamp jobStartDate;
	private Integer noOfVacancies;
	private Integer jobCategoryId;
	private Integer jobPositionId;
	private Integer jobPlatformId;
	private Integer organizationId;
	private Integer processId;


	public JobEntity() {

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


	public JobEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public JobEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public JobEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public JobEntity withoutParsedId( String id ) {

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


	public JobEntity withCode( String code ) {

		this.setCode( code );
		return this;
	}


	public JobEntity withParsedCode( String code ) {

		this.parseAndSetCode( code );
		return this;
	}


	public JobEntity withoutCode( String code ) {

		this.setCode( null );
		return this;
	}


	public JobEntity withoutParsedCode( String code ) {

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


	public JobEntity withName( String name ) {

		this.setName( name );
		return this;
	}


	public JobEntity withParsedName( String name ) {

		this.parseAndSetName( name );
		return this;
	}


	public JobEntity withoutName( String name ) {

		this.setName( null );
		return this;
	}


	public JobEntity withoutParsedName( String name ) {

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


	public JobEntity withDescription( String description ) {

		this.setDescription( description );
		return this;
	}


	public JobEntity withParsedDescription( String description ) {

		this.parseAndSetDescription( description );
		return this;
	}


	public JobEntity withoutDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public JobEntity withoutParsedDescription( String description ) {

		this.setDescription( null );
		return this;
	}


	public Timestamp getDatePublished() {

		return datePublished;
	}


	public void setDatePublished( Timestamp datePublished ) {

		this.datePublished = datePublished;
	}


	public void parseAndSetDatePublished( String datePublished ) {

		this.datePublished = java.sql.Timestamp.valueOf( datePublished );
	}


	public JobEntity withDatePublished( Timestamp datePublished ) {

		this.setDatePublished( datePublished );
		return this;
	}


	public JobEntity withParsedDatePublished( String datePublished ) {

		this.parseAndSetDatePublished( datePublished );
		return this;
	}


	public JobEntity withoutDatePublished( Timestamp datePublished ) {

		this.setDatePublished( null );
		return this;
	}


	public JobEntity withoutParsedDatePublished( String datePublished ) {

		this.setDatePublished( null );
		return this;
	}


	public Timestamp getJobStartDate() {

		return jobStartDate;
	}


	public void setJobStartDate( Timestamp jobStartDate ) {

		this.jobStartDate = jobStartDate;
	}


	public void parseAndSetJobStartDate( String jobStartDate ) {

		this.jobStartDate = java.sql.Timestamp.valueOf( jobStartDate );
	}


	public JobEntity withJobStartDate( Timestamp jobStartDate ) {

		this.setJobStartDate( jobStartDate );
		return this;
	}


	public JobEntity withParsedJobStartDate( String jobStartDate ) {

		this.parseAndSetJobStartDate( jobStartDate );
		return this;
	}


	public JobEntity withoutJobStartDate( Timestamp jobStartDate ) {

		this.setJobStartDate( null );
		return this;
	}


	public JobEntity withoutParsedJobStartDate( String jobStartDate ) {

		this.setJobStartDate( null );
		return this;
	}


	public Integer getNoOfVacancies() {

		return noOfVacancies;
	}


	public void setNoOfVacancies( Integer noOfVacancies ) {

		this.noOfVacancies = noOfVacancies;
	}


	public void parseAndSetNoOfVacancies( String noOfVacancies ) {

		this.noOfVacancies = Integer.parseInt( noOfVacancies );
	}


	public JobEntity withNoOfVacancies( Integer noOfVacancies ) {

		this.setNoOfVacancies( noOfVacancies );
		return this;
	}


	public JobEntity withParsedNoOfVacancies( String noOfVacancies ) {

		this.parseAndSetNoOfVacancies( noOfVacancies );
		return this;
	}


	public JobEntity withoutNoOfVacancies( Integer noOfVacancies ) {

		this.setNoOfVacancies( null );
		return this;
	}


	public JobEntity withoutParsedNoOfVacancies( String noOfVacancies ) {

		this.setNoOfVacancies( null );
		return this;
	}


	public Integer getJobCategoryId() {

		return jobCategoryId;
	}


	public void setJobCategoryId( Integer jobCategoryId ) {

		this.jobCategoryId = jobCategoryId;
	}


	public void parseAndSetJobCategoryId( String jobCategoryId ) {

		this.jobCategoryId = Integer.parseInt( jobCategoryId );
	}


	public JobEntity withJobCategoryId( Integer jobCategoryId ) {

		this.setJobCategoryId( jobCategoryId );
		return this;
	}


	public JobEntity withParsedJobCategoryId( String jobCategoryId ) {

		this.parseAndSetJobCategoryId( jobCategoryId );
		return this;
	}


	public JobEntity withoutJobCategoryId( Integer jobCategoryId ) {

		this.setJobCategoryId( null );
		return this;
	}


	public JobEntity withoutParsedJobCategoryId( String jobCategoryId ) {

		this.setJobCategoryId( null );
		return this;
	}


	public Integer getJobPositionId() {

		return jobPositionId;
	}


	public void setJobPositionId( Integer jobPositionId ) {

		this.jobPositionId = jobPositionId;
	}


	public void parseAndSetJobPositionId( String jobPositionId ) {

		this.jobPositionId = Integer.parseInt( jobPositionId );
	}


	public JobEntity withJobPositionId( Integer jobPositionId ) {

		this.setJobPositionId( jobPositionId );
		return this;
	}


	public JobEntity withParsedJobPositionId( String jobPositionId ) {

		this.parseAndSetJobPositionId( jobPositionId );
		return this;
	}


	public JobEntity withoutJobPositionId( Integer jobPositionId ) {

		this.setJobPositionId( null );
		return this;
	}


	public JobEntity withoutParsedJobPositionId( String jobPositionId ) {

		this.setJobPositionId( null );
		return this;
	}


	public Integer getJobPlatformId() {

		return jobPlatformId;
	}


	public void setJobPlatformId( Integer jobPlatformId ) {

		this.jobPlatformId = jobPlatformId;
	}


	public void parseAndSetJobPlatformId( String jobPlatformId ) {

		this.jobPlatformId = Integer.parseInt( jobPlatformId );
	}


	public JobEntity withJobPlatformId( Integer jobPlatformId ) {

		this.setJobPlatformId( jobPlatformId );
		return this;
	}


	public JobEntity withParsedJobPlatformId( String jobPlatformId ) {

		this.parseAndSetJobPlatformId( jobPlatformId );
		return this;
	}


	public JobEntity withoutJobPlatformId( Integer jobPlatformId ) {

		this.setJobPlatformId( null );
		return this;
	}


	public JobEntity withoutParsedJobPlatformId( String jobPlatformId ) {

		this.setJobPlatformId( null );
		return this;
	}


	public Integer getOrganizationId() {

		return organizationId;
	}


	public void setOrganizationId( Integer organizationId ) {

		this.organizationId = organizationId;
	}


	public void parseAndSetOrganizationId( String organizationId ) {

		this.organizationId = Integer.parseInt( organizationId );
	}


	public JobEntity withOrganizationId( Integer organizationId ) {

		this.setOrganizationId( organizationId );
		return this;
	}


	public JobEntity withParsedOrganizationId( String organizationId ) {

		this.parseAndSetOrganizationId( organizationId );
		return this;
	}


	public JobEntity withoutOrganizationId( Integer organizationId ) {

		this.setOrganizationId( null );
		return this;
	}


	public JobEntity withoutParsedOrganizationId( String organizationId ) {

		this.setOrganizationId( null );
		return this;
	}


	public Integer getProcessId() {

		return processId;
	}


	public void setProcessId( Integer processId ) {

		this.processId = processId;
	}


	public void parseAndSetProcessId( String processId ) {

		this.processId = Integer.parseInt( processId );
	}


	public JobEntity withProcessId( Integer processId ) {

		this.setProcessId( processId );
		return this;
	}


	public JobEntity withParsedProcessId( String processId ) {

		this.parseAndSetProcessId( processId );
		return this;
	}


	public JobEntity withoutProcessId( Integer processId ) {

		this.setProcessId( null );
		return this;
	}


	public JobEntity withoutParsedProcessId( String processId ) {

		this.setProcessId( null );
		return this;
	}


	@Override
	public int compareTo( JobEntity otherJob ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof JobEntity ) ) {
        return false;
      }
		JobEntity otherJob = ( JobEntity ) obj;
		return
				this.getId().equals( otherJob.getId() )
						&& this.getCode().equals( otherJob.getCode() )
						&& this.getName().equals( otherJob.getName() )
						&& this.getDescription().equals( otherJob.getDescription() )
						&& this.getDatePublished().equals( otherJob.getDatePublished() )
						&& this.getJobStartDate().equals( otherJob.getJobStartDate() )
						&& this.getNoOfVacancies().equals( otherJob.getNoOfVacancies() )
						&& this.getJobCategoryId().equals( otherJob.getJobCategoryId() )
						&& this.getJobPositionId().equals( otherJob.getJobPositionId() )
						&& this.getJobPlatformId().equals( otherJob.getJobPlatformId() )
						&& this.getOrganizationId().equals( otherJob.getOrganizationId() )
						&& this.getProcessId().equals( otherJob.getProcessId() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getCode()
				, this.getName()
				, this.getDescription()
				, this.getDatePublished()
				, this.getJobStartDate()
				, this.getNoOfVacancies()
				, this.getJobCategoryId()
				, this.getJobPositionId()
				, this.getJobPlatformId()
				, this.getOrganizationId()
				, this.getProcessId()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"code:" + this.getCode() + ", " +
				"name:" + this.getName() + ", " +
				"description:" + this.getDescription() + ", " +
				"datePublished:" + this.getDatePublished() + ", " +
				"jobStartDate:" + this.getJobStartDate() + ", " +
				"noOfVacancies:" + this.getNoOfVacancies() + ", " +
				"jobCategoryId:" + this.getJobCategoryId() + ", " +
				"jobPositionId:" + this.getJobPositionId() + ", " +
				"jobPlatformId:" + this.getJobPlatformId() + ", " +
				"organizationId:" + this.getOrganizationId() + ", " +
				"processId:" + this.getProcessId() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getCode() == null &&
				this.getName() == null &&
				this.getDescription() == null &&
				this.getDatePublished() == null &&
				this.getJobStartDate() == null &&
				this.getNoOfVacancies() == null &&
				this.getJobCategoryId() == null &&
				this.getJobPositionId() == null &&
				this.getJobPlatformId() == null &&
				this.getOrganizationId() == null &&
				this.getProcessId() == null );
	}

}
