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
import cn.ibizlab.ehr.core.common.domain.User;
import cn.ibizlab.ehr.core.common.filter.UserSearchContext;
import cn.ibizlab.ehr.core.common.service.IUserService;

import cn.ibizlab.ehr.util.helper.CachedBeanCopier;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.ehr.core.common.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[用户] 服务对象接口实现
 */
@Slf4j
@Service("UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.ILoginAccountService loginaccountService;

    @Autowired
    @Lazy
    private cn.ibizlab.ehr.core.common.service.logic.IUserCreateRelatedInfoLogic createrelatedinfoLogic;

    private int batchSize = 500;

    @Override
    @Transactional
    public User get(String key) {
        User et = getById(key);
        if(et==null){
            et=new User();
            et.setUserid(key);
        }
        else{
        }
        return et;
    }

    @Override
    public User getDraft(User et) {
        return et;
    }

    @Override
    @Transactional
    public boolean save(User et) {
        if(!saveOrUpdate(et))
            return false;
        return true;
    }

    @Override
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(User et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? this.update(et) : this.create(et);
        }
    }

    @Override
    public void saveBatch(List<User> list) {
        saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean create(User et) {
        if(!this.retBool(this.baseMapper.insert(et)))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        createrelatedinfoLogic.execute(et);
        return true;
    }

    @Override
    public void createBatch(List<User> list) {
        this.saveBatch(list,batchSize);
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
    public boolean update(User et) {
        if(!update(et,(Wrapper) et.getUpdateWrapper(true).eq("userid",et.getUserid())))
            return false;
        CachedBeanCopier.copy(get(et.getUserid()),et);
        createrelatedinfoLogic.execute(et);
        return true;
    }

    @Override
    public void updateBatch(List<User> list) {
        updateBatchById(list,batchSize);
    }

    @Override
    public boolean checkKey(User et) {
        return (!ObjectUtils.isEmpty(et.getUserid()))&&(!Objects.isNull(this.getById(et.getUserid())));
    }



    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<User> searchDefault(UserSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<User> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
        return new PageImpl<User>(pages.getRecords(), context.getPageable(), pages.getTotal());
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


