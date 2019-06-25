package cn.xz.driftbottle.commons.provider.impl;

import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.commons.mapper.AccountBasesMapper;
import cn.xz.driftbottle.commons.provider.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountBases,AccountBasesMapper> implements AccountService<AccountBases> {

}
