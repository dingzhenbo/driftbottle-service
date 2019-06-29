package cn.xz.driftbottle.service.consumer.account.service.fallback;

import cn.xz.driftbottle.commons.consumer.utils.Fallback;
import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.service.consumer.account.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceFallback implements AccountService {

    @Override
    public String reg(String accountBases) {
        return Fallback.CommonsFallback();
    }

    @Override
    public String searchAccount(String id) {
        return Fallback.CommonsFallback();
    }
}
