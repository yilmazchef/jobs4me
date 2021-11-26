package be.intec.repositories;


import be.intec.models.entities.ProcessEntity;
import be.intec.services.exceptions.ProcessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessRepository {

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
		for ( final ProcessEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE process AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( ProcessEntity record ) throws ProcessException {

		int rowsEffected = 0;

		try {
			String query = "insert into process ( code, description, recruiter_id ) values ( ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getDescription() );
			statement.setInt( 3, record.getRecruiterId() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public ProcessEntity findById( Integer id ) throws ProcessException {


		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		ProcessEntity item = new ProcessEntity();

		try {
			String query = "select id, code, description, recruiter_id from process where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< ProcessEntity > findAllByExample( ProcessEntity example ) throws ProcessException {

		final List< ProcessEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, description, recruiter_id from process where code = ? OR description = ? OR recruiter_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getCode() );
			statement.setString( 2, example.getDescription() );
			statement.setInt( 3, example.getRecruiterId() );

			results = statement.executeQuery();
			while ( results.next() ) {
				ProcessEntity item = new ProcessEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< ProcessEntity > findAll() throws ProcessException {

		final List< ProcessEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, description, recruiter_id from process ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				ProcessEntity item = new ProcessEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, ProcessEntity record ) throws ProcessException {

		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new ProcessException( " Process is required." ).nullProcessException();
		}

		int rowsEffected = 0;

		try {
			String query = "update process set   code  = ?,   description  = ?,   recruiter_id  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getDescription() );
			statement.setInt( 3, record.getRecruiterId() );
			statement.setInt( 4, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws ProcessException {


		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from process where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateCodeById( Integer id, String code ) throws ProcessException {

		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		if ( code == null ) {
			throw new ProcessException( " code is required." ).nullProcessException();
		}

		int rowsEffected = 0;

		try {
			String query = "update process set  code  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateDescriptionById( Integer id, String description ) throws ProcessException {

		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		if ( description == null ) {
			throw new ProcessException( " description is required." ).nullProcessException();
		}

		int rowsEffected = 0;

		try {
			String query = "update process set  description  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateRecruiterIdById( Integer id, Integer recruiterId ) throws ProcessException {

		if ( id < 0 ) {
			throw new ProcessException( " Process ID is required." ).requiredFields( "id" );
		}

		if ( recruiterId == null ) {
			throw new ProcessException( " recruiterId is required." ).nullProcessException();
		}

		int rowsEffected = 0;

		try {
			String query = "update process set  recruiter_id  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws ProcessException {

		boolean exists = false;
		try {
			String query = "select id, code, description, recruiter_id from process where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ProcessEntity > searchByCode( String code ) throws ProcessException {

		final List< ProcessEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, description, recruiter_id from process where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();

			while ( results.next() ) {
				ProcessEntity item = new ProcessEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByCode( String code ) throws ProcessException {

		boolean exists = false;
		try {
			String query = "select id, code, description, recruiter_id from process where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ProcessEntity > searchByDescription( String description ) throws ProcessException {

		final List< ProcessEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, description, recruiter_id from process where description LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );

			results = statement.executeQuery();

			while ( results.next() ) {
				ProcessEntity item = new ProcessEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByDescription( String description ) throws ProcessException {

		boolean exists = false;
		try {
			String query = "select id, code, description, recruiter_id from process where description LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< ProcessEntity > searchByRecruiterId( Integer recruiterId ) throws ProcessException {

		final List< ProcessEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, description, recruiter_id from process where recruiter_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );

			results = statement.executeQuery();

			while ( results.next() ) {
				ProcessEntity item = new ProcessEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDescription( results.getString( "description" ) );
				item.setRecruiterId( results.getInt( "recruiter_id" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByRecruiterId( Integer recruiterId ) throws ProcessException {

		boolean exists = false;
		try {
			String query = "select id, code, description, recruiter_id from process where recruiter_id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, recruiterId );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new ProcessException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new ProcessException( exception.getMessage() );
			}
		}

		return exists;
	}


}
