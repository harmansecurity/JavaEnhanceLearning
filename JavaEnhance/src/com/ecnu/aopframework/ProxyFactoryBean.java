package com.ecnu.aopframework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class ProxyFactoryBean {
	Advice advice = null;
	Object target = null;
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object getProxy(){
		Class clazz1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);		
		class MyInvocationHander implements InvocationHandler {
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {

				advice.beforeMethod();
				Object retVal = method.invoke(target, args);
				advice.afterMethod();
				return retVal;
			}
		}
		Object proxy = null;
		//Collection proxy = (Collection)clazz.newInstance();
		try {
			Constructor constructor = clazz1.getConstructor(InvocationHandler.class);
			proxy = constructor.newInstance(new MyInvocationHander());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return proxy;		
	}
}

