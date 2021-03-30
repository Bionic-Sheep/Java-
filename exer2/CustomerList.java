package com.yyh.exer2;

public class CustomerList {
	private Customer[] customers;
	private int total = 0;

	
	/**
	 构造器，用来初始化customers数组 
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * @用途：将参数customer添加到数组中最后一个客户对象记录之后
	 * @参数：customer指定要添加的客户对象
	 * @返回：添加成功返回true,false表示数组已满，无法添加
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) return false;
		customers[total++] = customer;
		return true;
	}
	
	/**
	 * @用途：用参数customer替换数组中有index指定的对象
	 * @参数：customer指定替换的新客户对象，index指定所替换对象在数组中的位置，从0开始
	 * @返回：替换成功返回true;false表示索引无效，无法替换
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index > total) return false;
		customers[index] = cust;
		return true;
	}
	
	/**
	 *@用途：从数组中删除参数Index指定索引位置的客户对象记录
	 *@参数：index指定所删除对象在数组中的索引位置，从0开始
	 *@返回：删除成功返回true;false表示索引无效，无法删除
	 */
	public boolean deleteCustomer(int index) {
		if(index < 0 || index > total) return false;
		for(int i = index;i < total - 1; ++i) {
			customers[i] = customers[i+1];
		}
		customers[--total] = null;
		return true;
	}
	/**
	 *@用途：返回数组中记录的所有客户对象
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];//创建对象数组分配内存
		for(int i=0;i<total;++i) { //将当前内存的对象赋值给cust，返回cust
			custs[i] = customers[i];
		}
		return custs;
	}//为啥不能直接返回customers？因为customers数组中存在空元素，如果直接返回会导致空指针异常。是返回customers数组，而不是返回customers里面的元素
	
	/**
	 @用途：返回参数index指定索引位置的客户对象记录
	 @参数：index指定所要获取的客户在数组中的所有位置，从0开始
	 @返回：封装了客户信息的Customer对象
	 */
	public Customer getCustomer(int index) {
		if(index < 0 || index > total) return null;
		return customers[index];
	}
	
	
}
//tttt