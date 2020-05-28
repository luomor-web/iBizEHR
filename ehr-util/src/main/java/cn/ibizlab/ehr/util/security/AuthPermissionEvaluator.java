package cn.ibizlab.ehr.util.security;

import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.helper.DEFieldCacheMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.io.Serializable;
import java.util.*;

/**
 * spring security 权限管理类
 * 重写权限控制方法
 */
@Component
public class AuthPermissionEvaluator implements PermissionEvaluator {

    @Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验
    /**
     * 实体行为鉴权
     * @param authentication
     * @param entity
     * @param action
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object entity, Object action) {

        //未开启权限校验、超级管理员则不进行权限检查
        if(AuthenticationUser.getAuthenticationUser().getSuperuser()==1  || !enablePermissionValid)
            return true;

        String strAction=String.valueOf(action);
        Set<String> userAuthorities = getAuthorities(authentication,strAction);
        if(userAuthorities.size()==0)
            return false;

        //拥有全部数据访问权限时，则跳过权限检查
        if(isAllData(strAction,userAuthorities)){
            return true;
        }
        if(entity instanceof  ArrayList){
            List<EntityBase> entities= (List<EntityBase>) entity;
            for(EntityBase entityBase: entities){
                boolean result=actionValid(entityBase, strAction ,userAuthorities);
                if(!result){
                    return false;
                }
            }
        }
        else{
            EntityBase entityBase= (EntityBase) entity;
            return actionValid(entityBase , strAction ,userAuthorities);
        }
        return true;
    }


    @Override
    public boolean hasPermission(Authentication authentication, Serializable id, String action, Object params) {
        return true;
    }

    /**
     * 获取用户权限资源
     * @param authentication
     * @param action
     * @return
     */
    private Set<String> getAuthorities(Authentication authentication , String action){
        Collection authorities=authentication.getAuthorities();
        Set<String> userAuthorities = new HashSet();
        Iterator it = authorities.iterator();
        while(it.hasNext()) {
            GrantedAuthority authority = (GrantedAuthority)it.next();
            if(authority.getAuthority().contains(action))
                userAuthorities.add(authority.getAuthority());
        }
        return userAuthorities;
    }

    /**
     * 是否为全部数据
     * @param action
     * @param entityDataRange
     * @return
     */
    private boolean isAllData(String action , Set<String> entityDataRange) {
        for(String dataRange : entityDataRange ){
            if(dataRange.endsWith(String.format("%s-all",action))){
                return true;
            }
        }
        return false;
    }

    /**
     * 实体行为权限校验
     * @param entity
     * @param userAuthorities
     * @return
     */
    private boolean actionValid(EntityBase entity, String action , Set<String> userAuthorities){

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String orgField=permissionField.get("orgfield");
        String orgDeptField=permissionField.get("orgsecfield");
        String createManField=permissionField.get("createmanfield");
        AuthenticationUser authenticationUser = AuthenticationUser.getAuthenticationUser();
        Map<String, Set<String>> userInfo = authenticationUser.getOrgInfo();
        Set<String> orgParent = userInfo.get("parentorg");
        Set<String> orgChild = userInfo.get("suborg");
        Set<String> orgDeptParent = userInfo.get("parentdept");
        Set<String> orgDeptChild = userInfo.get("subdept");

        Object orgFieldValue=entity.get(orgField);
        Object orgDeptFieldValue=entity.get(orgDeptField);
        Object crateManFieldValue=entity.get(createManField);

        Set<String> userOrg = new HashSet<>();
        Set<String> userOrgDept = new HashSet<>();

        for(String authority:userAuthorities){
            if(authority.endsWith("curorg")){   //本单位
                userOrg.add(authenticationUser.getOrgid());
            }
            else if(authority.endsWith("porg")){//上级单位
                userOrg.addAll(orgParent);
            }
            else if(authority.endsWith("sorg")){//下级单位
                userOrg.addAll(orgChild);
            }
            else if(authority.endsWith("curorgdept")){//本部门
                userOrgDept.add(authenticationUser.getMdeptid());
            }
            else if(authority.endsWith("porgdept")){//上级部门
                userOrgDept.addAll(orgDeptParent);
            }
            else if(authority.endsWith("sorgdept")){//下级部门
                userOrgDept.addAll(orgDeptChild);
            }
        }

        if(action.endsWith("Create") || action.endsWith("Save")){
            if(!ObjectUtils.isEmpty(orgFieldValue) && !userOrg.contains(orgFieldValue))
                return false;
            if(!ObjectUtils.isEmpty(orgDeptFieldValue) && !userOrgDept.contains(orgDeptFieldValue))
                return false;
            if(!ObjectUtils.isEmpty(crateManFieldValue) && !authenticationUser.getUserid().equals(crateManFieldValue))
                return false;

            return true;
        }
        else{
            if(!ObjectUtils.isEmpty(orgFieldValue) && userOrg.contains(orgFieldValue))
                return true;
            if(!ObjectUtils.isEmpty(orgDeptFieldValue) && userOrgDept.contains(orgDeptFieldValue))
                return true;
            if(!ObjectUtils.isEmpty(crateManFieldValue) && authenticationUser.getUserid().equals(crateManFieldValue))
                return true;

            return false;
        }
    }

    /**
     * 获取实体权限字段 orgid/orgsecid
     * @param entityBase
     * @return
     */
    private Map<String,String> getPermissionField(EntityBase entityBase){

        Map<String,String> permissionFiled=new HashMap<>();
        String orgField="orgid";  //组织属性
        String orgDeptField="orgsecid"; //部门属性
        String createManField="createman"; //创建人属性

        DEFieldCacheMap.getFieldMap(entityBase.getClass().getName());
        Map <String, DEField> preFields= DEFieldCacheMap.getDEFields(entityBase.getClass()); //从缓存中获取当前类预置属性

        for (Map.Entry<String,DEField> entry : preFields.entrySet()){
            String fieldName=entry.getKey();//获取注解字段
            DEField fieldAnnotation=entry.getValue();//获取注解值
            DEPredefinedFieldType prefieldType=fieldAnnotation.preType();
            if(prefieldType==prefieldType.ORGID)//用户配置系统预置属性-组织机构标识
                orgField=fieldName;
            if(prefieldType==prefieldType.ORGSECTORID)//用户配置系统预置属性-部门标识
                orgDeptField=fieldName;
            if(prefieldType==prefieldType.CREATEMAN)//用户配置系统预置属性-部门标识
                createManField=fieldName;
        }
        permissionFiled.put("orgfield",orgField);
        permissionFiled.put("orgsecfield",orgDeptField);
        permissionFiled.put("createmanfield",createManField);
        return permissionFiled;
    }
}