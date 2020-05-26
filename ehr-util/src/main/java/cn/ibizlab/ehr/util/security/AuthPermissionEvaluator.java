package cn.ibizlab.ehr.util.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mongodb.QueryBuilder;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.domain.DTOBase;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.domain.MappingBase;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.helper.DEFieldCacheMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
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
     *实体主键标识
     */
    private String keyFieldTag="keyfield";

    @Resource
    @Lazy
    private MongoTemplate mongoTemplate;

    /**
     * 批处理权限检查[createBatch:updateBatch:removeBatch]
     * @param authentication
     * @param DEAction
     * @param params
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object DEAction, Object params) {

        //未开启权限校验、超级管理员则不进行权限检查
        if(AuthenticationUser.getAuthenticationUser().getSuperuser()==1  || !enablePermissionValid)
            return true;
        List paramList = (ArrayList) params;
        String deStorageMode= (String) paramList.get(0);
        String action=String.valueOf(DEAction);
        List<String> ids=null;
        EntityBase entity;
        List<EntityBase> entityList = null;
        MappingBase mappingBase= (MappingBase) paramList.get(1);
        //参数准备
        if(action.equalsIgnoreCase("remove")){
            entity= (EntityBase) mappingBase.toDomain(paramList.get(2));
            ids= (List<String>) paramList.get(3);
        }
        else{
            List<DTOBase> dtoList = (List<DTOBase>) paramList.get(2);
            if(dtoList.size()==0)
                return false;
            entityList =mappingBase.toDomain(dtoList);
            entity = (EntityBase) mappingBase.toDomain(dtoList.get(0));
        }
        if (entity==null)
            return false;

        Set<String> entityDataRange = getAuthorities(authentication,entity.getClass().getSimpleName(),action);
        if(entityDataRange.size()==0)
            return false;

        //拥有全部数据访问权限时，则跳过权限检查
        if(isAllData(action,entityDataRange)){
            return true;
        }
        if(action.equalsIgnoreCase("create")){
            return createBatchActionPermissionValid(entityList,entityDataRange);
        }
        else if(action.equalsIgnoreCase("save")){
            return saveBatchActionPermissionValid(deStorageMode, entityList, entityDataRange);
        }
        else{
            if(!action.equalsIgnoreCase("remove")){
                ids=getIds(entity,entityList);
            }
            if(ids.size()==0)
                return false;
            return otherBatchActionPermissionValidRouter(deStorageMode, entity ,ids, entityDataRange);
        }
    }

    /**
     * 实体行为权限检查 ：用于检查当前用户是否拥有实体的新建、编辑、删除权限
     *
     * @param authentication
     * @param id         当前操作数据的主键
     * @param action         当前操作行为：如：[READ、UPDATE、DELETE]
     * @param params         相关参数
     * @return true/false true则允许当前行为，false拒绝行为
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable id, String action, Object params) {

        //未开启权限校验、超级管理员则不进行权限检查
        if(AuthenticationUser.getAuthenticationUser().getSuperuser()==1  || !enablePermissionValid)
            return true;

        List paramList = (ArrayList) params;
        String deStorageMode= (String) paramList.get(0);
        MappingBase mappingBase= (MappingBase) paramList.get(1);
        DTOBase dtoBase = (DTOBase) paramList.get(2);
        EntityBase entity = (EntityBase) mappingBase.toDomain(dtoBase);

        if (StringUtils.isEmpty(entity))
            return false;

        Set<String> entityDataRange = getAuthorities(authentication,entity.getClass().getSimpleName(),action);

        if(entityDataRange.size()==0)
            return false;

        //拥有全部数据访问权限时，则跳过权限检查
        if(isAllData(action,entityDataRange)){
            return true;
        }

        if(action.equalsIgnoreCase("save")){
            Map<String,String> permissionField=getPermissionField(entity);
            String keyFieldName=permissionField.get(keyFieldTag);
            Object srfKey=entity.get(keyFieldName);
            if(ObjectUtils.isEmpty(srfKey))
                action="create";
            else
                action="update";
        }
        if(action.equalsIgnoreCase("create")){
            return createActionPermissionValid(entity,entityDataRange);
        }
        else{
            return otherActionPermissionValidRouter(deStorageMode, entity, id, entityDataRange);
        }
    }

    /**
     * 获取用户权限资源
     * @param authentication
     * @param entityName
     * @param action
     * @return
     */
    private Set<String> getAuthorities(Authentication authentication,String entityName,String action){
        Collection authorities=authentication.getAuthorities();
        Set<String> entityDataRange = new HashSet();
        Iterator var2 = authorities.iterator();

        while(var2.hasNext()) {
            GrantedAuthority authority = (GrantedAuthority)var2.next();
            if(authority.getAuthority().contains(String.format("%s-%s-",entityName,action)))
                entityDataRange.add(authority.getAuthority());
        }
        return entityDataRange;
    }

    /**
     * 批save校验
     * @param deStorageMode
     * @param entityList
     * @param entityDataRange
     * @return
     */
    private boolean saveBatchActionPermissionValid(String deStorageMode, List<EntityBase> entityList, Set<String> entityDataRange) {

        if(entityList==null || entityList.size()==0)
            return false;
        EntityBase tempEntity=entityList.get(0);
        Map<String,String> permissionField=getPermissionField(tempEntity);
        String keyFieldName=permissionField.get(keyFieldTag);
        List createList=new ArrayList();
        List<String> updateList =new ArrayList();

        for(EntityBase entity : entityList){
            Object id = entity.get(keyFieldName);
            if(ObjectUtils.isEmpty(id))
                createList.add(entity);
            else
                updateList.add(String.valueOf(id));
        }
        if(updateList.size()>0){
            boolean isUpdate = otherBatchActionPermissionValidRouter(deStorageMode, tempEntity ,updateList, entityDataRange);
            if(!isUpdate)
                return false;
        }
        if(createList.size()>0){
            boolean isCreate=createBatchActionPermissionValid(entityList,entityDataRange);
            if(!isCreate)
                return false;
        }
        return true;
    }

    /**
     * 批处理新建权限校验
     * @param entityList
     * @param entityDataRange
     * @return
     */
    private boolean createBatchActionPermissionValid(List<EntityBase> entityList,Set<String> entityDataRange){
        for(EntityBase entity : entityList){
            boolean isCreate = createActionPermissionValid(entity ,entityDataRange);
            if(!isCreate){
                return false;
            }
        }
        return true;
    }

    /**
     * 批处理行为权限校验[get:update:delete]
     * @param deStorageMode
     * @param entity
     * @param ids
     * @param entityDataRange
     * @return
     */
    private boolean otherBatchActionPermissionValidRouter(String deStorageMode , EntityBase entity , List<String> ids , Set<String> entityDataRange){

        if(deStorageMode.equalsIgnoreCase("sql")){
            return sqlBatchPermissionValid(entity ,ids, entityDataRange);
        }
        else if(deStorageMode.equalsIgnoreCase("nosql")){
            return noSqlBatchPermissionValid(entity, ids , entityDataRange);
        }
        else if(deStorageMode.equalsIgnoreCase("serviceapi")){
            return true;
        }
        else {
            throw new RuntimeException(String.format("未能识别实体对应存储模式[%s]",deStorageMode));
        }
    }

    /**
     * SQL批处理权限校验
     * @param entity
     * @param ids
     * @param entityDataRange
     * @return
     */
    private boolean sqlBatchPermissionValid(EntityBase entity , List<String> ids,  Set<String> entityDataRange){

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String keyFieldName=permissionField.get(keyFieldTag);
        ServiceImpl service= SpringContextHolder.getBean(String.format("%s%s",entity.getClass().getSimpleName(),"ServiceImpl"));//获取实体service对象
        //通过权限表达式来获取sql
        String permissionSQL= String.format(" (%s) AND ( %s in (%s) ) ",getPermissionSQL(entity,entityDataRange),keyFieldName,getEntityKeyCond(ids)); //拼接权限条件-编辑
        //执行sql进行权限检查
        QueryWrapper permissionWrapper=getPermissionWrapper(permissionSQL);//构造权限条件
        List list=service.list(permissionWrapper);
        if(list.size() == ids.size()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * NoSQL批处理权限校验
     * @param entity
     * @param ids
     * @param entityDataRange
     * @return
     */
    private boolean noSqlBatchPermissionValid(EntityBase entity, List<String> ids,  Set<String> entityDataRange) {

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String keyFieldName=permissionField.get(keyFieldTag);
        //根据权限表达式填充权限条件
        QueryBuilder permissionCond=getNoSqlPermissionCond(entity,entityDataRange);
        //权限条件拼接主键
        permissionCond.and(keyFieldName).in(ids);
        //执行权限检查
        Query query = new BasicQuery(permissionCond.get().toString());
        List list=mongoTemplate.find(query,entity.getClass());
        if(list.size()==ids.size()){
            return true;
        }
        else{
            return false;
        }
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
     * 新建行为校验
     * @param entity
     * @param entityDataRange
     * @return
     */
    private boolean createActionPermissionValid(EntityBase entity, Set<String> entityDataRange){

        boolean isCreate=true;
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

        for(String permissionCond:entityDataRange){
            if(permissionCond.endsWith("curorg")){   //本单位
                userOrg.add(authenticationUser.getOrgid());
            }
            else if(permissionCond.endsWith("porg")){//上级单位
                userOrg.addAll(orgParent);
            }
            else if(permissionCond.endsWith("sorg")){//下级单位
                userOrg.addAll(orgChild);
            }
            else if(permissionCond.endsWith("curorgdept")){//本部门
                userOrgDept.add(authenticationUser.getMdeptid());
            }
            else if(permissionCond.endsWith("porgdept")){//上级部门
                userOrgDept.addAll(orgDeptParent);
            }
            else if(permissionCond.endsWith("sorgdept")){//下级部门
                userOrgDept.addAll(orgDeptChild);
            }
        }

        if(!ObjectUtils.isEmpty(orgFieldValue) && !userOrg.contains(orgFieldValue)){
            return false;
        }
        if(!ObjectUtils.isEmpty(orgDeptFieldValue) && !userOrgDept.contains(orgDeptFieldValue)){
            return false;
        }
        if(!ObjectUtils.isEmpty(crateManFieldValue) && !crateManFieldValue.equals(authenticationUser.getUserid())){
            return false;
        }

        return isCreate;
    }

    /**
     * 根据实体存储模式，进行鉴权
     * @param deStorageMode
     * @param entity
     * @param id
     * @param entityDataRange
     * @return
     */
    private boolean otherActionPermissionValidRouter(String deStorageMode, EntityBase entity , Object id , Set<String> entityDataRange){

        if(deStorageMode.equalsIgnoreCase("sql")){
            return sqlPermissionValid(entity , id, entityDataRange);
        }
        else if(deStorageMode.equalsIgnoreCase("nosql")){
            return noSqlPermissionValid(entity , id, entityDataRange);
        }
        else if(deStorageMode.equalsIgnoreCase("serviceapi")){
            return true;
        }
        else {
            throw new RuntimeException(String.format("未能识别[%s]实体对应存储模式[%s]",entity.getClass().getSimpleName(),deStorageMode));
        }
    }

    /**
     * sql存储模式实体行为鉴权
     * @param entity
     * @param id
     * @param entityDataRange
     * @return
     */
    private boolean sqlPermissionValid(EntityBase entity , Object id, Set<String> entityDataRange){

        ServiceImpl service= SpringContextHolder.getBean(String.format("%s%s",entity.getClass().getSimpleName(),"ServiceImpl"));//获取实体service对象
        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        //通过权限表达式来获取sql
        String permissionSQL= String.format(" (%s) AND (%s='%s')",getPermissionSQL(entity,entityDataRange),permissionField.get(keyFieldTag),id); //拼接权限条件-编辑
        //执行sql进行权限检查
        QueryWrapper permissionWrapper=getPermissionWrapper(permissionSQL);//构造权限条件
        List list=service.list(permissionWrapper);
        if(list.size()>0){
            return true;
        }else{
            return false;
        }

    }

    /**
     * NoSQL实体行为鉴权
     * @param entity
     * @param id
     * @param entityDataRange
     * @return
     */
    private boolean noSqlPermissionValid(EntityBase entity, Object id, Set<String> entityDataRange) {

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String keyField=permissionField.get(keyFieldTag);
        //根据权限表达式填充权限条件
        QueryBuilder permissionCond=getNoSqlPermissionCond(entity,entityDataRange);
        //权限条件拼接主键
        permissionCond.and(keyField).is(id);
        //执行权限检查
        Query query = new BasicQuery(permissionCond.get().toString());
        List list=mongoTemplate.find(query,entity.getClass());
        if(list.size()>0){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * 为NoSQL存储模式的表格查询填充权限条件
     * @param entity
     * @param entityDataRange
     * @return
     */
    private QueryBuilder getNoSqlPermissionCond( EntityBase entity ,Set<String> entityDataRange){

        QueryBuilder permissionSQL=new QueryBuilder();
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

        for(String permissionCond:entityDataRange){
            if(permissionCond.endsWith("curorg")){   //本单位
                permissionSQL.or(new QueryBuilder().and(orgField).is(AuthenticationUser.getAuthenticationUser().getOrgid()).get());
            }
            else if(permissionCond.endsWith("porg")){//上级单位
                permissionSQL.or(new QueryBuilder().and(orgField).in(formatStringArr(orgParent)).get());
            }
            else if(permissionCond.endsWith("sorg")){//下级单位
                permissionSQL.or(new QueryBuilder().and(orgField).in(formatStringArr(orgChild)).get());
            }
            else if(permissionCond.endsWith("createman")){//建立人
                permissionSQL.or(new QueryBuilder().and(createManField).is(AuthenticationUser.getAuthenticationUser().getUserid()).get());
            }
            else if(permissionCond.endsWith("curorgdept")){//本部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).is(AuthenticationUser.getAuthenticationUser().getMdeptid()).get());
            }
            else if(permissionCond.endsWith("porgdept")){//上级部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).in(formatStringArr(orgDeptParent)).get());
            }
            else if(permissionCond.endsWith("sorgdept")){//下级部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).in(formatStringArr(orgDeptChild)).get());
            }
            else if(permissionCond.endsWith("all")){
                permissionSQL.or(new QueryBuilder().get());
            }
        }

        return permissionSQL;
    }

    /**
     * SQL获取权限条件
     * @param entity
     * @param entityDataRange
     * @return
     */
    private String  getPermissionSQL(EntityBase entity, Set<String> entityDataRange){

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String nPermissionSQL = "1<>1";
        String orgField=permissionField.get("orgfield");
        String orgDeptField=permissionField.get("orgsecfield");
        String createManField=permissionField.get("createmanfield");
        StringBuffer permissionSQL=new StringBuffer();
        AuthenticationUser authenticationUser = AuthenticationUser.getAuthenticationUser();
        Map<String, Set<String>> userInfo = authenticationUser.getOrgInfo();
        Set<String> orgParent = userInfo.get("parentorg");
        Set<String> orgChild = userInfo.get("suborg");
        Set<String> orgDeptParent = userInfo.get("parentdept");
        Set<String> orgDeptChild = userInfo.get("subdept");

        for(String permissionCond: entityDataRange){
            permissionSQL.append("OR");
            if(permissionCond.endsWith("curorg")){   //本单位
                permissionSQL.append(String.format("(%s='%s')",orgField,AuthenticationUser.getAuthenticationUser().getOrgid()));
            }
            else if(permissionCond.endsWith("porg")){//上级单位
                permissionSQL.append(String.format(" %s in(%s) ", orgField, formatStringArr(orgParent)));
            }
            else if(permissionCond.endsWith("sorg")){//下级单位
                permissionSQL.append(String.format(" %s in(%s) ", orgField, formatStringArr(orgChild)));
            }
            else if(permissionCond.endsWith("createman")){//建立人
                permissionSQL.append(String.format("(%s='%s')",createManField,AuthenticationUser.getAuthenticationUser().getUserid()));
            }
            else if(permissionCond.endsWith("curorgdept")){//本部门
                permissionSQL.append(String.format("(%s='%s')",orgDeptField,AuthenticationUser.getAuthenticationUser().getMdeptid()));
            }
            else if(permissionCond.endsWith("porgdept")){//上级部门
                permissionSQL.append(String.format(" %s in (%s) ", orgDeptField, formatStringArr(orgDeptParent)));
            }
            else if(permissionCond.endsWith("sorgdept")){//下级部门
                permissionSQL.append(String.format(" %s in (%s) ", orgDeptField, formatStringArr(orgDeptChild)));
            }
            else if(permissionCond.endsWith("all")){//全部数据
                permissionSQL.append("(1=1)");
            }
            else{
                permissionSQL.append(nPermissionSQL);
            }
        }
        if(StringUtils.isEmpty(permissionSQL.toString()))
            return "";
        String resultCond=parseResult(permissionSQL, "OR");
        return  resultCond;
    }

    /**
     * 构造 wrapper
     * @param whereCond
     * @return
     */
    private QueryWrapper getPermissionWrapper(String whereCond){

        QueryWrapper permissionWrapper=new QueryWrapper();
        if(!StringUtils.isEmpty(whereCond)){
            permissionWrapper.apply(whereCond);
        }
        return permissionWrapper;
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
        String keyField="";//主键属性

        DEFieldCacheMap.getFieldMap(entityBase.getClass().getName());
        Map <Field, DEField> preFields= SearchDEField(entityBase.getClass().getName()); //从缓存中获取当前类预置属性

        for (Map.Entry<Field,DEField> entry : preFields.entrySet()){
            Field preField=entry.getKey();//获取注解字段
            DEField fieldAnnotation=entry.getValue();//获取注解值
            DEPredefinedFieldType prefieldType=fieldAnnotation.preType();
            if(prefieldType==prefieldType.ORGID)//用户配置系统预置属性-组织机构标识
                orgField=preField.getName();
            if(prefieldType==prefieldType.ORGSECTORID)//用户配置系统预置属性-部门标识
                orgDeptField=preField.getName();
            if(fieldAnnotation.isKeyField())//用户配置系统预置属性-部门标识
                keyField=preField.getName();
        }
        permissionFiled.put("orgfield",orgField);
        permissionFiled.put("orgsecfield",orgDeptField);
        permissionFiled.put("createmanfield",createManField);
        permissionFiled.put("keyfield",keyField);
        return permissionFiled;
    }

    /**
     *获取含有@DEField注解的实体属性
     * @param className do对象类名
     * @return
     */
    private Map <Field, DEField> SearchDEField(String className){

        List<Field> fields =  DEFieldCacheMap.getFields(className);
        Map <Field, DEField> deFieldMap =new HashMap<>();
        for(Field field:fields){
            DEField deField=field.getAnnotation(DEField.class);
            if(!ObjectUtils.isEmpty(deField)) {
                deFieldMap.put(field,deField);
            }
        }
        return deFieldMap;
    }

    /**
     * 转换[a,b]格式字符串到 'a','b'格式
     * @return
     */
    private String formatStringArr(Set<String> array) {

        String[] arr = array.toArray(new String[array.size()]);
        return "'" + String.join("','", arr) + "'";
    }

    /**
     * 格式转换
     * @param cond
     * @param operator
     * @return
     */
    private String parseResult(StringBuffer cond, String operator) {

        String resultCond = cond.toString();
        if (resultCond.startsWith(operator))
            resultCond = resultCond.replaceFirst(operator, "");
        if (resultCond.endsWith(operator))
            resultCond = resultCond.substring(0, resultCond.lastIndexOf(operator));
        return resultCond;
    }


    /**
     * 转换[a,b]格式字符串到 'a','b'格式
     *
     * @return
     */
    private String getEntityKeyCond(List<String> array) {
        String[] arr = array.toArray(new String[array.size()]);
        return "'" + String.join("','", arr) + "'";
    }

    /**
     * 获取实体主键集合
     * @param entityBase
     * @param entityList
     * @return
     */
    private List<String> getIds(EntityBase entityBase ,List<EntityBase> entityList) {

        List<String> entityKeyList=new ArrayList<>();
        Map<String,String> permissionField=getPermissionField(entityBase);//获取组织、部门预置属性
        String keyFieldName=permissionField.get(keyFieldTag);
        if(StringUtils.isEmpty(keyFieldName))
            return entityKeyList;

        for(EntityBase entity: entityList){
            Object objEntityKey = entity.get(keyFieldName);
            if(!ObjectUtils.isEmpty(objEntityKey)){
                entityKeyList.add(String.valueOf(objEntityKey));
            }
        }
        return entityKeyList;
    }

}