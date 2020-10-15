package com.mft.general.service.imp;

import com.mft.general.entities.BaseEntity;
import com.mft.general.service.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public abstract class GenericServiceDefault<T extends BaseEntity<PK>, PK extends Serializable> implements GenericService<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract JpaRepository<T, PK> getGenericRepo();

    /**
     *
     * @param example
     * @return
     */
    protected Example<T> getExample(T example) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING)
                .withIgnoreCase();
        Example<T> exam = Example.of(example, exampleMatcher);
        return exam;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public T findOne(PK id) {
        return getGenericRepo().getOne(id);
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public T save(T entity) {
        return getGenericRepo().save(entity);
    }

    /**
     *
     * @param entities
     */
    @Override
    public void save(List<T> entities) {
        getGenericRepo().saveAll(entities);
    }

    /**
     *
     * @param entity
     */
    @Override
    public void delete(T entity) {
        getGenericRepo().delete(entity);
    }

    /**
     *
     * @param entities
     */
    @Override
    public void delete(List<T> entities) {
        getGenericRepo().deleteAll(entities);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(PK id) {
        delete(findOne(id));
    }

    /**
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        return getGenericRepo().findAll();
    }

    /**
     *
     * @param ids
     * @return
     */
    @Override
    public List<T> findAll(List<PK> ids) {
        return getGenericRepo().findAllById(ids);
    }

    /**
     *
     * @param sort
     * @return
     */
    public List<T> findAll(Sort sort) {
        return getGenericRepo().findAll(sort);
    }

    /**
     *
     * @param example
     * @param <S>
     * @return
     */
    public <S extends T> List<T> findAll(S example) {
        return getGenericRepo().findAll(getExample(example));
    }

    /**
     *
     * @param example
     * @param sort
     * @param <S>
     * @return
     */
    public <S extends T> List<T> findAll(S example, Sort sort) {
        return getGenericRepo().findAll(getExample(example), sort);
    }

    /**
     *
     * @param page
     * @param size
     * @param <S>
     * @return
     */
    public <S extends T> Page<T> findAll(int page, int size) {
        return getGenericRepo().findAll(PageRequest.of(page, size));
    }

    /**
     *
     * @param page
     * @param size
     * @param sort
     * @return
     */
    public Page<T> findAll(int page, int size, Sort sort) {
        return getGenericRepo().findAll(PageRequest.of(page, size, sort));
    }

    /**
     *
     * @param pageRequest
     * @return
     */
    public Page<T> findAll(PageRequest pageRequest) {
        return getGenericRepo().findAll(pageRequest);
    }

    /**
     *
     * @param pageRequest
     * @param example
     * @param <S>
     * @return
     */
    public <S extends T> Page<T> findAll(PageRequest pageRequest, S example) {
        return getGenericRepo().findAll(getExample(example), pageRequest);
    }

    /**
     *
     * @param page
     * @param size
     * @param direction
     * @param properties
     * @return
     */
    public Page<T> findAll(int page, int size, Direction direction, String... properties) {
        return getGenericRepo().findAll(PageRequest.of(page, size, direction, properties));
    }

    /**
     *
     * @param page
     * @param size
     * @param example
     * @param <S>
     * @return
     */
    public <S extends T> Page<T> findAll(int page, int size, S example) {
        return getGenericRepo().findAll(getExample(example), PageRequest.of(page, size));
    }

    /**
     *
     * @param page
     * @param size
     * @param example
     * @param direction
     * @param properties
     * @param <S>
     * @return
     */
    public <S extends T> Page<T> findAll(int page, int size, S example, Direction direction, String... properties) {
        return getGenericRepo().findAll(getExample(example), PageRequest.of(page, size, direction, properties));
    }

    /**
     *
     * @param page
     * @param size
     * @param example
     * @param sort
     * @param <S>
     * @return
     */
    public <S extends T> Page<T> findAll(int page, int size, S example, Sort sort) {
        return getGenericRepo().findAll(getExample(example), PageRequest.of(page, size));
    }

}
