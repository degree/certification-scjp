package declarations.interfaces;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:26 AM
 */
//public abstract interface DefaultsForInterface:: do not use abstract by convention
public interface DefaultsForInterface
{
	// do not use modifiers by conventions
	public static final String NOO = "noo";

	String YEP = "yep";

	public abstract void noo();

	void yep();

	public class InternalClass
	{
		public int answer;

		public InternalClass(int answer)
		{
			this.answer = answer;
		}

		public int getAnswer()
		{
			return answer;
		}
	}
}
