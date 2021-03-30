```java

/*
 *一、数组的初始化
 *	
 * */

public class HelloWorld {
	public static void main(String[] args) {
		//System.out.println("HelloWorld!");
		//一维数组的声明和初始化
		int num;//声明
		num =10;//初始化
		int ia = 1001 ;//声明和初始化
		
		int[] ids;//声明 int型后面接数组[]
		//静态初始化:数组的初始化和赋值操作同时进行
		ids = new int[] {1001,1002};//初始化
		//动态初始化：数组的初始化和赋值操作分开进行
		String[] names = new String[5];
		
		//一旦初始化完成，数组长度确定
		//获取数组的长度
		System.out.println(names.length);
		System.out.println(ids.length);
		//数组元素的默认初始化值
		/*
		 * 数组元素的整型：0
		 * 数组元素的浮点型：0.0
		 * 数组元素是char型：0（数字0）
		 * 数组元素是boolean型：false
		 * 
		 * 数组元素是引用类型：null
		*/
		
		//数组的内存解析：new的空间在heap上，int []在栈空间上
		/*
		 * ctrl+shift+回车 空上行
		 * shift＋回车 空下行
		 *	sysout+alt 斜杠 可以直接打出打印语句 
		 * 
		 * 
		 * */
		
		int[] arr = new int[]{1,2,3};
		
		int[][] arr1 = new int[][]{{1,2,3},{4,5},{6,7,8}};
		//动态初始化,长度和赋值不可兼有。
		String[][] arr2 = new String[3][2];
		int[] arr3[] = new int[][] {{1,2},{3,4},{5,6}};
		int[] arr4[][] = {{1,2},{3,4},{5,6}};//类型推断，也是正确的。
		
		
		int[] arr5 = new int[] {1,2,3};
		int[] arr6 = new int[5];
		String[] arr7 = new String[2];
		
		//二维数组：获取二维数组的长度,同C++/C一样
		//规定，二维数组
		/*
		 *初始化一： int[][] arr = new int[4][3];
		 *外层元素初始化值：地址值
		 *内层元素初始化值：与一维初始化情况相同
		 *
		 * 初始化二： int[][] arr = new int[4][];
		 * 外层元素初始化值：null；
		 * 内层元素不能调用，否则报错吧 
		 *
		 */
		
	}
}
```


