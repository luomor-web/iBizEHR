package cn.ibizlab.ehr.util.aspect;

import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.enums.DEFieldDefaultValueType;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.helper.DEFieldCacheMap;
import cn.ibizlab.ehr.util.security.AuthenticationUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 实体属性默认值切面，只有新建（Create）时才会填充默认值
 */
@Aspect
@Order(0)
@Component
public class DEFieldDefaultValueAspect
{
    /**
     * 新建数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.create(..))")
    public void BeforeCreate(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.createBatch(..))")
    public void BeforeCreateBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 更新数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.update(..))")
    public void BeforeUpdate(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.updateBatch(..))")
    public void BeforeUpdateBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 保存数据切入点
     * @param point
     * @throws Exception
     */
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.save(..))")
    public void BeforeSave(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }
    @Before(value = "execution(* cn.ibizlab.ehr.core.*.service.*.saveBatch(..))")
    public void BeforeSaveBatch(JoinPoint point) throws Exception {
        fillDEFieldDefaultValue(point);
    }

    /**
     * 填充属性默认值
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public Object fillDEFieldDefaultValue(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            Object obj = args[0];
            String actionName=joinPoint.getSignature().getName();
            if(obj instanceof EntityBase) {
                Map<String, DEField> deFields = DEFieldCacheMap.getDEFields(obj.getClass());
                AuthenticationUser curUser = AuthenticationUser.getAuthenticationUser();
                String keyField=DEFieldCacheMap.getDEKeyField(obj.getClass());
                if(StringUtils.isEmpty(keyField))
                    return true;
                fillDEField((EntityBase)obj, deFields,actionName,curUser,keyField);
            }
            else if (obj instanceof List) {
                Map<String, DEField> deFields = null;
                AuthenticationUser curUser = null;
                String keyField = "";
                for(Object item:(List)obj) {
                    if(item instanceof EntityBase) {
                        if(deFields==null) {
                            deFields = DEFieldCacheMap.getDEFields(obj.getClass());
                            curUser = AuthenticationUser.getAuthenticationUser();
                            keyField=DEFieldCacheMap.getDEKeyField(obj.getClass());
                            if(StringUtils.isEmpty(keyField))
                                return true;
                        }
                        fillDEField((EntityBase)item, deFields,actionName,curUser,keyField);
                    }
                }
            }
        }
        return true;
    }



    /**
     * 填充系统预置属性
     * @param et   当前实体对象
     */
    private void fillDEField(EntityBase et, Map<String, DEField> deFields, String actionName,AuthenticationUser curUser,String keyField) throws Exception {
        if(deFields.size()==0)
            return ;

        if(actionName.toLowerCase().startsWith("save")) {
            if(ObjectUtils.isEmpty(et.get(keyField)))
                actionName="create";
        }

        for (Map.Entry<String, DEField> entry : deFields.entrySet()) {
            String fieldname=entry.getKey();
            //获取注解
            DEField fieldAnnotation=entry.getValue();
            //获取默认值类型
            DEFieldDefaultValueType deFieldType=fieldAnnotation.defaultValueType();
            //获取属性默认值
            String deFieldDefaultValue = fieldAnnotation.defaultValue();
            //获取预置属性类型
            DEPredefinedFieldType predefinedFieldType = fieldAnnotation.preType();

            //填充系统默认值
            if(actionName.toLowerCase().startsWith("create") && ( deFieldType!= DEFieldDefaultValueType.NONE  ||  (!StringUtils.isEmpty(deFieldDefaultValue)) )){
                fillFieldDefaultValue(fieldname,  deFieldType,  deFieldDefaultValue,  et , curUser) ;
            }
            //填充系统预置属性
            if(predefinedFieldType != DEPredefinedFieldType.NONE){
                fillPreFieldValue( fieldname, predefinedFieldType , et ,actionName ,fieldAnnotation.logicval(),curUser);
            }
        }
    }

    /**
     * 填充属性默认值
     * @param fieldname 实体属性名
     * @param deFieldType 默认值类型
     * @param deFieldDefaultValue 默认值
     * @param et 当前实体对象
     * @throws Exception
     */
    private void fillFieldDefaultValue(String fieldname , DEFieldDefaultValueType deFieldType,String deFieldDefaultValue,EntityBase et ,AuthenticationUser curUser) throws Exception {
        Object fieldValue = et.get(fieldname);
        if(org.springframework.util.ObjectUtils.isEmpty(fieldValue)){
            //填充直接值及其余默认值类型
            if( (deFieldType== DEFieldDefaultValueType.NONE && !StringUtils.isEmpty(deFieldDefaultValue))   || (deFieldType != DEFieldDefaultValueType.NONE) ){
                switch(deFieldType){
                    case SESSION:
                        if(!StringUtils.isEmpty(deFieldDefaultValue)){
                            Object sessionFieldValue = curUser.getSessionParams().get(deFieldDefaultValue.toLowerCase());
                            if(!ObjectUtils.isEmpty(sessionFieldValue)){
                                et.set(fieldname,sessionFieldValue);
                            }
                        }
                        break;
                    case APPLICATION:
                        //暂未实现
                        break;
                    case UNIQUEID:
                        et.set(fieldname,(new AlternativeJdkIdGenerator()).generateId().toString().replace("-", ""));
                        break;
                    case CONTEXT:
                        if(!StringUtils.isEmpty(deFieldDefaultValue)){
                            Object paramFieldValue=et.get(deFieldDefaultValue);
                            if(!ObjectUtils.isEmpty(paramFieldValue)){
                                et.set(fieldname,paramFieldValue);
                            }
                        }
                        break;
                    case PARAM:
                        if(!StringUtils.isEmpty(deFieldDefaultValue)){
                            Object paramFieldValue=et.get(deFieldDefaultValue);
                            if(!ObjectUtils.isEmpty(paramFieldValue)){
                                et.set(fieldname,paramFieldValue);
                            }
                        }
                        break;
                    case OPERATOR:
                        et.set(fieldname,curUser.getUserid());
                        break;
                    case OPERATORNAME:
                        et.set(fieldname,curUser.getPersonname());
                        break;
                    case CURTIME:
                        et.set(fieldname,new Timestamp(new Date().getTime()));
                        break;
                    case APPDATA:
                        //暂未实现
                        break;
                    case NONE:
                        et.set(fieldname,deFieldDefaultValue);
                        break;
                }
            }
        }
    }

    private void fillPreFieldValue(String fieldname ,  DEPredefinedFieldType preFieldType ,EntityBase et , String actionName,String logicValue ,AuthenticationUser curUser) throws Exception {
        Object fieldValue = et.get(fieldname);
        //为预置属性进行赋值
        if( actionName.equalsIgnoreCase("create")||
                preFieldType== DEPredefinedFieldType.UPDATEDATE|| preFieldType== DEPredefinedFieldType.UPDATEMAN||
                preFieldType== DEPredefinedFieldType.UPDATEMANNAME){

            switch(preFieldType){//根据注解给预置属性填充值
                case CREATEMAN:
                    et.set(fieldname,curUser.getUserid());
                    break;
                case CREATEMANNAME:
                    et.set(fieldname,curUser.getPersonname());
                    break;
                case UPDATEMAN:
                    et.set(fieldname,curUser.getUserid());
                    break;
                case UPDATEMANNAME:
                    et.set(fieldname,curUser.getPersonname());
                    break;
                case CREATEDATE:
                    et.set(fieldname,new Timestamp(new Date().getTime()));
                    break;
                case UPDATEDATE:
                    et.set(fieldname,new Timestamp(new Date().getTime()));
                    break;
                case ORGID:
                    if(org.springframework.util.StringUtils.isEmpty(fieldValue))
                        et.set(fieldname,curUser.getOrgid());
                    break;
                case ORGNAME:
                    if(org.springframework.util.StringUtils.isEmpty(fieldValue))
                        et.set(fieldname,curUser.getOrgname());
                    break;
                case ORGSECTORID:
                    if(org.springframework.util.StringUtils.isEmpty(fieldValue))
                        et.set(fieldname,curUser.getMdeptid());
                    break;
                case ORGSECTORNAME:
                    if(org.springframework.util.StringUtils.isEmpty(fieldValue))
                        et.set(fieldname,curUser.getMdeptname());
                    break;
                case LOGICVALID:
                    if(StringUtils.isEmpty(logicValue)){
                        logicValue="1";
                    }
                    et.set(fieldname,logicValue);
                    break;
            }
        }
    }

}
