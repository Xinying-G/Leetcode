import java.util.Scanner;

public class Interpretion {
	public String StringReverse(String str)
	{
		String reverse = "";
		for(int i = str.length() - 1; i >= 0; i--)
		{
			reverse = reverse + str.charAt(i);
		}
		return reverse;
	}

	// Next Jump OA
	// ASCII-Encoded Strings input string of nums get reversed number and interpret it to string


	public String decoding(String str)
	{
		String reverse = StringReverse(str);
		String decoding = "";
		for(int i = 0; i < reverse.length() -1; i++)
		{
			if(i+2 >  reverse.length()) break;
			String element = reverse.substring(i,i+2);
			int ele = Integer.parseInt(element);
			if(ele == 32)
			{
				decoding = decoding + " ";
				i = i + 1;
			}
			else if(ele >= 65 && ele <= 99)
			{
				decoding = decoding + Character.toString((char) ele);
				i = i +1;
			}
			else
			{
				if(i+3 >  reverse.length()) break;
				element = reverse.substring(i,i+3);
				ele = Integer.parseInt(element);
				decoding = decoding + Character.toString((char) ele);
				i = i +2;
			}

		}

		return decoding;
	}

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String s = reader.next();
		Interpretion decoder = new Interpretion();
		s = decoder.decoding(s);
		System.out.printf(s);
	}
}