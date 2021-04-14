## String常用类方法

```java
int length(); //返回字符串的长度：return value.length

char charAt(int index); //返回某索引处的字符 return value[index]

boolean isEmpty(); //判断是否是空字符串 return value.length == 0

String toLowerCase(); //将String中所有字符转换成小写

String toUpperCase(); //将String中所有字符转换成大写

String trim(); //返回字符串的副本，忽略前面空白和后面空白

boolean equals(Object obj); //比较字符串的内容是否相同

boolean equalslgnoreCase(String anotherString); //比较字符串是否相同，忽略大小写

String concat(String str); //将指定字符串连接到此字符串的结尾。 等价于用“+”

int compareTo(String anotherString); //比较字符串的大小

String substring(int beginIndex); // 返回新的字符串，它是此字符串的从beginIndex开始截取 到最后一个字符串

String subString(int beginIndex, int endIndex); //返回新的字符串，从beginIndex 到 endIndex(不包含) 开始截取的一个字符串

boolean endsWith(String suffix); //测试此字符串是否以指定的后缀结束

boolean startsWith(String suffix); //测试此字符串是否以指定的前缀结束

boolean startsWith(String prefix, int toffset); //测试此字符串从指定索引开始的字符串是否以指定前缀开始

int indexOf(String str); //返回指定字符串在此字符串中第一次出现处的索引

int indexOf(String str, int fromIndex); //返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
//字符串 ---> 基本数据类型、包装类
Integer包装类的public static int parseInt(String s); //可以将“数字”字符串组成的字符串转换成整型
类似的，Byte，Short,Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串转换成相应的基本数据类型
//基本数据类型、包装类
调用String类的public String valueOf(int n);//可将int型转换成字符串
相应的valueOf(byte b);//long l float f double d 将相应类型到字符串的转换
//字符数组 ---> 字符串
String的构造器 String(char[]) 
//字符串 ---> 字符数组
public char[] toCharArray(); //将字符串中的全部字符存放在一个字符数组里
public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin);//将指定索引范围内的字符串存放到数组中
//字节数组 ---> 字符串
String(byte[]);
public byte[] getBytes();
```

## StringBuffer类

​	表示可变的字符序列，对字符串进行增删，此时不会产生新的对象。

```java
StringBuffer append(xxx);//用于进行字符串的拼接

StringBuffer delete(int start, int end); //删除指定位置

StringBuffer replace(int start, int end ,String str); //将指定位置替换成str

StringBuffer insert(int offset,xx);//在指定位置插入xx

StringBuffer reverse();// 把当前字符序列逆转
```

StringBuilder和StringBuffer非常类似，均代表可变的字符序列

​		1.StringBuffer 可变字符序列，效率高，线程不安全

​		2.StringBuffer:可变字符序列，效率低，线程安全

```java
public void test6(){
        long startTime = 0;
        long endTime = 0;

        String text = "";

        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        //开始对比
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 20000; ++i){
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间:" + (endTime - startTime));//StringBuffer的执行时间:4
        startTime = System.currentTimeMillis();
        for(int i = 0; i < 20000; ++i){
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间:" + (endTime - startTime));//StringBuilder的执行时间:2

    }
输出结果：
StringBuffer的执行时间:4
StringBuilder的执行时间:2
```



## JDK8之前的日期时间API

```java
1.java.lang.System类
System类提供的 public static long currentTimeMillis() 用来返回当前时间与1970.1.1.0时0分0秒以毫秒为单位的时间差

2.java.uuil.Date类
    表示特定的瞬间，精确到毫秒
   @Test
    public void test7(){
        Date date = new Date(); 
        System.out.println(date);//输出当前年月日时分秒

       System.out.println(System.currentTimeMillis());//输出毫秒数，用GMT表示
       System.out.println(date.getTime());//输出毫秒数，用GMT表示

       Date date1 = new Date(date.getTime());

       System.out.println(date1.getTime());//输出毫秒数，用GMT表示
       System.out.println(date1.toString());//输出年月日时分秒

    }

3.java.text.SimpleDateFormat类
     @Test
    public void test8(){
        Date date = new Date();//产生一个Date实例
        //产生一个formater格式化的实例
        SimpleDateFormat formater = new SimpleDateFormat();//默认的模式和语言环境创建对象
        System.out.println(formater.format(date));//输出2021/4/14 下午3:50
        //更改格式：该构造方法可以用参数pattern指定的格式创建一个对象，该对象调用format(Date date)方法来格式化时间对象date
        SimpleDateFormat formater2 = new SimpleDateFormat(("yyyy年MM月dd日 EEEHH:mm:ss"));
        System.out.println(formater2.format(date));//输出2021年04月14日 周三15:52:20

        try{
            //实例化一个指定的格式对象：parse(String source)：从给定字符串的开始解析文本，以生成一个日期  
            Date date2 = formater2.parse("2008年08月08日 星期一 08:08:08");
            //将指定日期解析后的格式化按指定的格式输出
            System.out.println(date2.toString());//输出Fri Aug 08 08:08:08 CST 2008
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
4.java.util.Calendar(日历)类
     @Test
    public void test9(){
        //Calendar是一个抽象基类，主用于完成日期字段之间相互操作的功能
        Calendar calendar = Calendar.getInstance();
		//从一个Calendar对象中获取Date对象
        Date date = calendar.getTime();
		//使用给定的Date设置次Calendar的时间
        date = new Date(234234235235L);

        calendar.setTime(date);
        //DAY_OF_DAY，DAY_OF_WEEK表示为时间信息
        calendar.set(Calendar.DAY_OF_MONTH,8);
        System.out.println("当前时间日设置8后，时间是：" + calendar.getTime()); //输出：当前时间日设置8后，时间是：Wed Jun 08 09:03:55 CST 1977
        calendar.add(Calendar.HOUR,2);
        System.out.println("当前时间加2小时后，时间是：" + calendar.getTime());//输出： 当前时间加2小时后，时间是：Wed Jun 08 11:03:55 CST 1977
        calendar.add(Calendar.MONTH,-2);
        System.out.println("当前时间减2个月后，时间是：" + calendar.getTime());//输出： 当前时间减2个月后，时间是：Fri Apr 08 11:03:55 CST 1977
    }
```

