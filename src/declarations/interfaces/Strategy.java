package declarations.interfaces;

/**
 * User: Eugene Dubrovka
 * Date: 12/13/11
 * Time: 11:17 AM
 */
public interface Strategy
{
	Strategy DEFAULT_STRATEGY = new Strategy()
	{
		@Override public void doAction()
		{
		}
	};

	void doAction();
}
