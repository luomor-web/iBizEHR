package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.vac.service.impl.VacSynjcxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.vac.domain.VacSynjcx;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[年休假查询] 自定义服务对象
 */
@Slf4j
@Primary
@Service("VacSynjcxServiceEx")
public class VacSynjcxServiceEx extends VacSynjcxServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[JSTS]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public VacSynjcx jSTS(VacSynjcx et) {
        return super.jSTS(et);
    }
}


