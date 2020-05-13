package cn.ibizlab.ehr.core.common.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.ehr.core.common.domain.UserDictItem;
import cn.ibizlab.ehr.core.common.filter.UserDictItemSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserDictItemService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserDictItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户词条] 服务对象接口实现
 */
@Slf4j
@Service("UserDictItemServiceImpl")
public class UserDictItemServiceImpl extends ServiceImpl<UserDictItemMapper, UserDictItem> implements IUserDictItemService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserDictCatService userdictcatService;
    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.IUserDictService userdictService;

    private int batchSize = 500;

    @Override
    @Transactional
    public boolean update(UserDictItem et) {
        fillParentData(et);
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userdictitemid",et.getUserdictitemid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserdictitemid()),et);
        return true;
    }

    @Override
    public void updateBatch(List<UserDictItem> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list,batchSize);
    }

    @Override
    public UserDictItem getDraft(UserDictItem et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(UserDictItem et) {
        return (!ObjectUtils.isEmpty(et.getUserdictitemid()))&&(!Objects.isNull(this.getById(et.getUserdictitemid())));
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result=removeById(key);
        return result ;
    }

    @Override
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public UserDictItem get(String key) {
        UserDictItem et = getById(key);
        if(et==null){
            et=new UserDictItem();
            et.setUserdictitemid(key);
        }
        else{
        }
        return et;
    }

    @Override
    @Transactional
    public boolean save(UserDictItem et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(UserDictItem et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<UserDictItem> list) {
        list.forEach(item->fillParentData(item));
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(UserDictItem et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserdictitemid()),et);
        return true;
    }

    @Override
    public void createBatch(List<UserDictItem> list) {
        list.forEach(item->fillParentData(item));
        saveBatch(list,batchSize);
    }


	@Override
    public List<UserDictItem> selectByUserdictcatid(String userdictcatid) {
        return baseMapper.selectByUserdictcatid(userdictcatid);
    }

    @Override
    public void removeByUserdictcatid(String userdictcatid) {
        this.remove(new QueryWrapper<UserDictItem>().eq("userdictcatid",userdictcatid));
    }

	@Override
    public List<UserDictItem> selectByUserdictid(String userdictid) {
        return baseMapper.selectByUserdictid(userdictid);
    }

    @Override
    public void removeByUserdictid(String userdictid) {
        this.remove(new QueryWrapper<UserDictItem>().eq("userdictid",userdictid));
    }


    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<UserDictItem> searchDefault(UserDictItemSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<UserDictItem> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<UserDictItem>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(UserDictItem et){
        //实体关系[DER1N_USERDICTITEM_USERDICTCAT_USERDICTCATID]
        if(!ObjectUtils.isEmpty(et.getUserdictcatid())){
            cn.ibizlab.ehr.core.common.domain.UserDictCat userdictcat=et.getUserdictcat();
            if(ObjectUtils.isEmpty(userdictcat)){
                cn.ibizlab.ehr.core.common.domain.UserDictCat majorEntity=userdictcatService.get(et.getUserdictcatid());
                et.setUserdictcat(majorEntity);
                userdictcat=majorEntity;
            }
            et.setUserdictcatname(userdictcat.getUserdictcatname());
        }
        //实体关系[DER1N_USERDICTITEM_USERDICT_USERDICTID]
        if(!ObjectUtils.isEmpty(et.getUserdictid())){
            cn.ibizlab.ehr.core.common.domain.UserDict userdict=et.getUserdict();
            if(ObjectUtils.isEmpty(userdict)){
                cn.ibizlab.ehr.core.common.domain.UserDict majorEntity=userdictService.get(et.getUserdictid());
                et.setUserdict(majorEntity);
                userdict=majorEntity;
            }
            et.setUserdictname(userdict.getUserdictname());
        }
    }

    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }

}


