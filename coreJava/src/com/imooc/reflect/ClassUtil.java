package com.imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {
	/**
	 * ��ӡ�����Ϣ��������ĳ�Ա��������Ա����(ֻ��ȡ��Ա����)
	 * @param obj �ö������������Ϣ
	 */
	public static void printClassMethodMessage(Object obj){

		Class c = obj.getClass();
		System.out.println(c.getName());

		Method[] ms = c.getMethods();
		for(int i = 0; i < ms.length;i++){
			Class returnType = ms[i].getReturnType();
			System.out.print(returnType.getName()+" ");
			System.out.print(ms[i].getName()+"(");
			Class[] paramTypes = ms[i].getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}

	public static void printFieldMessage(Object obj) {
		Class c = obj.getClass();

		//Field[] fs = c.getFields();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			String fieldName = field.getName();
			System.out.println(typeName+" "+fieldName);
		}
	}

	public static void printConMessage(Object obj){
		Class c = obj.getClass();
		//Constructor[] cs = c.getConstructors();
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			System.out.print(constructor.getName()+"(");

			Class[] paramTypes = constructor.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.println(")");
		}
	}
}
