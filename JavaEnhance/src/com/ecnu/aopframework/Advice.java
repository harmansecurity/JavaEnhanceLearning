package com.ecnu.aopframework;

import java.lang.reflect.Method;

public interface Advice {
	
	void beforeMethod();
	void afterMethod();
}
