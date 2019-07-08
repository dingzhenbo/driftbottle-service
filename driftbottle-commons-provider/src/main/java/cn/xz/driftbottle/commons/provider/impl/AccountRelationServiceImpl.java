package cn.xz.driftbottle.commons.provider.impl;

import cn.xz.driftbottle.commons.domain.AccountRelation;
import cn.xz.driftbottle.commons.mapper.AccountRelationMapper;
import cn.xz.driftbottle.commons.provider.AccountRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AccountRelationServiceImpl extends BaseServiceImpl<AccountRelation, AccountRelationMapper>  implements AccountRelationService<AccountRelation> {


    @Override
    public List<AccountRelation> select(AccountRelation accountRelation) {
        List<AccountRelation> accountRelationList = mapper.select(accountRelation);
        return accountRelationList;
    }
}
