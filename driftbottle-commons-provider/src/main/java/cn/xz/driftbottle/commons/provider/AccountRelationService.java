package cn.xz.driftbottle.commons.provider;

import cn.xz.driftbottle.commons.domain.AccountRelation;

import java.util.List;

public interface AccountRelationService<T> extends  BaseService<T>{

    /**
     * 查询集合
     * @param accountRelation
     * @return
     */
    List<AccountRelation> select(AccountRelation accountRelation);
}
