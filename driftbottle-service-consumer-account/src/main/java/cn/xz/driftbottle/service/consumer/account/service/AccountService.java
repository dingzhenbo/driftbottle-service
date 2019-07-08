package cn.xz.driftbottle.service.consumer.account.service;

import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.service.consumer.account.service.fallback.AccountServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "driftbottle-service-provider-account",fallback = AccountServiceFallback.class)
public interface AccountService {

    @PostMapping(value = "account/reg")
    String reg(@RequestParam String accountBasesJson);


    @GetMapping(value = "account/search/{id}")
    String searchAccount(@PathVariable String id);

    @PostMapping(value = "account/attention/{current}/{attention}")
    void  attention(@PathVariable String current,@PathVariable String attention);

    @GetMapping(value = "account/attention/state/{current}/{other_account}")
    String attentionState(@PathVariable String current,@PathVariable String other_account);

    @GetMapping(value = "account/get/id/{emid}")
    String getCurrentId(@PathVariable String emid);

    @GetMapping(value = "account/attention/list/{account_id}")
    String attentionList(@PathVariable Integer account_id);

    @PostMapping(value = "account/attention/cancel/{current}/{attention}")
    void cancelAttention(@PathVariable String current,@PathVariable String attention);
}
