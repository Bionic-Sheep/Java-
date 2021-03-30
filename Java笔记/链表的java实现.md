# 链表的java实现

链表是一种**递归**的数据结构，或者为空（null）或者指向下一个结点的引用，结点包含一个泛型的元素和下一个引用。

## 构造结点

用**嵌套类**定义结点的抽象数据类型

```java
private class Node{
	Item item;
	Node Next;
}
```

Tip:通过new Node()触发构造函数来创建一个Node类型的对象，调用的结果是一个指向Node对象的引用，实例均被初始化为null。

## 构造链表



```java
//构造含有元素 to be or 的链表，首先为每个元素创造一个结点
Node first = new Node();
Node second = new Node();
Node third = new Node();
//将每个结点的Item域设为所需的值
first.item = "to";
second.item = "be";
third.item = "or";
//然后设置next域来构造链表
first.next = second;
second.next = third;
```

在表头插入/删除结点

```java
//插入结点
//首先用oldFirst指向first结点
Node oldFirst = first;
//再new新节点并用first指向
first = new Node();
//设置新结点中值并链接
first.item = "not";
first.next = oldFirst;

//删除结点
first = first.next;
```

 