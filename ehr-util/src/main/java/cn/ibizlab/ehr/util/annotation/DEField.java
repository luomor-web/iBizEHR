package cn.ibizlab.ehr.util.annotation;

import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD})
public @interface DEField
{
	/**
	 * 属性名称
	 * @return
	 */
	String name() default "";
	/**
	 * 是否为数据主键
	 * @return
	 */
	boolean isKeyField() default false;
	/**
	 * 默认值
	 * @return
	 */
	String defaultValue() default "";

	/**
	 * 默认值类型
	 * @return
	 */
	DEFieldDefaultValueType defaultValueType() default DEFieldDefaultValueType.NONE;

	/**
	 * 预置属性类型
	 * @return
	 */
	DEPredefinedFieldType preType() default DEPredefinedFieldType.NONE;

		/**
	 * 逻辑删除有效值
	 * @return
	 */
	String logicval() default "";

	/**
	 * 逻辑删除无效值
	 * @return
	 */
	String logicdelval() default "";
}

