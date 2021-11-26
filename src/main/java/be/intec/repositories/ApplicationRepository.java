package be.intec.repositories;


import be.intec.models.entities.ApplicationEntity;
import be.intec.services.exceptions.ApplicationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet results = null;


	private Connection getConnection() throws SQLException {

		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}


	public int clear() {

		int rowsDeleted = 0;
		final var entities = findAll();
		for ( final ApplicationEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE application AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( ApplicationEntity record ) throws ApplicationException {

		int rowsEffected = 0;

		try {
			String query = "insert into application ( date_of_application, education, experience, other_info, job_id, applicant_id ) values ( ?, ?, ?, ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, record.getDateOfApplication() );
			statement.setString( 2, record.getEducation() );
			statement.setString( 3, record.getExperience() );
			statement.setString( 4, record.getOtherInfo() );
			statement.setInt( 5, record.getJobId() );
			statement.setInt( 6, record.getApplicantId() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public ApplicationEntity findById( Integer id ) throws ApplicationException {


		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		ApplicationEntity item = new ApplicationEntity();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< ApplicationEntity > findAllByExample( ApplicationEntity example ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where date_of_application = ? OR education = ? OR experience = ? OR other_info = ? OR job_id = ? OR applicant_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, example.getDateOfApplication() );
			statement.setString( 2, example.getEducation() );
			statement.setString( 3, example.getExperience() );
			statement.setString( 4, example.getOtherInfo() );
			statement.setInt( 5, example.getJobId() );
			statement.setInt( 6, example.getApplicantId() );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< ApplicationEntity > findAll() throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, ApplicationEntity record ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new ApplicationException( " Application is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set   date_of_application  = ?,   education  = ?,   experience  = ?,   other_info  = ?,   job_id  = ?,   applicant_id  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, record.getDateOfApplication() );
			statement.setString( 2, record.getEducation() );
			statement.setString( 3, record.getExperience() );
			statement.setString( 4, record.getOtherInfo() );
			statement.setInt( 5, record.getJobId() );
			statement.setInt( 6, record.getApplicantId() );
			statement.setInt( 7, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws ApplicationException {


		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from application where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateDateOfApplicationById( Integer id, java.sql.Timestamp dateOfApplication ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( dateOfApplication == null ) {
			throw new ApplicationException( " dateOfApplication is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  date_of_application  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateOfApplication );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateEducationById( Integer id, String education ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( education == null ) {
			throw new ApplicationException( " education is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  education  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, education );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateExperienceById( Integer id, String experience ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( experience == null ) {
			throw new ApplicationException( " experience is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  experience  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, experience );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateOtherInfoById( Integer id, String otherInfo ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( otherInfo == null ) {
			throw new ApplicationException( " otherInfo is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  other_info  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, otherInfo );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateJobIdById( Integer id, Integer jobId ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( jobId == null ) {
			throw new ApplicationException( " jobId is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  job_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, jobId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateApplicantIdById( Integer id, Integer applicantId ) throws ApplicationException {

		if ( id < 0 ) {
			throw new ApplicationException( " Application ID is required." ).requiredFields( "id" );
		}

		if ( applicantId == null ) {
			throw new ApplicationException( " applicantId is required." ).nullApplicationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application set  applicant_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicantId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByDateOfApplication( java.sql.Timestamp dateOfApplication ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where date_of_application = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateOfApplication );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByDateOfApplication( java.sql.Timestamp dateOfApplication ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where date_of_application = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateOfApplication );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByEducation( String education ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where education LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, education );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByEducation( String education ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where education LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, education );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByExperience( String experience ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where experience LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, experience );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByExperience( String experience ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where experience LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, experience );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByOtherInfo( String otherInfo ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where other_info LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, otherInfo );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByOtherInfo( String otherInfo ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where other_info LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, otherInfo );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByJobId( Integer jobId ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where job_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, jobId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByJobId( Integer jobId ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where job_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, jobId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEntity > searchByApplicantId( Integer applicantId ) throws ApplicationException {

		final List< ApplicationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where applicant_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicantId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEntity item = new ApplicationEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateOfApplication( results.getTimestamp( "date_of_application" ) );
				item.setEducation( results.getString( "education" ) );
				item.setExperience( results.getString( "experience" ) );
				item.setOtherInfo( results.getString( "other_info" ) );
				item.setJobId( results.getInt( "job_id" ) );
				item.setApplicantId( results.getInt( "applicant_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByApplicantId( Integer applicantId ) throws ApplicationException {

		boolean exists = false;
		try {
			String query = "select id, date_of_application, education, experience, other_info, job_id, applicant_id from application where applicant_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicantId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationException( exception.getMessage() );
			}
		}

		return exists;
	}


}
