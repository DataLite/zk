/* TestBean.java

	Purpose:
		
	Description:
		
	History:
		Jul 12, 2012, Created by Ian Tsai(Zanyking)

Copyright (C) 2010 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under ZOL in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.cdi;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

/**
 * @author Ian Y.T Tsai(zanyking)
 *
 */
@Named
//@SessionScoped
public class Hello implements Serializable{
	private static final long serialVersionUID = 2251108109482968801L;
	
	@Inject
	Greeting greeting;
	

	
	private String name = this.getClass().toString()+ " : " + System.identityHashCode(this);
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name+ 
		this.getClass().toString()+ " : " + System.identityHashCode(this);
	}
	
	public String sayHello(String yourName){
		System.out.println(">>>>>>>>>>[inside Hello] greeting Bean:"+greeting.getClass()+System.identityHashCode(greeting));
		return greeting.greet(yourName);
	}
	@PostConstruct
	public void init(){
		System.out.println(">>>>>>>>>> @PostConstruct:"+this);
	}
	@PreDestroy
	public void dispose(){
		System.out.println(">>>>>>>>>> @PreDestroy:"+this);
	}
	
}
