package be.intec.repositories;


import be.intec.models.entities.DocumentEntity;
import be.intec.services.exceptions.DocumentException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepository {

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
		for ( final DocumentEntity entity : entities ) {
			rowsDeleted += deleteById( entity.getId() );
		}

		return rowsDeleted;
	}


	public int resetSequence() {

		int rowsEffected = 0;

		try {
			String query = "ALTER TABLE document AUTO_INCREMENT = 0";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;

	}


	public int save( DocumentEntity record ) throws DocumentException {

		int rowsEffected = 0;

		try {
			String query = "insert into document ( name, raw_data, url, last_updated ) values ( ?, ?, ?, ? )";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getName() );
			statement.setLong( 2, record.getRawData() );
			statement.setString( 3, record.getUrl() );
			statement.setTimestamp( 4, record.getLastUpdated() );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public DocumentEntity findById( Integer id ) throws DocumentException {


		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		DocumentEntity item = new DocumentEntity();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where id = ?";
			connection = getConnection();

			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			if ( results.next() ) {
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );
			}
		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return item;
	}


	public List< DocumentEntity > findAllByExample( DocumentEntity example ) throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where name = ? OR raw_data = ? OR url = ? OR last_updated = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, example.getName() );
			statement.setLong( 2, example.getRawData() );
			statement.setString( 3, example.getUrl() );
			statement.setTimestamp( 4, example.getLastUpdated() );

			results = statement.executeQuery();
			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public List< DocumentEntity > findAll() throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document ";
			connection = getConnection();
			statement = connection.prepareStatement( query );

			results = statement.executeQuery();
			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public int updateById( Integer id, DocumentEntity record ) throws DocumentException {

		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		if ( record == null ) {
			throw new DocumentException( " Document is required." ).nullDocumentException();
		}

		int rowsEffected = 0;

		try {
			String query = "update document set   name  = ?,   raw_data  = ?,   url  = ?,   last_updated  = ? where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, record.getName() );
			statement.setLong( 2, record.getRawData() );
			statement.setString( 3, record.getUrl() );
			statement.setTimestamp( 4, record.getLastUpdated() );
			statement.setInt( 5, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int deleteById( Integer id ) throws DocumentException {


		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		int rowsEffected = 0;

		try {
			String query = "delete from document where id = ? ";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			rowsEffected = statement.executeUpdate();
		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateNameById( Integer id, String name ) throws DocumentException {

		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		if ( name == null ) {
			throw new DocumentException( " name is required." ).nullDocumentException();
		}

		int rowsEffected = 0;

		try {
			String query = "update document set  name  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateRawDataById( Integer id, Long rawData ) throws DocumentException {

		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		if ( rawData == null ) {
			throw new DocumentException( " rawData is required." ).nullDocumentException();
		}

		int rowsEffected = 0;

		try {
			String query = "update document set  raw_data  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setLong( 1, rawData );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateUrlById( Integer id, String url ) throws DocumentException {

		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		if ( url == null ) {
			throw new DocumentException( " url is required." ).nullDocumentException();
		}

		int rowsEffected = 0;

		try {
			String query = "update document set  url  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, url );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public int updateLastUpdatedById( Integer id, java.sql.Timestamp lastUpdated ) throws DocumentException {

		if ( id < 0 ) {
			throw new DocumentException( " Document ID is required." ).requiredFields( "id" );
		}

		if ( lastUpdated == null ) {
			throw new DocumentException( " lastUpdated is required." ).nullDocumentException();
		}

		int rowsEffected = 0;

		try {
			String query = "update document set  last_updated  = ? where id = ?";

			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, lastUpdated );
			statement.setInt( 2, id );

			rowsEffected = statement.executeUpdate();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return rowsEffected;
	}


	public boolean existsById( Integer id ) throws DocumentException {

		boolean exists = false;
		try {
			String query = "select id, name, raw_data, url, last_updated from document where id = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setInt( 1, id );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< DocumentEntity > searchByName( String name ) throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();

			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByName( String name ) throws DocumentException {

		boolean exists = false;
		try {
			String query = "select id, name, raw_data, url, last_updated from document where name LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, name );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< DocumentEntity > searchByRawData( Long rawData ) throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where raw_data = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setLong( 1, rawData );

			results = statement.executeQuery();

			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByRawData( Long rawData ) throws DocumentException {

		boolean exists = false;
		try {
			String query = "select id, name, raw_data, url, last_updated from document where raw_data = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setLong( 1, rawData );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< DocumentEntity > searchByUrl( String url ) throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where url LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, url );

			results = statement.executeQuery();

			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByUrl( String url ) throws DocumentException {

		boolean exists = false;
		try {
			String query = "select id, name, raw_data, url, last_updated from document where url LIKE ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setString( 1, url );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return exists;
	}


	public List< DocumentEntity > searchByLastUpdated( java.sql.Timestamp lastUpdated ) throws DocumentException {

		final List< DocumentEntity > itemList = new ArrayList<>();

		try {
			String query = "select id, name, raw_data, url, last_updated from document where last_updated = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, lastUpdated );

			results = statement.executeQuery();

			while ( results.next() ) {
				DocumentEntity item = new DocumentEntity();
				item.setId( results.getInt( "id" ) );
				item.setName( results.getString( "name" ) );
				item.setRawData( results.getLong( "raw_data" ) );
				item.setUrl( results.getString( "url" ) );
				item.setLastUpdated( results.getTimestamp( "last_updated" ) );

				itemList.add( item );
			}

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return itemList;
	}


	public boolean existsByLastUpdated( java.sql.Timestamp lastUpdated ) throws DocumentException {

		boolean exists = false;
		try {
			String query = "select id, name, raw_data, url, last_updated from document where last_updated = ?";
			connection = getConnection();
			statement = connection.prepareStatement( query );
			statement.setTimestamp( 1, lastUpdated );

			results = statement.executeQuery();
			exists = results.next();

		} catch ( SQLException sqlException ) {
			throw new DocumentException( sqlException.getMessage() );
		} finally {
			try {
				if ( statement != null ) {
					statement.close();
				}
				if ( connection != null ) {
					connection.close();
				}
			} catch ( Exception exception ) {
				throw new DocumentException( exception.getMessage() );
			}
		}

		return exists;
	}


}
