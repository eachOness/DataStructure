package arithmetic.dac;
/**
 * 汉诺塔问题
 * @author 3288609049
 *
 */
public class Hanoitwer {
	public static void main(String[] args) {
		hanoitwer(2,'A','B','C');
		
	}
	
	public  static  void hanoitwer(int  n,char from ,char in ,char to) {
		
		if(n==1) {
			System.out.println("第1个盘子从"+from+"移动到"+to);
		}else {
			hanoitwer(n-1, from, to, in);
			System.out.println("第"+n+"个盘子从"+from+"移动到"+to  );
			hanoitwer(n-1,in,from,to);
		}
		
	}

}
