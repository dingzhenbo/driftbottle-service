package cn.xz.driftbottle.commons.provider;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {


    int insert(T t);

    int delete(T t);

    int update(T t);

    T selectOne(T t);

    PageInfo<T> page (int pageNum, int pagesSize, T t);

    int count(T t);

}
