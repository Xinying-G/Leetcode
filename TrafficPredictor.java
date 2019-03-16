// Next Jump OA
// Traffic Predictor n days traffic 4th day traffic = (2(day1 + day2 + day3)%3)
import java.util.Scanner;

public class TrafficPredictor
{
	public int TrafficPredict(int[] LastThreeDays, int n)
	{
		if(n <= 3)
		{
			return LastThreeDays[n-1];
		}
		int[] traffic = LastThreeDays.clone();
		for(int i = 4; i <= n ; i++)
		{

			traffic[(((i%3 -1)+3)%3)] = (2*(traffic[0] + traffic[1] + traffic[2])/3);
		}
		return traffic[(((n%3 -1)+3)%3)];

	}

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		TrafficPredictor predictor = new TrafficPredictor();
		int[] a = {2,3,4};
		int res = predictor.TrafficPredict(a,n);
		System.out.printf("%d",res);
	}
}