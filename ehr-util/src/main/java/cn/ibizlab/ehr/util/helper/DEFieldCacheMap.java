package cn.ibizlab.ehr.util.helper;


import cn.ibizlab.ehr.util.annotation.DEField;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 实体对象属性缓存类
 */
public class DEFieldCacheMap {

	private static Hashtable<String, Hashtable<String,Field>> cacheMap = new Hashtable<>();

	private static Hashtable<String, List<Field>> cacheList = new Hashtable<>();

	private static Hashtable<String, Hashtable<String,String>> cacheKey = new Hashtable<>();

	private static Hashtable<String, Hashtable<String,DEField>> cacheDEField = new Hashtable<>();

	private static Hashtable<String, String> cacheDEKeyField = new Hashtable<>();

	private static Object objLock1=new Object();

	/**
	 * 将实体对象中的属性存入缓存中
	 * @param
	 * @return
	 */
	public static <T> Hashtable<String,Field> getFieldMap(Class<T> clazz) {
		String className=clazz.getName();
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheMap.containsKey(className))
			return cacheMap.get(className);
		synchronized (objLock1) {
			if(cacheMap.containsKey(className))
				return cacheMap.get(className);
			Hashtable<String,Field> result = new Hashtable<String,Field>();
			List<Field> list=new ArrayList<Field>();
			Hashtable<String,String> keys=new Hashtable<String,String>();
			Hashtable<String,DEField> defields=new Hashtable<>();
			Hashtable<String,String> dekeyfields=new Hashtable<>();
			Field[] fields=clazz.getDeclaredFields();
			for(Field field:fields){
				result.put(field.getName(),field);
				list.add(field);
				keys.put(field.getName().toLowerCase(),field.getName());
				DEField deField=field.getAnnotation(DEField.class);
				if(!ObjectUtils.isEmpty(deField)) {
					defields.put(field.getName(),deField);
					if(deField.isKeyField())
						cacheDEKeyField.put(className,field.getName());
				}
			}
			cacheMap.put(className, result);
			cacheList.put(className,list);
			cacheKey.put(className,keys);
			cacheDEField.put(className,defields);
			return result;
		}
	}
	public static Hashtable<String,Field> getFieldMap(String className) {
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheMap.containsKey(className))
			return cacheMap.get(className);
		Class clazz = null;
		try {
			clazz = Class.forName(className);
			return getFieldMap(clazz);
		}
		catch (Exception ex) {
			cacheMap.put(className, new Hashtable<String,Field>());
			return cacheMap.get(className);
		}
	}

	/**
	 * 从缓存中查询实体对象属性集合
	 * @param
	 * @return
	 */
	public static <T> Hashtable<String,DEField> getDEFields(Class<T> clazz) {
		String className=clazz.getName();
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheDEField.containsKey(className))
			return cacheDEField.get(className);
		else{
			DEFieldCacheMap.getFieldMap(clazz);
			return cacheDEField.get(className);
		}
	}

	/**
	 * 从缓存中查询实体对象主键
	 * @param
	 * @return
	 */
	public static <T> String getDEKeyField(Class<T> clazz) {
		String className=clazz.getName();
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheDEKeyField.containsKey(className))
			return cacheDEKeyField.get(className);
		else{
			DEFieldCacheMap.getFieldMap(clazz);
			return cacheDEKeyField.get(className);
		}
	}


	/**
	 * 从缓存中查询实体对象属性列表
	 * @param
	 * @return
	 */
	public static <T> List<Field> getFields(Class<T> clazz) {
		String className=clazz.getName();
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheList.containsKey(className))
			return cacheList.get(className);
		else{
			DEFieldCacheMap.getFieldMap(clazz);
			return cacheList.get(className);
		}
	}

	public static List<Field> getFields(String className) {
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheList.containsKey(className))
			return cacheList.get(className);
		else{
			DEFieldCacheMap.getFieldMap(className);
			return cacheList.get(className);
		}
	}

	/**
	 * 从缓存中查询实体对象属性列表
	 * @param
	 * @return
	 */
	public static <T> Hashtable<String,String> getFieldKeys(Class<T> clazz) {
		String className=clazz.getName();
		if(className.indexOf("_$")>0)
			className=className.substring(0, className.lastIndexOf("_$"));
		if(cacheKey.containsKey(className))
			return cacheKey.get(className);
		else{
			DEFieldCacheMap.getFieldMap(clazz);
			return cacheKey.get(className);
		}
	}

	public static <T> String getFieldRealName(Class<T> clazz,String fieldname) {
		fieldname=fieldname.toLowerCase();
		Hashtable<String,String> keys=DEFieldCacheMap.getFieldKeys(clazz);
		if(keys.containsKey(fieldname))
			return keys.get(fieldname);
		else if(keys.containsKey(fieldname.replace("_","")))
			return keys.get(fieldname.replace("_",""));
		else
			return "";
	}

	public static <T> Field getField(Class<T> clazz,String fieldname) {
		String fieldRealName=DEFieldCacheMap.getFieldRealName(clazz,fieldname);
		if(!StringUtils.isEmpty(fieldRealName))
			return DEFieldCacheMap.getFieldMap(clazz).get(fieldRealName);
		else
			return null;
	}

	public static  <T> String getFieldColumnName(Class<T> clazz,String fieldname) {
		Field field = DEFieldCacheMap.getField(clazz,fieldname);
		if(field!=null) {
			DEField deField=field.getAnnotation(DEField.class);
			if(deField!=null&& !StringUtils.isEmpty(deField.name()))
				return deField.name();
		}
		return fieldname;
	}

	public static  <T> Object fieldValueOf(Class<T> clazz,String fieldname,Object fieldValue) {
		if(fieldValue==null)
			return null;
		Object resultValue=fieldValue;
		Field field = DEFieldCacheMap.getField(clazz,fieldname);
		if(field!=null) {
			Class<?> type=field.getType();
			resultValue = DataObject.objectValueOf(type,fieldValue);
		}
		return resultValue;
	}


}