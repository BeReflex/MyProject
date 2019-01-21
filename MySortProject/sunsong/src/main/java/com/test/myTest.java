package com.test;

import com.common.sort;

public class myTest {

	public static void main(String[] args) {
		/**
		 * ==跟equals的区别：
		 * 1、==用于比较引用和比较基本数据类型时具有不同的功能：
		 *    比较基本数据类型，如果两个值相同，则结果为true
		 *    而在比较引用时，如果引用指向内存中的同一对象，结果为true;下面例子中，s1跟s2是相同的，s3跟s4是不一样的
		 * 2、如果两个对象的类型一致，并且内容一致，则返回true,这些类有：java.io.file,java.util.Date,java.lang.string,包装类（Integer,Double等）
		 * s1跟s2是一模一样的,在内存中存储的hash,code value都是一样的
		 */
		 
		 sort sort = new sort();
		 sort sort1 = new sort();
		 sort sort2 = new sort();
		 int myarrary[]= {3,1,41,21,61,9};
		 sort.bubbleSort(myarrary);
		 sort.printArr(myarrary);
		 
		 
		 String s1 = "abc";
		 String s2 = "abc";
		 String s3=new String("abc");
		 String s4=new String("abc");		
		 
		 System.out.println(s1==s2);//true
		 System.out.println(s1==s3);//false
		 System.out.println(s3==s4);//false
		 System.out.println(s1.equals(s2));//true
		 System.out.println(s3.equals(s4));//true

	}

}
