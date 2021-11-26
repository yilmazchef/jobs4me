package be.intec.repositories;


import be.intec.models.entities.TestEntity;
import be.intec.services.exceptions.TestException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestRepository {

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
		for ( final TestEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE test AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( TestEntity record ) throws TestException {

		int rowsEffected = 0;

		try {
			String query = "insert into test ( code, duration, max_score ) values ( ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setInt( 2, record.getDuration() );
			statement.setInt( 3, record.getMaxScore() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public TestEntity findById( Integer id ) throws TestException {


		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		TestEntity item = new TestEntity();

		try {
			String query = "select id, code, duration, max_score from test where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< TestEntity > findAllByExample( TestEntity example ) throws TestException {

		final List< TestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, duration, max_score from test where code = ? OR duration = ? OR max_score = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getCode() );
			statement.setInt( 2, example.getDuration() );
			statement.setInt( 3, example.getMaxScore() );

			results = statement.executeQuery();
			while ( results.next() ) {
				TestEntity item = new TestEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< TestEntity > findAll() throws TestException {

		final List< TestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, duration, max_score from test ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				TestEntity item = new TestEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, TestEntity record ) throws TestException {

		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new TestException( " Test is required." ).nullTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update test set   code  = ?,   duration  = ?,   max_score  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getCode() );
			statement.setInt( 2, record.getDuration() );
			statement.setInt( 3, record.getMaxScore() );
			statement.setInt( 4, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws TestException {


		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from test where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateCodeById( Integer id, String code ) throws TestException {

		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		if ( code == null ) {
			throw new TestException( " code is required." ).nullTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update test set  code  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateDurationById( Integer id, Integer duration ) throws TestException {

		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		if ( duration == null ) {
			throw new TestException( " duration is required." ).nullTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update test set  duration  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, duration );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateMaxScoreById( Integer id, Integer maxScore ) throws TestException {

		if ( id < 0 ) {
			throw new TestException( " Test ID is required." ).requiredFields( "id" );
		}

		if ( maxScore == null ) {
			throw new TestException( " maxScore is required." ).nullTestException();
		}

		int rowsEffected = 0;

		try {
			String query = "update test set  max_score  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, maxScore );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws TestException {

		boolean exists = false;
		try {
			String query = "select id, code, duration, max_score from test where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< TestEntity > searchByCode( String code ) throws TestException {

		final List< TestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, duration, max_score from test where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();

			while ( results.next() ) {
				TestEntity item = new TestEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByCode( String code ) throws TestException {

		boolean exists = false;
		try {
			String query = "select id, code, duration, max_score from test where code LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, code );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< TestEntity > searchByDuration( Integer duration ) throws TestException {

		final List< TestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, duration, max_score from test where duration = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, duration );

			results = statement.executeQuery();

			while ( results.next() ) {
				TestEntity item = new TestEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByDuration( Integer duration ) throws TestException {

		boolean exists = false;
		try {
			String query = "select id, code, duration, max_score from test where duration = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, duration );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< TestEntity > searchByMaxScore( Integer maxScore ) throws TestException {

		final List< TestEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, code, duration, max_score from test where max_score = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, maxScore );

			results = statement.executeQuery();

			while ( results.next() ) {
				TestEntity item = new TestEntity();
				item.setId( results.getInt( "id" ) );
				item.setCode( results.getString( "code" ) );
				item.setDuration( results.getInt( "duration" ) );
				item.setMaxScore( results.getInt( "max_score" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByMaxScore( Integer maxScore ) throws TestException {

		boolean exists = false;
		try {
			String query = "select id, code, duration, max_score from test where max_score = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, maxScore );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new TestException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new TestException( exception.getMessage() );
			}
		}

		return exists;
	}


}
