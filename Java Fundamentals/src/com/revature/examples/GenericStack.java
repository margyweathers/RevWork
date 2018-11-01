package com.revature.examples;

public class GenericStack<E> {
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	
	public GenericStack(){
	}
	
	public int getSize(){return list.size();}
	public void push(E o){list.add(o);}
	public E pop(){
		E o = list.get(getSize()-1);
		list.remove(getSize()-1);
		return o;
	}	
}
