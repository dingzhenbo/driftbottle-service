package cn.xz.driftbottle.service.consumer.account.controller;

import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.commons.utils.MapperUtils;
import cn.xz.driftbottle.service.consumer.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping(value = "account")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping(value = "")
    public String sayHi(){
        return "D.";
    }

    @PostMapping(value = "reg")
    public BaseResult reg(AccountBases accountBases){
        String json = null;
        try {
            json = MapperUtils.obj2json(accountBases);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fallbackJson = accountService.reg(json); //调用服务提供者
        try {
            BaseResult baseResult = MapperUtils.json2pojo(fallbackJson, BaseResult.class);
            return baseResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}
