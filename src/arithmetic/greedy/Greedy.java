package arithmetic.greedy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * ̰���㷨
 * 
 * @author 3288609049
 *
 */
public class Greedy {

	public static void main(String[] args) {
		HashMap<String, HashSet<String>> hash = new HashMap<>();
		HashSet<String> address1 = new HashSet<>();
		address1.add("����");
		address1.add("�Ϻ�");
		address1.add("���");
		HashSet<String> address2 = new HashSet<>();
		address2.add("����");
		address2.add("����");
		address2.add("����");
		HashSet<String> address3 = new HashSet<>();
		address3.add("�ɶ�");
		address3.add("�Ϻ�");
		address3.add("����");
		HashSet<String> address4 = new HashSet<>();
		address4.add("�Ϻ�");
		address4.add("���");
		HashSet<String> address5 = new HashSet<>();
		address5.add("����");
		address5.add("����");
	 
		
		hash.put("k1", address1);
		hash.put("k2", address2);
		hash.put("k3", address3);
		hash.put("k4", address4);
		hash.put("k5", address5);
	
		
	
	
	
	}

}
