package com.test.automation.UIAutomation.CustomListener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	public void transform(ITestAnnotation arg1, Class arg2, Constructor arg3, Method arg4) {
		IRetryAnalyzer retry = arg1.getRetryAnalyzer();
		if(retry == null)
		{
			arg1.setRetryAnalyzer(Retry.class);
		}		
	}
}
