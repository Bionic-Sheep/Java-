package com.yyh.exer2;

public class CustomerView {
	/**
	 * 创建最大10个数的客户对象
	 */
	private CustomerList customers = new CustomerList(10);
	
	/**
	 @用途：显示主菜单，相应用户输入，根据用户操作分别调用其他相应的成员方法
	 		以完成客户信息处理
	 */
	public void enterMainMenu() {
		
		boolean isFlag = true;
		do {
			System.out.println("---------------客户信息管理软件--------------");
			System.out.println();
			System.out.println("               1 添 加 客 户");
			System.out.println("               2 修 改 客 户");
			System.out.println("               3 删 除 客 户");
			System.out.println("               4 客 户 列 表");
			System.out.println("               5   退   出 ");
			System.out.println();
			System.out.print("                请选择（1-5）：");
			
			char key = CMUtility.readChar();
			
			switch(key) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				listAllCustomers();
				break;
			case '5':
				System.out.print("确实是否退出（Y/N）：");
				char yn = CMUtility.readChar();
				if(yn == 'Y') {
					isFlag = false;
				}
				break;
			}//switch
			
		}while(isFlag);
	}
	/**
	 * 添加客户
	 */
	public void addNewCustomer() {
		System.out.println("--------------添加客户----------------");
		
		System.out.print("姓名：");
		String name = CMUtility.readString(4);
		
		System.out.print("性别：");
		char sex = CMUtility.readChar();
		
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		
		System.out.print("电话：");
		String phone = CMUtility.readString(15);
		
		System.out.print("邮箱：");
		String email = CMUtility.readString(30);
		
		Customer cust = new Customer(name,sex,age,phone,email);
		boolean isFlag = customers.addCustomer(cust);
		if(isFlag) {
			System.out.println("---------------添加完成-------------");
		}else {
			System.out.println("-----------客戶已滿，添加失败--------");
		}
	}
	/**
	 * 修改客户
	 */
	public void modifyCustomer() {
		System.out.println("---------------修改客户-----------------");
		
		int index = 0;
		Customer cust = null;
		while(true) {
			System.out.print("请选择待修改客户编号（-1退出）：");
			index = CMUtility.readInt();
			if(index == -1) {
				break;
			}else {
				cust = customers.getCustomer(index - 1);
				if(cust == null) {
					System.out.println("无法找到指定客户！");
				}else {
					break;
				}
			}
		}//while
		
		System.out.print("姓名（" + cust.getName() + "): ");
		String name = CMUtility.readString(4, cust.getName());
		
		System.out.print("性别（" + cust.getGender() + "): ");
		char gender = CMUtility.readChar();
		
		System.out.print("年龄（" + cust.getAge() + "): ");
		int age = CMUtility.readInt();
		
		System.out.print("电话（" + cust.getPhone() + "): ");
		String phone = CMUtility.readString(15, cust.getPhone());
		
		System.out.print("郵箱（" + cust.getEmail() + "): ");
		String email = CMUtility.readString(30, cust.getEmail());
		
		//创建新客户，并替换
		Customer cust1 = new Customer(name,gender,age,phone,email);
		
		boolean isFlag = customers.replaceCustomer(index - 1, cust1);
		if(isFlag) {
			System.out.println("-----------------修改完成------------");
		}else {
			System.out.println("-------------未找到指定客户，修改失败-------");
		}
		
	}
	/**
	 * 删除客户
	 */
	public void deleteCustomer() {
		System.out.println("----------删除客户----------");
		
		System.out.print("请选择待删除客户编号（-1退出）：");
		int index = CMUtility.readInt();
		
		boolean isFlag = customers.deleteCustomer(index - 1);
		if(isFlag) {
			System.out.println("------------删除完成--------------");
		}else {
			System.out.println("没有找到指定的客户，无法删除");
		}
	}
	/**
	 * 客户列表
	 */
	private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] custs = customers.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
//            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
            	System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");
    }
	
	public static void main(String[] args) {
		CustomerView test = new CustomerView();
		test.enterMainMenu();
	}
}
