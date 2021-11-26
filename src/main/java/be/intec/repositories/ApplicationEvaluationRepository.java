package be.intec.repositories;


import be.intec.models.entities.ApplicationEvaluationEntity;
import be.intec.services.exceptions.ApplicationEvaluationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationEvaluationRepository {

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
		for ( final ApplicationEvaluationEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE application_evaluation AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( ApplicationEvaluationEntity record ) throws ApplicationEvaluationException {

		int rowsEffected = 0;

		try {
			String query = "insert into application_evaluation ( notes, recruiter_id, application_id, hired ) values ( ?, ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getNotes() );
			statement.setInt( 2, record.getRecruiterId() );
			statement.setInt( 3, record.getApplicationId() );
			statement.setString( 4, record.getHired() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public ApplicationEvaluationEntity findById( Integer id ) throws ApplicationEvaluationException {


		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< ApplicationEvaluationEntity > findAllByExample( ApplicationEvaluationEntity example ) throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where notes = ? OR recruiter_id = ? OR application_id = ? OR hired = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getNotes() );
			statement.setInt( 2, example.getRecruiterId() );
			statement.setInt( 3, example.getApplicationId() );
			statement.setString( 4, example.getHired() );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< ApplicationEvaluationEntity > findAll() throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, ApplicationEvaluationEntity record ) throws ApplicationEvaluationException {

		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation is required." ).nullApplicationEvaluationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_evaluation set   notes  = ?,   recruiter_id  = ?,   application_id  = ?,   hired  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getNotes() );
			statement.setInt( 2, record.getRecruiterId() );
			statement.setInt( 3, record.getApplicationId() );
			statement.setString( 4, record.getHired() );
			statement.setInt( 5, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws ApplicationEvaluationException {


		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from application_evaluation where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateNotesById( Integer id, String notes ) throws ApplicationEvaluationException {

		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		if ( notes == null ) {
			throw new ApplicationEvaluationException( " notes is required." ).nullApplicationEvaluationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_evaluation set  notes  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, notes );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws ApplicationEvaluationException {

		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		if ( recruiterId == null ) {
			throw new ApplicationEvaluationException( " recruiterId is required." ).nullApplicationEvaluationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_evaluation set  recruiter_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationEvaluationException {

		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		if ( applicationId == null ) {
			throw new ApplicationEvaluationException( " applicationId is required." ).nullApplicationEvaluationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_evaluation set  application_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateHiredById( Integer id, String hired ) throws ApplicationEvaluationException {

		if ( id < 0 ) {
			throw new ApplicationEvaluationException( " ApplicationEvaluation ID is required." ).requiredFields( "id" );
		}

		if ( hired == null ) {
			throw new ApplicationEvaluationException( " hired is required." ).nullApplicationEvaluationException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_evaluation set  hired  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, hired );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws ApplicationEvaluationException {

		boolean exists = false;
		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEvaluationEntity > searchByNotes( String notes ) throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where notes LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, notes );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByNotes( String notes ) throws ApplicationEvaluationException {

		boolean exists = false;
		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where notes LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, notes );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEvaluationEntity > searchByRecruiterId( Integer recruiterId ) throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where recruiter_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByRecruiterId( Integer recruiterId ) throws ApplicationEvaluationException {

		boolean exists = false;
		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where recruiter_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEvaluationEntity > searchByApplicationId( Integer applicationId ) throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByApplicationId( Integer applicationId ) throws ApplicationEvaluationException {

		boolean exists = false;
		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationEvaluationEntity > searchByHired( String hired ) throws ApplicationEvaluationException {

		final List< ApplicationEvaluationEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where hired LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, hired );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationEvaluationEntity item = new ApplicationEvaluationEntity();
				item.setId( results.getInt( "id" ) );
				item.setNotes( results.getString( "notes" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
				item.setHired( results.getString( "hired" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByHired( String hired ) throws ApplicationEvaluationException {

		boolean exists = false;
		try {
			String query = "select id, notes, recruiter_id, application_id, hired from application_evaluation where hired LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, hired );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationEvaluationException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationEvaluationException( exception.getMessage() );
			}
		}

		return exists;
	}


}
