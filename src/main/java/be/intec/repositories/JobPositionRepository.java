package be.intec.repositories;


import be.intec.models.entities.JobPositionEntity;
import be.intec.services.exceptions.JobPositionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobPositionRepository {

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
		for ( final JobPositionEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE job_position AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( JobPositionEntity record ) throws JobPositionException {

		int rowsEffected = 0;

		try {
			String query = "insert into job_position ( code, name, description ) values ( ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getName() );
			statement.setString( 3, record.getDescription() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public JobPositionEntity findById( Integer id ) throws JobPositionException {


		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		JobPositionEntity item = new JobPositionEntity();

		try {
			String query = "select id, code, name, description from job_position where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< JobPositionEntity > findAllByExample( JobPositionEntity example ) throws JobPositionException {

		final List< JobPositionEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name, description from job_position where code = ? OR name = ? OR description = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getCode() );
			statement.setString( 2, example.getName() );
			statement.setString( 3, example.getDescription() );

			results = statement.executeQuery();
			while ( results.next() ) {
				JobPositionEntity item = new JobPositionEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< JobPositionEntity > findAll() throws JobPositionException {

		final List< JobPositionEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name, description from job_position ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				JobPositionEntity item = new JobPositionEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, JobPositionEntity record ) throws JobPositionException {

		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new JobPositionException( " JobPosition is required." ).nullJobPositionException();
		}

		int rowsEffected = 0;

		try {
			String query = "update job_position set   code  = ?,   name  = ?,   description  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getName() );
			statement.setString( 3, record.getDescription() );
			statement.setInt( 4, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws JobPositionException {


		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from job_position where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateCodeById( Integer id, String code ) throws JobPositionException {

		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		if ( code == null ) {
			throw new JobPositionException( " code is required." ).nullJobPositionException();
		}

		int rowsEffected = 0;

		try {
			String query = "update job_position set  code  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateNameById( Integer id, String name ) throws JobPositionException {

		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		if ( name == null ) {
			throw new JobPositionException( " name is required." ).nullJobPositionException();
		}

		int rowsEffected = 0;

		try {
			String query = "update job_position set  name  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateDescriptionById( Integer id, String description ) throws JobPositionException {

		if ( id < 0 ) {
			throw new JobPositionException( " JobPosition ID is required." ).requiredFields( "id" );
		}

		if ( description == null ) {
			throw new JobPositionException( " description is required." ).nullJobPositionException();
		}

		int rowsEffected = 0;

		try {
			String query = "update job_position set  description  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws JobPositionException {

		boolean exists = false;
		try {
			String query = "select id, code, name, description from job_position where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< JobPositionEntity > searchByCode( String code ) throws JobPositionException {

		final List< JobPositionEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name, description from job_position where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();

			while ( results.next() ) {
				JobPositionEntity item = new JobPositionEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByCode( String code ) throws JobPositionException {

		boolean exists = false;
		try {
			String query = "select id, code, name, description from job_position where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< JobPositionEntity > searchByName( String name ) throws JobPositionException {

		final List< JobPositionEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name, description from job_position where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();

			while ( results.next() ) {
				JobPositionEntity item = new JobPositionEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByName( String name ) throws JobPositionException {

		boolean exists = false;
		try {
			String query = "select id, code, name, description from job_position where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< JobPositionEntity > searchByDescription( String description ) throws JobPositionException {

		final List< JobPositionEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name, description from job_position where description LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );

			results = statement.executeQuery();

			while ( results.next() ) {
				JobPositionEntity item = new JobPositionEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
				item.setDescription( results.getString( "description" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByDescription( String description ) throws JobPositionException {

		boolean exists = false;
		try {
			String query = "select id, code, name, description from job_position where description LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, description );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new JobPositionException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new JobPositionException( exception.getMessage() );
			}
		}

		return exists;
	}


}
