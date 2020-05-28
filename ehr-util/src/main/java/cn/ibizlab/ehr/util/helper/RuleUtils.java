package cn.ibizlab.ehr.util.helper;


import cn.ibizlab.ehr.util.domain.EntityBase;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class RuleUtils
{
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Object getObj(Object object, String members)
	{
		if(object==null)
			return null;
		Object currentObj = object;
		String[] arrayOfString = members.split("\\.");
		int i = arrayOfString.length;
		for (int j = 0; j < i; ++j)
		{
			String methodName = arrayOfString[j];
			try
			{
				if(currentObj instanceof EntityBase)
				{
					currentObj=((EntityBase) currentObj).get(methodName);
					if (currentObj == null)
						return null;
				}
				else if(currentObj instanceof JSONObject)
				{
					currentObj=((JSONObject) currentObj).get(methodName);
					if (currentObj == null)
						return null;
				}
				else if(currentObj instanceof Map)
				{
					currentObj=((Map) currentObj).get(methodName);
					if (currentObj == null)
						return null;
				}
				else
				{
					Class clazz = currentObj.getClass();
					Method method = null;
					try
					{
						method=clazz.getMethod("get" , new Class[0]);
					}
					catch (Exception e2)
					{
						method=clazz.getDeclaredMethod("get" , new Class[0]);
					}

					currentObj = method.invoke(currentObj,  methodName);
					if (currentObj == null)
						return null;
				}

			}
			catch (Exception e)
			{

				return null;
			}
		}
		return currentObj;
	}


	public static boolean test(Object finalObject,String option,Object exp)
	{
		if(option.equalsIgnoreCase("eq")||option.equalsIgnoreCase("equal")||option.equalsIgnoreCase("="))
			return equal(exp,finalObject);
		else if (option.equalsIgnoreCase("noteq")||option.equalsIgnoreCase("notequal")||option.equalsIgnoreCase("<>")||option.equalsIgnoreCase("!="))
			return !equal(exp,finalObject);
		else if (option.equalsIgnoreCase("gt")||option.equalsIgnoreCase(">"))
			return gt(exp,finalObject);
		else if (option.equalsIgnoreCase("lt")||option.equalsIgnoreCase("<"))
			return lt(exp,finalObject);
		else if (option.equalsIgnoreCase("gtandeq")||option.equalsIgnoreCase("ge")||option.equalsIgnoreCase(">="))
			return ge(exp,finalObject);
		else if (option.equalsIgnoreCase("ltandeq")||option.equalsIgnoreCase("le")||option.equalsIgnoreCase("<="))
			return le(exp,finalObject);
		else if (option.equalsIgnoreCase("null")||option.equalsIgnoreCase("isnull"))
			return isNull(finalObject);
		else if (option.equalsIgnoreCase("notnull")||option.equalsIgnoreCase("isnotnull"))
			return isNotNull(finalObject);
		else if (option.equalsIgnoreCase("like")||option.equalsIgnoreCase("matchor"))
			return matchor(exp,finalObject);
		else if (option.equalsIgnoreCase("leftlike")||option.equalsIgnoreCase("startswith")||option.equalsIgnoreCase("begin"))
			return leftmatchor(exp,finalObject);
		else if (option.equalsIgnoreCase("rightlike")||option.equalsIgnoreCase("endswith")||option.equalsIgnoreCase("end"))
			return rightmatchor(exp,finalObject);
		else if (option.equalsIgnoreCase("match")||option.equalsIgnoreCase("matchand")||option.equalsIgnoreCase("matches"))
			return matchand(exp,finalObject);
		else if (option.equalsIgnoreCase("in"))
			return in(exp,finalObject);
		else if (option.equalsIgnoreCase("notin"))
			return notin(exp,finalObject);
		else if (option.equalsIgnoreCase("NOTLIKE"))
			return notmatchor(exp,finalObject);
		else if (option.equalsIgnoreCase("LEFTNOTLIKE"))
			return !leftmatchor(exp,finalObject);
		else if (option.equalsIgnoreCase("RIGHTNOTLIKE"))
			return !rightmatchor(exp,finalObject);
		else if (option.equalsIgnoreCase("NOTMATCHES"))
			return notmatchand(exp,finalObject);
		else
			return false;
	}


	public static boolean equal(Object exp, Object object, String members)
	{
		return equal(exp,getObj(object, members));
	}
	public static boolean equal(Object exp, Object finalObject)
	{

		if(exp==null)
			return false;
		if(finalObject ==null)
			return false;

		if(exp instanceof String && ((String) exp).length()==10 && finalObject instanceof Timestamp)
		{
			return dateFormat.format(finalObject).equals(exp);
		}
		else if(exp instanceof Timestamp && finalObject instanceof Timestamp)
		{
			return dateFormat.format(finalObject).equals(dateFormat.format(exp));
		}
		else if(finalObject instanceof Timestamp)
		{
			Timestamp tm=DataObject.getTimestampValue(exp,null);
			if(tm == null) return false;
			return ObjectUtils.nullSafeEquals(tm,finalObject);
		}

		if(ObjectUtils.nullSafeEquals(exp,finalObject))
			return true;
		if(exp.toString().equalsIgnoreCase(finalObject.toString()))
			return true;
		return false;
	}

	public static boolean gt(Object exp, Object object, String members)
	{
		return gt(exp,getObj(object, members));
	}
	public static boolean gt(Object exp, Object finalObject)
	{
		if(ObjectUtils.isEmpty(exp))
            return false;
        if(ObjectUtils.isEmpty(finalObject))
            return false;
        try
        {
            if(finalObject instanceof java.sql.Timestamp)
            {

				java.sql.Timestamp finalTime=(java.sql.Timestamp)finalObject;
				Timestamp tm=null;
				if (exp instanceof java.sql.Timestamp)
				{
					tm=(java.sql.Timestamp)exp;
				}
				else
				{
					tm=DataObject.getTimestampValue(exp,null);
					if(tm==null)
						return false;
				}
                return finalTime.getTime()>tm.getTime();
            }
            else if (finalObject instanceof Integer)
            {
                return ((Integer) finalObject) > DataObject.getIntegerValue(exp,Integer.MAX_VALUE);
            }
            else if (finalObject instanceof Double)
            {
                return ((Double) finalObject) > DataObject.getDoubleValue(exp,Double.MAX_VALUE);
            }
            else if (finalObject instanceof Float)
            {
                return ((Float) finalObject) > DataObject.getFloatValue(exp,Float.MAX_VALUE);
            }
			else if (finalObject instanceof BigDecimal)
			{
				return ((BigDecimal) finalObject).compareTo(DataObject.getBigDecimalValue(exp,BigDecimal.valueOf(Double.MAX_VALUE)))>0;
			}
			else if (finalObject instanceof BigInteger)
			{
				return ((BigInteger) finalObject).compareTo(DataObject.getBigIntegerValue(exp,BigInteger.valueOf(Long.MAX_VALUE)))>0;
			}
			else if (finalObject instanceof Long)
			{
				return ((Long) finalObject) > DataObject.getLongValue(exp,Long.MAX_VALUE);
			}
            else if (finalObject instanceof String)
            {
                return finalObject.toString().compareToIgnoreCase(exp.toString())>0;
            }
            else
                return false;
        }
        catch(Exception ex)
        {
            return false;
        }


	}

	public static boolean lt(Object exp, Object object, String members)
	{
		return lt(exp,getObj(object, members));
	}
	public static boolean lt(Object exp, Object finalObject)
	{
		if(ObjectUtils.isEmpty(exp))
            return false;
        if(ObjectUtils.isEmpty(finalObject))
            return false;
        try
        {
            if(finalObject instanceof java.sql.Timestamp)
            {
                java.sql.Timestamp finalTime=(java.sql.Timestamp)finalObject;
				Timestamp tm=null;
				if((exp instanceof String)&& (exp.toString().trim().length()==10))
				{
					tm=new Timestamp(dateFormat.parse(exp.toString().trim()).getTime());
				}
				else if (exp instanceof java.sql.Timestamp)
				{
					tm=(java.sql.Timestamp)exp;
				}
				else
				{
					return false;
				}
                return finalTime.getTime()<tm.getTime();
            }
            else if (finalObject instanceof Integer)
            {
                return (((Integer) finalObject).intValue() < ((Integer)exp).intValue());
            }
            else if (finalObject instanceof Double)
            {
                return (((Double) finalObject).doubleValue() < ((Double)exp).doubleValue());
            }
            else if (finalObject instanceof Float)
            {
                return (((Float) finalObject).floatValue() < ((Float)exp).floatValue());
            }
            else if (finalObject instanceof String)
            {
                return finalObject.toString().compareToIgnoreCase(exp.toString())<0;
            }
            else
                return false;
        }
        catch(Exception ex)
        {
            return false;
        }
	}

	public static boolean ge(Object exp, Object object, String members)
	{
		return ge(exp,getObj(object, members));
	}
	public static boolean ge(Object exp, Object finalObject)
	{
		return (!(lt(exp, finalObject)));
	}

	public static boolean le(Object exp, Object object, String members)
	{
		return le(exp,getObj(object, members));
	}
	public static boolean le(Object exp, Object finalObject)
	{
		return (!(gt(exp, finalObject)));
	}

	public static boolean notin(Object expObj, Object object, String members)
	{
		return notin(expObj,getObj(object, members));
	}
	public static boolean notin(Object expObj, Object finalObject)
	{
		return (!in(expObj,finalObject));
	}
	public static boolean in(Object expObj, Object object, String members)
	{
		return in(expObj,getObj(object, members));
	}
	public static boolean in(Object expObj, Object finalObject)
	{
        if (ObjectUtils.isEmpty(finalObject))
			return false;

		String tvs=expObj.toString().trim();
		if(StringUtils.isEmpty(tvs))
			return false;

        if (finalObject instanceof Integer)
        {
            tvs="i:"+tvs;
        }
        else if (finalObject instanceof String)
        {
            tvs="s:"+tvs;
        }

		List acts = parseTvs(tvs);


		for (Iterator localIterator = acts.iterator(); localIterator.hasNext();)
		{
			Object act = localIterator.next();
			if (equal(act,finalObject))
				return true;
		}

		return false;
	}


	public static boolean isNotNull(Object object, String members)
	{
		return isNotNull(getObj(object, members));
	}
	public static boolean isNotNull(Object finalObject)
	{
		return !isNull(finalObject);
	}

	public static boolean isNull(Object object, String members)
	{
		return isNull(getObj(object, members));
	}
	public static boolean isNull(Object finalObject)
	{
		if(finalObject instanceof String)
			return StringUtils.isEmpty(finalObject.toString().trim());
		return (ObjectUtils.isEmpty(finalObject));
	}


	public static boolean notmatchor(Object expObj, Object object, String members)
	{
		return notmatchor(expObj,getObj(object, members));
	}
	public static boolean notmatchor(Object expObj, Object obj)
	{
		return (!matchor(expObj,obj));
	}

	public static boolean notmatchand(Object expObj, Object object, String members)
	{
		return notmatchand(expObj,getObj(object, members));
	}
	public static boolean notmatchand(Object expObj, Object finalObject)
	{
		return (!matchand(expObj,finalObject));
	}

	public static boolean matchor(Object expObj,Object object,String members)
	{
		return matchor(expObj,getObj(object, members));
	}
	public static boolean matchor(Object expObj, Object obj)
	{
		if(obj==null)
            return false;
		String exp=expObj.toString().trim();
		if(StringUtils.isEmpty(exp))
			return false;
        exp=exp.replace(";", ",");
        exp=exp.replace("；", ",");
        exp=exp.replace("，", ",");
		String[] arr=exp.split(",");
		boolean bRt=false;
		for(String strExp:arr)
		{
			bRt=(obj.toString()).matches("(.*)"+(strExp)+"(.*)");
			if(bRt)
				return true;
		}
		return bRt;
	}

	public static boolean leftmatchor(Object expObj, Object obj)
	{
		if(obj==null)
            return false;
		String exp=expObj.toString().trim();
		if(StringUtils.isEmpty(exp))
			return false;
        exp=exp.replace(";", ",");
        exp=exp.replace("；", ",");
        exp=exp.replace("，", ",");
		String[] arr=exp.split(",");
		boolean bRt=false;
		for(String strExp:arr)
		{
			bRt=obj.toString().matches(strExp+"(.*)");
			if(bRt)
				return true;
		}
		return bRt;
	}

	public static boolean rightmatchor(Object expObj, Object obj)
	{
		if(obj==null)
            return false;
		String exp=expObj.toString().trim();
		if(StringUtils.isEmpty(exp))
			return false;
        exp=exp.replace(";", ",");
        exp=exp.replace("；", ",");
        exp=exp.replace("，", ",");
		String[] arr=exp.split(",");
		boolean bRt=false;
		for(String strExp:arr)
		{
			bRt=obj.toString().matches("(.*)"+strExp);
			if(bRt)
				return true;
		}
		return bRt;
	}

	public static boolean matchand(Object expObj,Object object,String members)
	{
		return matchand(expObj,getObj(object, members));
	}
	public static boolean matchand(Object expObj,Object obj)
	{
		if(obj==null)
            return false;
		if(expObj==null)
			return false;
		String exp=expObj.toString().trim();
		if(StringUtils.isEmpty(exp))
			return false;
		exp=exp.replace(";", ",");
        exp=exp.replace("；", ",");
        exp=exp.replace("，", ",");
		String[] arr=exp.split(",");
		String objstr=obj.toString();
		boolean bRt=true;
		for(String strExp:arr)
		{
			if(strExp.trim().length()==0)
				continue;
			bRt=(obj.toString()).matches("(.*)"+(strExp)+"(.*)");
			if(!bRt)
				return false;
		}
		return bRt;
	}


	private static List<Object> parseTvs(String tvs)
	{
        tvs=tvs.replace(";", ",");
        tvs=tvs.replace("；", ",");
        tvs=tvs.replace("，", ",");
		String[] arrayOfString1;
		int j;
		int k;
        String value;
        String type = "s";
        String values = "";

		String[] tv = tvs.split(":");
        if(tv.length>1)
        {
            type = tv[0];
		    values = tv[1];
        }
        else
        {
            values=tvs;
        }

		List acts = new ArrayList();
		String str1 = type;
		int i = -1;
		switch (str1.hashCode())
		{
		case 105:
			if (str1.equals("i"))
				i = 0;
			break;
		case 115:
			if (str1.equals("s"))
				i = 1;
		}
		switch (i)
		{
		case 0:
			arrayOfString1 = values.split(",");
			j = arrayOfString1.length;
			for (k = 0; k < j; ++k)
			{
				value = arrayOfString1[k];
				acts.add(new Integer(value.trim()));
			}
			break;
		case 1:
			arrayOfString1 = values.split(",");
			j = arrayOfString1.length;
			for (k = 0; k < j; ++k)
			{
				value = arrayOfString1[k];
				acts.add(value.trim());
			}
		}
		return acts;
	}
}