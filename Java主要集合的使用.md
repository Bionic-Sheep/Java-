

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

## Java集合框架概述

​	1.Collection接口：单列数据，定义了存取一组对象的方法的集合

​		List：元素有序，可重复

​		Set：元素无序，不可重复

​	2.Map接口：双列数据，保存具有映射关系“Key-Value"的集合

![image-20210416104132268](C:\Users\yyh\AppData\Roaming\Typora\typora-user-images\image-20210416104132268.png)

![image-20210416104144652](C:\Users\yyh\AppData\Roaming\Typora\typora-user-images\image-20210416104144652.png)

## Collection接口

```java
Collection接口是List、Set和Queue接口的父接口，该接口定义的方法可以操作Set、List、Queue集合
    1.添加
        add(Object obj);//添加单个元素
		addAll(Collection coll);//将集合中的元素全部添加
	2.获取有效元素个数
    	int size();
	3.清空集合
    	void clear();
	4.是否为空集合
     	boolean isEmpty();
	5.是否包含某个元素
        boolean contains(Object obj);//通过元素的equals方法来判断是否是同一个对象
		boolean containsAll(Collection c);//调用元素的equals方法来比较，两个集合元素挨个比较
	6.删除
        boolean remove(Object obj);//通过元素的equals方法来判断是否是要删除的元素，只删除找到的第一个元素
		boolean removeAll(Collection c);//取当前集合的差集
	7.取两个集合的交集
        boolean retainAll(Collection c);//把交集的结构存在当前集合中，不影响c
	8.集合是否相等
        boolean equals(Object obj);
	9.转成对象数组
        Object[] toArray();
	10.获取集合对象的哈希值
        hashCode();
	11.遍历
        iteraor();//返回迭代器对象，用于集合遍历
```

## Iterator迭代器接口

​	Collection接口继承了java.lang.Iterable接口，该接口有一个iterator()方法，那么所有实现了Collection接口的集合类都有一个iterator()方法，用以返回一个实现了Iterator接口的对象

​	Iterator仅用于遍历集合，Iteator本身不提供承装对象的能力，如果需要创建Iterator对象，必须有个被迭代的集合

​	集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前

```java
Iterator接口的方法
    boolean hasNext();//如果有更多的元素
	<E> next(); //返回下一个迭代器元素
	void remove();//通过迭代器移除集合最后一个元素
tip:调用it.next()方法必须调用it.hasNext()进行检测。如果不调用，则抛出异常
    
    //hasNext();判断是否还有下一个元素
    while(iterator.hasNext()){
		//next():1.指针下移 2.将下移以后集合位置上的元素返回
        System.out.println(Iterator.next);
    }

	Iterator接口remove()方法
        Iterator iter = coll.iterator();//回到起点
	while(iter.hasNext()){
        Object obj = iter.next();
        if(obj.equals("Tom")){
            iter.remove();
        }
    }//Iterator可以删除集合的元素，但是遍历过程中通过迭代器对象的remove方法，不是结合对象的remove方法
//如果还未调用next()或在上一次调用next方法之后已经调用了remove方法，再调用remove都会报illegalStateException

//使用foreach循环遍历集合元素
for(Person person : persons){//底层使用Iterator完成操作
    System.out.println(person.getName());
}
```

# 2021.4.17

## LIst接口

List接口：元素有序，可重复，集合中的每个元素都有其对应的顺序索引

```实现类：ArrayList，LinkedList和vector```

List接口方法：

```java
	void add(int index,Object obj);//在index位置插入obj元素
    
    boolean addAll(int index, Colleaction objs);//从index位置开始将objs中的所有元素添加进来

	Object get(int index);//获取指定index位置的元素

	int indexOf(Object obj);//返回obj在集合中首次出现的位置

	int lastIndexOf(Object obj);//返回obj在当前集合中末次出现的位置

	Object remove(int index);//移除指定index位置的元素，并返回该元素

	Object set(int index, Object obj);//设置指定位置index元素为Obj

	List subList(int fromIndex,int toIndex);//返回从fromIndex到toIndex位置的子集合
```

