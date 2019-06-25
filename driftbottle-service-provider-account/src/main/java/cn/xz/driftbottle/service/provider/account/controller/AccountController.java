package cn.xz.driftbottle.service.provider.account.controller;

import cn.xz.driftbottle.commons.domain.AccountBases;
import cn.xz.driftbottle.commons.dto.BaseResult;
import cn.xz.driftbottle.commons.provider.AccountService;
import cn.xz.driftbottle.commons.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Transactional
@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(value = "reg")
    public BaseResult reg(String accountBasesJson){
        AccountBases accountBases = null;
        try {
            accountBases = MapperUtils.json2pojo(accountBasesJson, AccountBases.class);
            accountBases.setPassword(DigestUtils.md5DigestAsHex(accountBases.getPassword().getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        int insert = accountService.insert(accountBases);
        if (insert>0){
            return BaseResult.ok();
        }
        return BaseResult.notOk("注册失败");
    }
}
