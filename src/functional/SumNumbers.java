package functional;

/**
 * User: Eugene Dubrovka
 * Date: 12/20/11
 * Time: 11:29 AM
 */
public abstract class SumNumbers
{
	public static void main(String[] args)
	{
		System.out.println(sum(1, 100));
	}

	private static int sum_internal(final int acc, final int start, final int end)
	{
		return (start < end) ? sum_internal(acc + start, start + 1, end) : acc;
	}

	private static int sum(final int start, final int end)
	{
		return sum_internal(0, start, end);
	}
}
