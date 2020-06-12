package cn.ibizlab.ehr.core.extensions.service;

import cn.ibizlab.ehr.core.common.service.impl.CodeList1ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.ehr.core.common.domain.CodeList1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;

/**
 * 实体[代码表] 自定义服务对象
 */
@Slf4j
@Primary
@Service("CodeList1ServiceEx")
public class CodeList1ServiceEx extends CodeList1ServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    /**
     * 自定义行为[RefreshModel]用户扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public CodeList1 refreshModel(CodeList1 et) {
        return super.refreshModel(et);
    }
}


