package cn.ibizlab.ehr.util.domain;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

public class EntityMP extends EntityBase {



    public UpdateWrapper getUpdateWrapper(boolean clean) {
        UpdateWrapper wrapper=new UpdateWrapper();
        for(String nullField:getFocusNull()) {
            wrapper.set(nullField,null);
        }
        if(clean)
            getFocusNull().clear();
        return  wrapper;
    }

    @Override
    public void modify(String field,Object val) {
        if(val==null)
            this.getFocusNull().add(field.toLowerCase());
        else
            this.getFocusNull().remove(field.toLowerCase());
    }

}

