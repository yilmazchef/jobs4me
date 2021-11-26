package be.intec.models.entities;


import java.io.Serializable;
import java.util.Objects;

public class AnswersEntity implements Serializable, Comparable< AnswersEntity > {

	private Integer id;
	private Integer applicationTestId;
	private Integer recruiterId;
	private String totalGrades;
	private String pass;
	private String answerDetails;


	public AnswersEntity() {

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


	public AnswersEntity withId( Integer id ) {

		this.setId( id );
		return this;
	}


	public AnswersEntity withParsedId( String id ) {

		this.parseAndSetId( id );
		return this;
	}


	public AnswersEntity withoutId( Integer id ) {

		this.setId( null );
		return this;
	}


	public AnswersEntity withoutParsedId( String id ) {

		this.setId( null );
		return this;
	}


	public Integer getApplicationTestId() {

		return applicationTestId;
	}


	public void setApplicationTestId( Integer applicationTestId ) {

		this.applicationTestId = applicationTestId;
	}


	public void parseAndSetApplicationTestId( String applicationTestId ) {

		this.applicationTestId = Integer.parseInt( applicationTestId );
	}


	public AnswersEntity withApplicationTestId( Integer applicationTestId ) {

		this.setApplicationTestId( applicationTestId );
		return this;
	}


	public AnswersEntity withParsedApplicationTestId( String applicationTestId ) {

		this.parseAndSetApplicationTestId( applicationTestId );
		return this;
	}


	public AnswersEntity withoutApplicationTestId( Integer applicationTestId ) {

		this.setApplicationTestId( null );
		return this;
	}


	public AnswersEntity withoutParsedApplicationTestId( String applicationTestId ) {

		this.setApplicationTestId( null );
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


	public AnswersEntity withRecruiterId( Integer recruiterId ) {

		this.setRecruiterId( recruiterId );
		return this;
	}


	public AnswersEntity withParsedRecruiterId( String recruiterId ) {

		this.parseAndSetRecruiterId( recruiterId );
		return this;
	}


	public AnswersEntity withoutRecruiterId( Integer recruiterId ) {

		this.setRecruiterId( null );
		return this;
	}


	public AnswersEntity withoutParsedRecruiterId( String recruiterId ) {

		this.setRecruiterId( null );
		return this;
	}


	public String getTotalGrades() {

		return totalGrades;
	}


	public void setTotalGrades( String totalGrades ) {

		this.totalGrades = totalGrades;
	}


	public void parseAndSetTotalGrades( String totalGrades ) {

		this.totalGrades = totalGrades;
	}


	public AnswersEntity withTotalGrades( String totalGrades ) {

		this.setTotalGrades( totalGrades );
		return this;
	}


	public AnswersEntity withParsedTotalGrades( String totalGrades ) {

		this.parseAndSetTotalGrades( totalGrades );
		return this;
	}


	public AnswersEntity withoutTotalGrades( String totalGrades ) {

		this.setTotalGrades( null );
		return this;
	}


	public AnswersEntity withoutParsedTotalGrades( String totalGrades ) {

		this.setTotalGrades( null );
		return this;
	}


	public String getPass() {

		return pass;
	}


	public void setPass( String pass ) {

		this.pass = pass;
	}


	public void parseAndSetPass( String pass ) {

		this.pass = pass;
	}


	public AnswersEntity withPass( String pass ) {

		this.setPass( pass );
		return this;
	}


	public AnswersEntity withParsedPass( String pass ) {

		this.parseAndSetPass( pass );
		return this;
	}


	public AnswersEntity withoutPass( String pass ) {

		this.setPass( null );
		return this;
	}


	public AnswersEntity withoutParsedPass( String pass ) {

		this.setPass( null );
		return this;
	}


	public String getAnswerDetails() {

		return answerDetails;
	}


	public void setAnswerDetails( String answerDetails ) {

		this.answerDetails = answerDetails;
	}


	public void parseAndSetAnswerDetails( String answerDetails ) {

		this.answerDetails = answerDetails;
	}


	public AnswersEntity withAnswerDetails( String answerDetails ) {

		this.setAnswerDetails( answerDetails );
		return this;
	}


	public AnswersEntity withParsedAnswerDetails( String answerDetails ) {

		this.parseAndSetAnswerDetails( answerDetails );
		return this;
	}


	public AnswersEntity withoutAnswerDetails( String answerDetails ) {

		this.setAnswerDetails( null );
		return this;
	}


	public AnswersEntity withoutParsedAnswerDetails( String answerDetails ) {

		this.setAnswerDetails( null );
		return this;
	}


	@Override
	public int compareTo( AnswersEntity otherAnswers ) {
		// define here default comparison criteria
		return 0;
	}


	@Override
	public boolean equals( Object obj ) {

      if ( this == obj ) {
        return true;
      }
      if ( !( obj instanceof AnswersEntity ) ) {
        return false;
      }
		AnswersEntity otherAnswers = ( AnswersEntity ) obj;
		return
				this.getId().equals( otherAnswers.getId() )
						&& this.getApplicationTestId().equals( otherAnswers.getApplicationTestId() )
						&& this.getRecruiterId().equals( otherAnswers.getRecruiterId() )
						&& this.getTotalGrades().equals( otherAnswers.getTotalGrades() )
						&& this.getPass().equals( otherAnswers.getPass() )
						&& this.getAnswerDetails().equals( otherAnswers.getAnswerDetails() )
				;
	}


	@Override
	public int hashCode() {

		return Objects.hash(
				this.getId()
				, this.getApplicationTestId()
				, this.getRecruiterId()
				, this.getTotalGrades()
				, this.getPass()
				, this.getAnswerDetails()
		);
	}


	@Override
	public String toString() {

		return "{ " +
				"id:" + this.getId() + ", " +
				"applicationTestId:" + this.getApplicationTestId() + ", " +
				"recruiterId:" + this.getRecruiterId() + ", " +
				"totalGrades:" + this.getTotalGrades() + ", " +
				"pass:" + this.getPass() + ", " +
				"answerDetails:" + this.getAnswerDetails() +
				" } ";
	}


	public boolean isNew() {

		return this.getId() == null;
	}


	public boolean isEmpty() {

		return ( this.getId() == null &&
				this.getApplicationTestId() == null &&
				this.getRecruiterId() == null &&
				this.getTotalGrades() == null &&
				this.getPass() == null &&
				this.getAnswerDetails() == null );
	}

}
