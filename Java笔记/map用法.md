

# Map(映射表)

```java
public class MapDemo{
	public static void main(String[] agrs){
        //Map<k,v> k是key，v是value 通过key来找到value,定义时需要为两个泛型变量赋予数据类型，数据类型课相同可不同
		Map<String,String> map = new HashMap<String,String>();//HashMap<k,v>存储数据采用的哈希表结构，元素的存取顺序不能保证一致，但由于要保证key的唯一，不重复，需要重写key的HashCode()方法、equals()方法
   		//LinkedHashMap<k,v> 是HashMap的子类，采用哈希表结构＋链表结构，通过链表结构可以保证元素的存取顺序一致；通过哈希表可以保证key的唯一、不重复

		map.put("星期一","Monday");//将指定的key值和value值关联
         map.put("星期二"，"tuesday")
         map.remove("星期二");//删除key值对应的value值，并返回该value值
		System.out.println(map.get("星期一"));//通过key值拿出value值
        System.out.println(map.get("星期二"));
	}
}

```

