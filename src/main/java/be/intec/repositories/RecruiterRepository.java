package be.intec.repositories;


import be.intec.models.entities.RecruiterEntity;
import be.intec.services.exceptions.RecruiterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterRepository {

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
		for ( final RecruiterEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE recruiter AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( RecruiterEntity record ) throws RecruiterException {

		int rowsEffected = 0;

		try {
			String query = "insert into recruiter ( first_name, last_name, email ) values ( ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getFirstName() );
			statement.setString( 2, record.getLastName() );
			statement.setString( 3, record.getEmail() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public RecruiterEntity findById( Integer id ) throws RecruiterException {


		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		RecruiterEntity item = new RecruiterEntity();

		try {
			String query = "select id, first_name, last_name, email from recruiter where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< RecruiterEntity > findAllByExample( RecruiterEntity example ) throws RecruiterException {

		final List< RecruiterEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, first_name, last_name, email from recruiter where first_name = ? OR last_name = ? OR email = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getFirstName() );
			statement.setString( 2, example.getLastName() );
			statement.setString( 3, example.getEmail() );

			results = statement.executeQuery();
			while ( results.next() ) {
				RecruiterEntity item = new RecruiterEntity();
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< RecruiterEntity > findAll() throws RecruiterException {

		final List< RecruiterEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, first_name, last_name, email from recruiter ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				RecruiterEntity item = new RecruiterEntity();
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, RecruiterEntity record ) throws RecruiterException {

		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new RecruiterException( " Recruiter is required." ).nullRecruiterException();
		}

		int rowsEffected = 0;

		try {
			String query = "update recruiter set   first_name  = ?,   last_name  = ?,   email  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getFirstName() );
			statement.setString( 2, record.getLastName() );
			statement.setString( 3, record.getEmail() );
			statement.setInt( 4, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws RecruiterException {


		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from recruiter where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateFirstNameById( Integer id, String firstName ) throws RecruiterException {

		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		if ( firstName == null ) {
			throw new RecruiterException( " firstName is required." ).nullRecruiterException();
		}

		int rowsEffected = 0;

		try {
			String query = "update recruiter set  first_name  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, firstName );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateLastNameById( Integer id, String lastName ) throws RecruiterException {

		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		if ( lastName == null ) {
			throw new RecruiterException( " lastName is required." ).nullRecruiterException();
		}

		int rowsEffected = 0;

		try {
			String query = "update recruiter set  last_name  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, lastName );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateEmailById( Integer id, String email ) throws RecruiterException {

		if ( id < 0 ) {
			throw new RecruiterException( " Recruiter ID is required." ).requiredFields( "id" );
		}

		if ( email == null ) {
			throw new RecruiterException( " email is required." ).nullRecruiterException();
		}

		int rowsEffected = 0;

		try {
			String query = "update recruiter set  email  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, email );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws RecruiterException {

		boolean exists = false;
		try {
			String query = "select id, first_name, last_name, email from recruiter where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< RecruiterEntity > searchByFirstName( String firstName ) throws RecruiterException {

		final List< RecruiterEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, first_name, last_name, email from recruiter where first_name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, firstName );

			results = statement.executeQuery();

			while ( results.next() ) {
				RecruiterEntity item = new RecruiterEntity();
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByFirstName( String firstName ) throws RecruiterException {

		boolean exists = false;
		try {
			String query = "select id, first_name, last_name, email from recruiter where first_name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, firstName );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< RecruiterEntity > searchByLastName( String lastName ) throws RecruiterException {

		final List< RecruiterEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, first_name, last_name, email from recruiter where last_name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, lastName );

			results = statement.executeQuery();

			while ( results.next() ) {
				RecruiterEntity item = new RecruiterEntity();
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByLastName( String lastName ) throws RecruiterException {

		boolean exists = false;
		try {
			String query = "select id, first_name, last_name, email from recruiter where last_name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, lastName );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< RecruiterEntity > searchByEmail( String email ) throws RecruiterException {

		final List< RecruiterEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, first_name, last_name, email from recruiter where email LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, email );

			results = statement.executeQuery();

			while ( results.next() ) {
				RecruiterEntity item = new RecruiterEntity();
				item.setId( results.getInt( "id" ) );
				item.setFirstName( results.getString( "first_name" ) );
				item.setLastName( results.getString( "last_name" ) );
				item.setEmail( results.getString( "email" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByEmail( String email ) throws RecruiterException {

		boolean exists = false;
		try {
			String query = "select id, first_name, last_name, email from recruiter where email LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, email );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new RecruiterException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new RecruiterException( exception.getMessage() );
			}
		}

		return exists;
	}


}
