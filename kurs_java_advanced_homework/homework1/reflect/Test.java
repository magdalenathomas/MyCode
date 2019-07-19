package homework1.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {

		Door obj = new Door();
		
		Class cls = obj.getClass();
		System.out.println("Nazwa klasy: " + cls.getName());
		System.out.println("************************************");
		System.out.println("Nazwy metod zawartych w klasie:");
		Method[] methods = cls.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println("************************************");
		System.out.println("Nazwy pol zawartych w klasie:");
		Field[] pole = cls.getDeclaredFields();
		for (Field field : pole) {
			System.out.println("Nazwa pola " + field.getName());
			System.out.println("Typ pola " + field.getGenericType());
		}
		System.out.println("************************************");
		System.out.println("Interface zawarte w klasie");
		Class[] classInterfaces = cls.getInterfaces();
		for (Class item : classInterfaces) {
			System.out.println(item.getName());
		}
		System.out.println("************************************");
		try {
			Field field = cls.getDeclaredField("color"); //szukanie pola color
			field.setAccessible(true); //ustawienie dostępu do pola
			field.set(obj, "yellow"); //ustawienie wartości pola 
			Method funkcja = cls.getDeclaredMethod("open"); //znalezienie metody open
			funkcja.invoke(obj); //wywolanie tej metody
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException |InvocationTargetException e) {
			e.printStackTrace();
		
		/*try {
			Method method = obj.getClass().getMethod("open", null);
			method.invoke(obj, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}*/
		
	}
	}
}
