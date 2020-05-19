package cn.ibizlab.ehr.util.security;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mongodb.QueryBuilder;
import cn.ibizlab.ehr.util.annotation.DEField;
import cn.ibizlab.ehr.util.domain.EntityBase;
import cn.ibizlab.ehr.util.enums.DEPredefinedFieldType;
import cn.ibizlab.ehr.util.filter.QueryBuildContext;
import cn.ibizlab.ehr.util.filter.QueryWrapperContext;
import cn.ibizlab.ehr.util.helper.DEFieldCacheMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
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
     * 实体行为操作标识
     */
    private String DEActionType="DEACTION";
    /**
     * 实体数据集操作标识
     */
    private String DataSetTag="DATASET";
    /**
     *实体主键标识
     */
    private String keyFieldTag="keyfield";

    @Resource
    @Lazy
    private MongoTemplate mongoTemplate;

    /**
     * 表格权限检查 ：用于检查当前用户是否拥有表格数据的读取、删除权限
     *
     * @param authentication
     * @param deAction     表格行为，如：[READ,DELETE]
     * @param gridParam     表格参数，如：当前表格所处实体(EntityName)、表格删除的数据主键(srfkeys)
     * @return true/false true则允许当前行为，false拒绝行为
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object deAction, Object gridParam) {

        //未开启权限校验、超级管理员则不进行权限检查
        if(AuthenticationUser.getAuthenticationUser().getSuperuser()==1  || !enablePermissionValid)
            return true;

        String action = "";
        String deStorageMode;
        if (deAction instanceof String)
            action = (String) deAction;

        if (StringUtils.isEmpty(action))
            return false;

        //获取当前用户权限列表
        JSONObject userPermission= AuthenticationUser.getAuthenticationUser().getPermissionList();

        if(userPermission==null)
            return false;

        List gridParamList = (ArrayList) gridParam;
        if(action.equalsIgnoreCase("remove")){
            //准备参数
            Object srfKey =gridParamList.get(0);
            EntityBase entity = (EntityBase) gridParamList.get(1);
            deStorageMode= (String) gridParamList.get(2);
            String entityName = entity.getClass().getSimpleName();

            //获取实体行为权限信息
            JSONObject permissionList=userPermission.getJSONObject("entities");

            //检查是否有操作权限[create.update.delete.read]
            if(!validDEActionHasPermission(permissionList,entityName,action)){
                return false;
            }
            //检查是否有数据权限
            return deActionPermissionValidRouter(deStorageMode, entity , action , srfKey, permissionList);
        }
        else{
            //准备参数
            Object searchContext=gridParamList.get(0);
            String dataSetName=String.valueOf(gridParamList.get(1));
            EntityBase entity = (EntityBase) gridParamList.get(2);
            deStorageMode= (String) gridParamList.get(3);
            String entityName = entity.getClass().getSimpleName();

            //获取数据集权限信息
            JSONObject permissionList=userPermission.getJSONObject("entities");

            if(StringUtils.isEmpty(entityName)|| StringUtils.isEmpty(dataSetName))
                return false;

            //检查是否有访问数据集的权限
            if(!validDataSetHasPermission(permissionList,entityName,dataSetName)){
                return false;
            }
        }
                return true;
    }


    /**
     * 表单权限检查 ：用于检查当前用户是否拥有表单的新建、编辑、删除权限
     *
     * @param authentication
     * @param srfKey         当前操作数据的主键
     * @param action         当前操作行为：如：[READ、UPDATE、DELETE]
     * @param formParam      表单参数对象
     * @return true/false true则允许当前行为，false拒绝行为
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable srfKey, String action, Object formParam) {

        //未开启权限校验、超级管理员则不进行权限检查
        if(AuthenticationUser.getAuthenticationUser().getSuperuser()==1  || !enablePermissionValid)
            return true;

        List formParamList = (ArrayList) formParam;
        EntityBase  entity = (EntityBase) formParamList.get(0);
        String deStorageMode= (String) formParamList.get(1);

        if (StringUtils.isEmpty(entity))
            return false;

        JSONObject userPermission= AuthenticationUser.getAuthenticationUser().getPermissionList();
        JSONObject permissionList=userPermission.getJSONObject("entities");
        String entityName = entity.getClass().getSimpleName();

        if(action.equalsIgnoreCase("create")){
            return validDEActionHasPermission(permissionList,entityName,action);
        }
        else{
            //拥有全部数据访问权限时，则跳过权限检查
            if(isAllData(permissionList,entityName,action)){
                return true;
            }
            //检查是否有操作权限[create.update.delete.read]
            if(!validDEActionHasPermission(permissionList,entityName,action)){
                return false;
            }
            //检查是否有数据权限
            return deActionPermissionValidRouter(deStorageMode, entity , action , srfKey, permissionList);
        }
    }

    /**
     * 是否为全部数据
     * @param permissionList
     * @param entityName
     * @param action
     * @return
     */
    private boolean isAllData(JSONObject permissionList, String entityName, String action) {

        if(permissionList==null)
            return false;
        if(!permissionList.containsKey(entityName))
            return false;
        JSONObject entity=permissionList.getJSONObject(entityName);
        if(entity.containsKey(action) && entity.getJSONArray(action).contains("ALL"))
            return true;

        return false;
    }

    /**
     * 实体行为权限校验
     * @param userPermission
     * @param entityName
     * @param action
     * userPermission:{"ENTITY":{"DEACTION":{"READ":["CURORG"]},"DATASET":{"Default":["CURORG"]}}}
     * @return
     */
    private boolean validDEActionHasPermission(JSONObject userPermission,String entityName , String action ){

        boolean hasPermission=false;
        if(userPermission==null)
            return false;
        if(!userPermission.containsKey(entityName))
            return false;
        JSONObject entity=userPermission.getJSONObject(entityName);//获取实体
        if(!entity.containsKey(DEActionType))
            return false;
        JSONObject dataRange=entity.getJSONObject(DEActionType);//获取实体行为对应的数据范围
        if(dataRange.containsKey(action)){
            hasPermission=true;
        }
        return hasPermission;
    }

    /**
     * 数据集合权限校验
     * @param userPermission
     * @param entityName
     * @param dataSetName
     * userPermission:{"ENTITY":{"DEACTION":{"READ":["CURORG"]},"DATASET":{"Default":["CURORG"]}}}
     * @return
     */
    private boolean validDataSetHasPermission(JSONObject userPermission,String entityName ,String dataSetName){

        boolean hasPermission=false;
        if(userPermission==null)
            return false;
        if(!userPermission.containsKey(entityName))
            return false;
        JSONObject entity=userPermission.getJSONObject(entityName);//获取实体
        if(!entity.containsKey(DataSetTag))
            return false;
        JSONObject dataSetList=entity.getJSONObject(DataSetTag);//获取数据集
        if(!dataSetList.containsKey(dataSetName))
            return false;
        JSONArray dataRange=dataSetList.getJSONArray(dataSetName);//获取数据范围
        if(dataRange!=null && dataRange.size()>0){
            hasPermission=true;
        }
        return hasPermission;
    }

    /**
     * 根据实体存储模式，进行鉴权
     * @param deStorageMode
     * @param entity
     * @param action
     * @param srfKey
     * @param permissionList
     * @return
     */
    private boolean deActionPermissionValidRouter(String deStorageMode, EntityBase entity , String action , Object srfKey , JSONObject permissionList){

        if(deStorageMode.equalsIgnoreCase("sql")){
            return sqlPermissionValid(entity , action , srfKey, permissionList);
        }
        else if(deStorageMode.equalsIgnoreCase("nosql")){
            return noSqlPermissionValid(entity , action , srfKey, permissionList);
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
     * @param action
     * @param srfKey
     * @param permissionList
     * @return
     */
    private boolean sqlPermissionValid(EntityBase entity , String action , Object srfKey, JSONObject permissionList){

        String entityName=entity.getClass().getSimpleName();
        ServiceImpl service= SpringContextHolder.getBean(String.format("%s%s",entityName,"ServiceImpl"));//获取实体service对象

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String keyField=permissionField.get(keyFieldTag);
        if(StringUtils.isEmpty(keyField)){
            throw new RuntimeException("权限校验失败，请检查当前实体中是否已经配置主键属性!");
        }

        //获取权限表达式[全部数据、本单位、本部门等]
        JSONObject entityObj=permissionList.getJSONObject(entity.getClass().getSimpleName());//获取实体
        JSONObject permissionType= entityObj.getJSONObject(DEActionType);
        JSONArray opprivList=permissionType.getJSONArray(action);//行为：read；insert...
        if(opprivList.size()==0)
            return false;

        //通过权限表达式来获取sql
        String tempPermissionSQL=getPermissionSQL(entity,opprivList);
        String permissionSQL= String.format(" (%s) AND (%s='%s')",tempPermissionSQL,keyField,srfKey); //拼接权限条件-编辑
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
     * @param action
     * @param srfKey
     * @param permissionList
     * @return
     */
    private boolean noSqlPermissionValid(EntityBase entity, String action, Object srfKey, JSONObject permissionList) {

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性

        String keyField=permissionField.get(keyFieldTag);
        if(StringUtils.isEmpty(keyField)){
            throw new RuntimeException("权限校验失败，请检查当前实体中是否已经配置主键属性!");
        }

        //获取权限表达式[全部数据、本单位、本部门等]
        JSONObject entityObj=permissionList.getJSONObject(entity.getClass().getSimpleName());//获取实体
        JSONObject permissionType= entityObj.getJSONObject(DEActionType);
        JSONArray dataRange=permissionType.getJSONArray(action);//行为：read；insert...
        if(dataRange.size()==0)
            return false;

        //根据权限表达式填充权限条件
        QueryBuilder permissionCond=new QueryBuilder();
        fillNoSqlPermissionCond(dataRange,entity,permissionCond);
        //权限条件拼接主键
        permissionCond.and(keyField).is(srfKey);
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
     * @param oppriList
     * @param entity
     * @param permissionSQL
     */
    private void fillNoSqlPermissionCond(JSONArray oppriList, EntityBase entity, QueryBuilder permissionSQL){

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

        for(int i=0;i<oppriList.size();i++){
            String permissionCond=oppriList.getString(i);//权限配置条件
            if(permissionCond.equals("CURORG")){   //本单位
                permissionSQL.or(new QueryBuilder().and(orgField).is(AuthenticationUser.getAuthenticationUser().getOrgid()).get());
            }
            else if(permissionCond.equals("PORG")){//上级单位
                permissionSQL.or(new QueryBuilder().and(orgField).in(formatStringArr(orgParent)).get());
            }
            else if(permissionCond.equals("SORG")){//下级单位
                permissionSQL.or(new QueryBuilder().and(orgField).in(formatStringArr(orgChild)).get());
            }
            else if(permissionCond.equals("CREATEMAN")){//建立人
                permissionSQL.or(new QueryBuilder().and(createManField).is(AuthenticationUser.getAuthenticationUser().getUserid()).get());
            }
            else if(permissionCond.equals("CURORGDEPT")){//本部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).is(AuthenticationUser.getAuthenticationUser().getMdeptid()).get());
            }
            else if(permissionCond.equals("PORGDEPT")){//上级部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).in(formatStringArr(orgDeptParent)).get());
            }
            else if(permissionCond.equals("SORGDEPT")){//下级部门
                permissionSQL.or(new QueryBuilder().and(orgDeptField).in(formatStringArr(orgDeptChild)).get());
            }
            else if(permissionCond.equals("ALL")){
                permissionSQL.or(new QueryBuilder().get());
            }
        }
    }

    /**
     * SQL获取权限条件
     * @param entity
     * @param oppriList
     * @return
     */
    private String  getPermissionSQL(EntityBase entity, JSONArray oppriList){

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

        for(int i=0;i<oppriList.size();i++){
            permissionSQL.append("OR");
            String permissionCond=oppriList.getString(i);//权限配置条件
            if(permissionCond.equals("CURORG")){   //本单位
                permissionSQL.append(String.format("(%s='%s')",orgField,AuthenticationUser.getAuthenticationUser().getOrgid()));
            }
            else if(permissionCond.equals("PORG")){//上级单位
                permissionSQL.append(String.format(" %s in(%s) ", orgField, formatStringArr(orgParent)));
            }
            else if(permissionCond.equals("SORG")){//下级单位
                permissionSQL.append(String.format(" %s in(%s) ", orgField, formatStringArr(orgChild)));
            }
            else if(permissionCond.equals("CREATEMAN")){//建立人
                permissionSQL.append(String.format("(%s='%s')",createManField,AuthenticationUser.getAuthenticationUser().getUserid()));
            }
            else if(permissionCond.equals("CURORGDEPT")){//本部门
                permissionSQL.append(String.format("(%s='%s')",orgDeptField,AuthenticationUser.getAuthenticationUser().getMdeptid()));
            }
            else if(permissionCond.equals("PORGDEPT")){//上级部门
                permissionSQL.append(String.format(" %s in (%s) ", orgDeptField, formatStringArr(orgDeptParent)));
            }
            else if(permissionCond.equals("SORGDEPT")){//下级部门
                permissionSQL.append(String.format(" %s in (%s) ", orgDeptField, formatStringArr(orgDeptChild)));
            }
            else if(permissionCond.equals("ALL")){//全部数据
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

}