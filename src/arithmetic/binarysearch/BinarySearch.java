package arithmetic.binarysearch;

/**
 * 非递归实现二分法查找
 * 
 * @author 3288609049
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int binarySearch = binarySearch(arr, 2);
		System.out.println(binarySearch);

	}

	public static int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {

				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		return -1;

	}

}
