// 00 -> 00^00->00
// 01 -> 01^00->01
// 10 -> 10^01->11
// 11 -> 11^01->10
// (^ same 1^1 = 0, 1^0 = 1)
public class GrayCode{
    public List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<>();
    	for(int i = 0; i < 1 << n; i++) res.add(i ^ i>>1);
    	return res;
	}
}