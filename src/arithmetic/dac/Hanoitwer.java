package arithmetic.dac;
/**
 * ��ŵ������
 * @author 3288609049
 *
 */
public class Hanoitwer {
	public static void main(String[] args) {
		hanoitwer(2,'A','B','C');
		
	}
	
	public  static  void hanoitwer(int  n,char from ,char in ,char to) {
		
		if(n==1) {
			System.out.println("��1�����Ӵ�"+from+"�ƶ���"+to);
		}else {
			hanoitwer(n-1, from, to, in);
			System.out.println("��"+n+"�����Ӵ�"+from+"�ƶ���"+to  );
			hanoitwer(n-1,in,from,to);
		}
		
	}

}
