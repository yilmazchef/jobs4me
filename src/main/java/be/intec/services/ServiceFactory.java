package be.intec.services;


/**
 * Java code for Bill Pugh Singleton Implementation
 */
public class ServiceFactory
{

	/**
	 * private constructor
	 */
	private ServiceFactory()
	{
	}

	/**
	 * Inner class to provide instance of class
	 */
	private static class JobService
	{

		private static final ThreadLocal< ServiceFactory > INSTANCE = ThreadLocal.withInitial( ServiceFactory::new );
	}

	public static ServiceFactory getInstance()
	{
		return JobService.INSTANCE.get();
	}
}