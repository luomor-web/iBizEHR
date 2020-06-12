package cn.ibizlab.ehr.util.domain;

import java.util.List;

/**
 * 实体转换器基类
 * @param <D> domainDTO
 * @param <E> domain
 */
public interface MappingBase<D, E> {

    /**
    * dto转domain
    * @param dto
    * @return
    */
    E toDomain(D dto);
    /**
    * domain转dto
    * @param entity
    * @return
    */
    D toDto(E entity);
    /**
    * dto集合转domain集合
    * @param dtoList
    * @return
    */
    List <E> toDomain(List<D> dtoList);
    /**
    * domain集合转dto集合
    * @param entityList
    * @return
    */
    List <D> toDto(List<E> entityList);
}