### ArrayList

```java
ArrayList的JDK1.8之前和之后的实现区别?
    JDK1.7:ArrayList像饿汉式，直接创建一个初始容量为10的数组
    JDK1.8:ArrayList像懒汉式，先创建一个容量为0的数组，添加元素后再创建为10的数组
        
Arrays.asList()方法返回值是一个固定长度的List集合
```

### LinkedList

```java
void addFirst(Object obj);
void addLast(Object obj);
Object getFirst();
Object getLast();
Object removeFirst();
Object removeLast();

双向链表，内部没有声明数组，而是定义了Node类型的first和last，用于记录首末元素。同时，定义内部类Node,作为LinkedList中保存数据的基本结构，Node除了保存数据，还定义了两个变量：
    	prev变量记录前一个元素的位置
    	next变量记录下一个元素的位置
```

### Vector

```java
Vector是一个古老的集合：与ArrayList的区别：Vector线程安全
    
void addElement(Object obj);
void insertElementAt(Object obj,int index);
void setElementAt(Object obj,int index);
void removeElement(Object obj);
void removeAllElements();
```

选择List的区别？



```java
将ArrayList作为缺省选择

​	当插入、删除频繁时，选择LinkedList

​	因为Vector比ArrayList慢，尽量避免使用

ArrayList、LinkedList、Vector的异同

​	ArrayList和LInkedList:两者都线程不安全，相对于线程安全的Vector,执行效率高。

​	此外，ArrayList是实现了基于**动态数组**的数据结构，LinkedList基于**链表**的数据结构，对于**随机访问get和set**，ArrayList优于LinkedList，因为LinkedList要移动指针，对于**新增和删除操作add(特指插入)和remove**，LInkedList比较占优势，因为ArrayList要移动数据

ArrayList和Vector的区别

​	Vector和ArrayList几乎是完全相同的，唯一的区别是在于Vector是同步类(synchronized)，属于强同步类。因此开销就比ArrayList要大，访问要慢。
```



## Set接口

Set接口是Collection的子接口，没有提供额外的方法，Set集合不允许包含相同的元素，如果将两个相同元素加入到同一个集合中，添加失败，Set判断两个对象是否相同不是使用==运算符，而是根据**equals方法**

### Hashset：实现类

采用hash算法来存储集合中的元素，存储，查找，删除性能高

特点：

不能保证元素的排列顺序
不是线程安全
集合元素可以是null

判断两个元素相等的标准：可以通过HashCode()方法比较相等，并且两个对象的equals()方法返回值也相等

对于存放在Set容器中的对象，对用的类一定要重写equals()和HashCode(Object obj)方法，已实现对象相等规则

想HashSet添加元素的过程：

-->当想HashSet集合中存入一个元素是，HashSet会调用该对象的hashCode()方法来得到该对象的hashCode值，然后根据hashCode值，通过某种散列函数决定该对象在HashSet底层数组中的存储位置（散列函数与底层数组的长度相计算得到在数组中的下标，并且这种散列函数计算还尽可能保证能均匀存储元素，越是散列分布，该散列函数就设计的越好）

-->如果两个元素的hashCode值相等，则调用equals()方法，如果equals方法结果为true,添加失败；如果为false，那么会保存该元素，但是该数组的位置已经有元素了，那么会通过链表的方式继续链接

-->如果两个元素的equals()方法返回true，但他们的hashCode()返回值不相等，hashSet将会把它们存储在不同位置，依然添加成功
    
    
 重写hashCode()方法的基本原则
    在程序运行时，同一个对象调用hashCode()方法应该返回相同的值
    当两个对象的equals()方法比较返回true时，这两个对象的hashCode()方法的返回值也应相等
    对象中用作equals()方法比较的Field，都应该用来计算hashCode值
    
 重写equals()方法的基本原则



