package cn.xz.driftbottle.service.consumer.account.service;

import cn.xz.driftbottle.service.consumer.account.service.fallback.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "driftbottle-service-provider-account",fallback = AccountServiceFallback.class)
public interface AccountService {

    @PostMapping(value = "account/reg")
    String reg(@RequestParam String accountBasesJson);
}
