package cn.xz.driftbottle.commons.provider.impl;

import cn.xz.driftbottle.commons.provider.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.MyMapper;

public class BaseServiceImpl<T,M extends MyMapper<T>> implements BaseService<T>{

    @Autowired
    private M mapper;

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }

    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKey(t);
    }

    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public PageInfo<T> page(int pageNum, int pagesSize, T t) {
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(pageNum,pagesSize);
        PageInfo<T> pageInfo = new PageInfo<>(mapper.select(t));
        return pageInfo;
    }

    @Override
    public int count(T t) {
        return mapper.selectCount(t);
    }
}