### LinkedHashSet 

​		LinkedHashSet是HashSet的子类

​		LinkedHashSet是根据元素的hashCode值来决定元素的存储位置，但它同时使用双向链表维护元素的次序，这使得元素看起来是以插入顺序保存的

​		不允许集合元素重复

### TreeSet

​		TreeSet是SortedSet接口的实现类，TreeSet可以确保集合元素处于排序状态

​		底层实现是红黑树结构存储数据

​		采用两种排序方法

​		自然排序和定制排序，一般情况TreeSet采用自然排序

​		自然排序

​				向TreeSet中添加元素时，只有第一个元素无须比较compareTo()方法，后面添加的所有元素都会调用compareTo()方法进行比较，因为只有相同类的两个实例彩虹比较大小，所以向TreeSet中添加的应该是同一个类的对象。是否相等的唯一标准：两个对象通过compareTo(Object obj)方法比较返回值。

​		定制排序

​				TreeSet的自然排序要求元素所属的类实现Comparable接口，如果元素所属的类没有实现Comparable接口，或不希望按照升序的方式排列元素或希望按照其他属性大小进行排序，则考虑使用定制排序，通过Comparator接口来实现。需要重写compare(T o1, T o2);还是添加类型相同的元素，判断相等的标准：通过实现Comparator比较两个元素返回了0;

## Map接口

​		用于保存具有映射关旭的数据：Key-Value

|            |      Map      |           |
| :--------: | :-----------: | :-------: |
| Hashtable  |    HashMap    | SortedMap |
| Properties | LinkedHashMap |  TreeMap  |

Map中的Key和Value都可以是任何引用类型的数据

Map中的key用**Set**集合来存放，**不允许重复**，即同一个Map对象所对应的类，必须重写hashCode()和equals()方法

常用String类作为Map的“键”

Key和Value之间存在单向一对一关系，即通过指定的Key总能找到唯一的、确定的Value

Map接口的常用实现类：HashMap、TreeMap、LinkedHashMap和Properties,其中，HashMap是Map接口使用频率最高的实现类

```java
//添加、删除、修改操作
Object put(Object Key, Object value);//将指定Key-Value添加或修改到当前map对象中

void putAll(Map m);//将m中所有的Key-Value对存放到当前map中

Object remove(Object key);//移除指定Key的Key-Value对，并返回value

void clear();//清空当前map中的所有数据

//元素查询的操作
Object get(Object Key);//获取指定Key对应的Value

boolean containsKey(Object Key);//是否包含指定的Key

boolean containsValue(Object value);//是否包含指定value

int size();//返回Map中Key-value对的个数

boolean isEmpty();//判断当前map是否为空

boolean equals(Object obj);//判断当前map和参数对象obj是否相等

//元视图操作的方法
Set KeySet();//返回所有Key构成的set集合

Collection values();//返回所有value构成的Collection集合

Set entrySet();//返回所有Key-value对构成的Set集合
```

```java
@Test
    public void test13(){
        Map<Integer,Integer> map = new HashMap();
        map.put(1,2);
        map.put(2,4);
        System.out.println("map的所有Key：");
        Set Keys = map.keySet();//
        for(Object Key : Keys){
            System.out.println(Key + "->" + map.get(Key));//map的所有Key： 1->2 2->4
        }
        System.out.println("map中所有的value:");
        Collection values = map.values();//value值
        Iterator iter = values.iterator();//迭代器
        while(iter.hasNext()){
            System.out.println(iter.next()); //map中所有的value: 2 4
        }
        System.out.println("map中所有的映射关系");

        Set mappings = map.entrySet();
        for(Object mapping : mappings){
            Map.Entry entry = (Map.Entry) mapping;//map中所有的映射关系 Key是：1value是：2 Key是：2value是：4
            System.out.println("Key是：" + entry.getKey() + "value是：" + entry.getValue());
        }
    }
```

