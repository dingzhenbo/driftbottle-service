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

    @Override
    public void attention(String current, String attention) {

    }

    @Override
    public void cancelAttention(String current, String attention) {

    }

    @Override
    public String getCurrentId(String emid) {
        return null;
    }

    @Override
    public String attentionList(Integer account_id) {
        return Fallback.CommonsFallback();
    }

    @Override
    public String attentionState(String current, String other_current) {
        return null;
    }
}
