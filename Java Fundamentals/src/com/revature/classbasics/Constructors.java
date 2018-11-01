package com.revature.classbasics;

public class Constructors {

	
	public Constructors(){}		// If no constructor is defined, this exists by default
								// or super(); is always implicit unless otherwise defined
								// As soon as a constructor is defined, the default no longer exists
								// Constructors c = new Constructors();
	public static void main(String[] args) {
//		A c = new C();
		B b = new B();
		System.out.println(b.me);
	}
	
}

// You can have as many classes in one source file as you want, but only 1 can be public
class A{	
	public A(){
		super();					// don't need to explicitly call this
		System.out.println("A()");
	}
}

class B extends A{	
	String me;
	public B(){
		this("I am B");
		System.out.println("B()");
	}
	public B(String me){
		this.me = me;
	}
}

class C extends B{	
	public C(){
		super();
		System.out.println("C()");
	}
}



