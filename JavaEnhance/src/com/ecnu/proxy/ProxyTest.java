package com.ecnu.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		
		System.out.println("--------begin constructors list------------");
		Constructor[] constructors = clazzProxy1.getConstructors();
		for(Constructor constructor : constructors){
			String name = constructor.getName();
			StringBuilder sBuilder = new StringBuilder(name);//单线程的情况下StringBuilder效率高点，线程不安全的
			sBuilder.append('(');
			Class[] clazzParams = constructor.getParameterTypes();
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams != null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());
		}
		
		
		System.out.println("--------begin methods list------------");
		Method[] methods = clazzProxy1.getMethods();
		for(Method method : methods){
			String name = method.getName();
			StringBuilder sBuilder = new StringBuilder(name);//单线程的情况下StringBuilder效率高点，线程不安全的
			sBuilder.append('(');
			Class[] clazzParams = method.getParameterTypes();
			for(Class clazzParam : clazzParams){
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams != null && clazzParams.length != 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder.toString());
		}
		
		System.out.println("--------begin create instance------------");
		Constructor constructor = clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHandler1 implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
		}
		Collection proxy1 = (Collection) constructor.newInstance(new MyInvocationHandler1());
		System.out.println(proxy1);
		proxy1.clear();
		//proxy1.size();
		
		
		
		Collection proxy2 = (Collection)constructor.newInstance(new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		final ArrayList target = new ArrayList();
		
		Collection proxy3 = (Collection) getProxey(target,new MyAdvice());
		proxy3.add("fasdfas");
		proxy3.add("reqwr");
		proxy3.add("fadsf");
		System.out.println(proxy3.size());
		
	}

	private static Object getProxey(final Object target,final Advice advice) {
		Object proxy3 = Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				//new Class[]{Collection.class},
				target.getClass().getInterfaces(),
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						
/*						long beginTime= System.currentTimeMillis();
						Object retVal = method.invoke(target, args);
						long endTime = System.currentTimeMillis();
						System.out.println(method.getName() + " running time of " + (endTime-beginTime));
						return retVal;*/
						advice.beforeMethod(method);
						Object retVal = method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;
					}				
				}
				);
		return proxy3;
	}

}