### HashMap

1.允许使用null键和null值，与HashSet一样，不保证映射的顺序

2.Key构成的集合是Set：无序，不可重复。可重写equals和hashcode  value要重写equals

3.Key-Value构成一个entry

4.判断两个Key相等的标准：equals返回true，hashCode值也相等，判断value相等的标准：euqals返回true;

5.**底层实现是数组+链表+红黑树**

```java
//HashMap的底层实现
	HashMap的内部存储结构其实是数组和链表的结合，当实例化一个HashMap时，系统会创建一个长度为Capacity的Entry数组，这个长度在哈希表中被称为容量，在这个数组中可以存放元素的位置，称之为“桶”。每个桶(bucket)中存储一个元素，因此在一个桶中，就有可能生成一个Entry链。新添加的元素作为链表的head
//添加元素的过程：
	想HashMap中添加entry1(Key,value)，首先需要计算entry1中的Key的哈希值（根据Key所在类的HashCode()计算得到），此哈希值经过处理，得到在底层Entry[]数组中要存储的位置i，如果位置i上没有元素，则entry1直接添加成功。如果位置i上存在entry2，则需要通过循环的方法比较entry1中的Key和其他的entry，如果彼此hash值相同，则添加成功，否则继续比较二者的equals，如果为true，则使用entry的value去替换equals为true的entry的value。如果遍历一次后，发现所有的equals返回都为false，则rntry1仍可添加成功，entry指向原有的entry元素
//HashMap的扩容
	当HashMap中的元素越来越多的时候，hash冲突的几率也越来越高，因为数组的长度是固定的，所以为了提高查询效率，对HashMap数组进行扩容，**扩容之后，需要重写计算原数组在新数组中的位置，并放入**
	当HashMap中的元素个数超过数组大小，就进行扩容。
```



### LInkedHashMap

在HashMap的存储结构的基础上，使用了一对双向链表来记录添加元素的顺序

### TreeMap

底层为**红黑树**

自然排序：TreeMap的所有Key必须实现Comparator接口，而且所有的Key应该是同一个类的对象，否则会抛出ClasssCastException

定制排序：创建Treemap时，传入一个Comparator对象，该对象负责对Key进行排序

### Hashtable

线程安全，与HashMap实现原理相同，功能相同，底层均使用哈希表结构

与HashMap不同，Hashtable不允许使用null作为Key和value

与HashMap一样，Hashtable也不能保证其中Key-value对的顺序

判断Key，Value相等的标准与HashMap一样

### Properties

Key,Value都是字符串类型，存取数组时，建议使用setProperty(String Key,String Value)和getProperty(String Key)方法



## Collections工具类

​		Collections是一个操作Set、List和Map等集合的工具类

​		Collections中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作。还提供了对集合对象设置不可变，对集合对象实现同步控制等方法

排序操作：（均为static方法)

```java
//排序操作：（均为static方法)
		reverse(List); 反转List中元素的顺序
        shuffle(List);//对List集合元素进行随机排序
		sort(List);//根据元素的自然顺序对指定List集合元素按升序排序
		sort(List,Comparator);//根据指定的Comparator产生的顺序对List集合元素进行排序
		swap(List,int,int);//将指定List集合中的i处元素和j处元素进行交换
//查找、替换
	Object max(Collection);//根据元素的自然顺序，返回给定集合中的最大元素
	Object max(Collection, Comparator);//根据Comparator指定的顺序，返回给定集合中最大元素
	Object min(Collection);//最小元素
	Object min(Collection, Comparator);//
	
	int frequency(Collection, Object);//返回指定集合中的指定元素的出现次数
	void copy(List dest, List src);//将src中内容复制到dest
	boolean replace(List list, Object oldVal, Object newVal);//使用新值替换List对象的所有旧值
```

