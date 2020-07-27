package xsl.com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
	/*	int a=(int)(Math.random()*9);
		System.out.println(a);*/
		
		List<Integer> b=new ArrayList<>();
		b.add(1);b.add(5);b.add(7);
		List<Integer> c=new ArrayList<>();
		c.add(5);c.add(1);c.add(8);
		
		c.retainAll(b);
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(b);
		System.out.println(b.size());
		
	}

}
