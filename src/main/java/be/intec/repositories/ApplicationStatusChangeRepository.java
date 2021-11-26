package be.intec.repositories;


import be.intec.models.entities.ApplicationStatusChangeEntity;
import be.intec.services.exceptions.ApplicationStatusChangeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationStatusChangeRepository {

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
		for ( final ApplicationStatusChangeEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE application_status_change AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( ApplicationStatusChangeEntity record ) throws ApplicationStatusChangeException {

		int rowsEffected = 0;

		try {
			String query = "insert into application_status_change ( date_changed, application_status_id, application_id ) values ( ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, record.getDateChanged() );
			statement.setInt( 2, record.getApplicationStatusId() );
			statement.setInt( 3, record.getApplicationId() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public ApplicationStatusChangeEntity findById( Integer id ) throws ApplicationStatusChangeException {


		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< ApplicationStatusChangeEntity > findAllByExample( ApplicationStatusChangeEntity example ) throws ApplicationStatusChangeException {

		final List< ApplicationStatusChangeEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where date_changed = ? OR application_status_id = ? OR application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, example.getDateChanged() );
			statement.setInt( 2, example.getApplicationStatusId() );
			statement.setInt( 3, example.getApplicationId() );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< ApplicationStatusChangeEntity > findAll() throws ApplicationStatusChangeException {

		final List< ApplicationStatusChangeEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, ApplicationStatusChangeEntity record ) throws ApplicationStatusChangeException {

		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange is required." ).nullApplicationStatusChangeException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_status_change set   date_changed  = ?,   application_status_id  = ?,   application_id  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, record.getDateChanged() );
			statement.setInt( 2, record.getApplicationStatusId() );
			statement.setInt( 3, record.getApplicationId() );
			statement.setInt( 4, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws ApplicationStatusChangeException {


		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from application_status_change where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateDateChangedById( Integer id, java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		if ( dateChanged == null ) {
			throw new ApplicationStatusChangeException( " dateChanged is required." ).nullApplicationStatusChangeException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_status_change set  date_changed  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateChanged );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateApplicationStatusIdById( Integer id, Integer applicationStatusId ) throws ApplicationStatusChangeException {

		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		if ( applicationStatusId == null ) {
			throw new ApplicationStatusChangeException( " applicationStatusId is required." ).nullApplicationStatusChangeException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_status_change set  application_status_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationStatusId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateApplicationIdById( Integer id, Integer applicationId ) throws ApplicationStatusChangeException {

		if ( id < 0 ) {
			throw new ApplicationStatusChangeException( " ApplicationStatusChange ID is required." ).requiredFields( "id" );
		}

		if ( applicationId == null ) {
			throw new ApplicationStatusChangeException( " applicationId is required." ).nullApplicationStatusChangeException();
		}

		int rowsEffected = 0;

		try {
			String query = "update application_status_change set  application_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws ApplicationStatusChangeException {

		boolean exists = false;
		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationStatusChangeEntity > searchByDateChanged( java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

		final List< ApplicationStatusChangeEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where date_changed = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateChanged );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByDateChanged( java.sql.Timestamp dateChanged ) throws ApplicationStatusChangeException {

		boolean exists = false;
		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where date_changed = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, dateChanged );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationStatusChangeEntity > searchByApplicationStatusId( Integer applicationStatusId ) throws ApplicationStatusChangeException {

		final List< ApplicationStatusChangeEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where application_status_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationStatusId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByApplicationStatusId( Integer applicationStatusId ) throws ApplicationStatusChangeException {

		boolean exists = false;
		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where application_status_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationStatusId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ApplicationStatusChangeEntity > searchByApplicationId( Integer applicationId ) throws ApplicationStatusChangeException {

		final List< ApplicationStatusChangeEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ApplicationStatusChangeEntity item = new ApplicationStatusChangeEntity();
				item.setId( results.getInt( "id" ) );
				item.setDateChanged( results.getTimestamp( "date_changed" ) );
				item.setApplicationStatusId( results.getInt( "application_status_id" ) );
				item.setApplicationId( results.getInt( "application_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByApplicationId( Integer applicationId ) throws ApplicationStatusChangeException {

		boolean exists = false;
		try {
			String query = "select id, date_changed, application_status_id, application_id from application_status_change where application_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, applicationId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ApplicationStatusChangeException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ApplicationStatusChangeException( exception.getMessage() );
			}
		}

		return exists;
	}


}
