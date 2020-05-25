package arithmetic.greedy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法
 * 
 * @author 3288609049
 *
 */
public class Greedy {

	public static void main(String[] args) {
		HashMap<String, HashSet<String>> hash = new HashMap<>();
		HashSet<String> address1 = new HashSet<>();
		address1.add("北京");
		address1.add("上海");
		address1.add("天津");
		HashSet<String> address2 = new HashSet<>();
		address2.add("广州");
		address2.add("北京");
		address2.add("深圳");
		HashSet<String> address3 = new HashSet<>();
		address3.add("成都");
		address3.add("上海");
		address3.add("杭州");
		HashSet<String> address4 = new HashSet<>();
		address4.add("上海");
		address4.add("天津");
		HashSet<String> address5 = new HashSet<>();
		address5.add("杭州");
		address5.add("大连");
	 
		
		hash.put("k1", address1);
		hash.put("k2", address2);
		hash.put("k3", address3);
		hash.put("k4", address4);
		hash.put("k5", address5);
	
		
	
	
	
	}

}
