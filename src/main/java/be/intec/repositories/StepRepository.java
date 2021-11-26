package be.intec.repositories;


import be.intec.models.entities.StepEntity;
import be.intec.services.exceptions.StepException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StepRepository {

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
		for ( final StepEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE step AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( StepEntity record ) throws StepException {

		int rowsEffected = 0;

		try {
			String query = "insert into step ( code, name ) values ( ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getName() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public StepEntity findById( Integer id ) throws StepException {


		if ( id < 0 ) {
			throw new StepException( " Step ID is required." ).requiredFields( "id" );
		}

		StepEntity item = new StepEntity();

		try {
			String query = "select id, code, name from step where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< StepEntity > findAllByExample( StepEntity example ) throws StepException {

		final List< StepEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name from step where code = ? OR name = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getCode() );
			statement.setString( 2, example.getName() );

			results = statement.executeQuery();
			while ( results.next() ) {
				StepEntity item = new StepEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< StepEntity > findAll() throws StepException {

		final List< StepEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name from step ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				StepEntity item = new StepEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, StepEntity record ) throws StepException {

		if ( id < 0 ) {
			throw new StepException( " Step ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new StepException( " Step is required." ).nullStepException();
		}

		int rowsEffected = 0;

		try {
			String query = "update step set   code  = ?,   name  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setString( 2, record.getName() );
			statement.setInt( 3, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws StepException {


		if ( id < 0 ) {
			throw new StepException( " Step ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from step where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateCodeById( Integer id, String code ) throws StepException {

		if ( id < 0 ) {
			throw new StepException( " Step ID is required." ).requiredFields( "id" );
		}

		if ( code == null ) {
			throw new StepException( " code is required." ).nullStepException();
		}

		int rowsEffected = 0;

		try {
			String query = "update step set  code  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateNameById( Integer id, String name ) throws StepException {

		if ( id < 0 ) {
			throw new StepException( " Step ID is required." ).requiredFields( "id" );
		}

		if ( name == null ) {
			throw new StepException( " name is required." ).nullStepException();
		}

		int rowsEffected = 0;

		try {
			String query = "update step set  name  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws StepException {

		boolean exists = false;
		try {
			String query = "select id, code, name from step where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< StepEntity > searchByCode( String code ) throws StepException {

		final List< StepEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name from step where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();

			while ( results.next() ) {
				StepEntity item = new StepEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByCode( String code ) throws StepException {

		boolean exists = false;
		try {
			String query = "select id, code, name from step where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< StepEntity > searchByName( String name ) throws StepException {

		final List< StepEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, name from step where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();

			while ( results.next() ) {
				StepEntity item = new StepEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setName( results.getString( "name" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByName( String name ) throws StepException {

		boolean exists = false;
		try {
			String query = "select id, code, name from step where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new StepException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new StepException( exception.getMessage() );
			}
		}

		return exists;
	}


}
