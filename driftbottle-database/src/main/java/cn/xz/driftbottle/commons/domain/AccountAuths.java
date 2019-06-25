package cn.xz.driftbottle.commons.domain;

import javax.persistence.*;

@Table(name = "driftbottle-account..account_auths")
public class AccountAuths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联account_bases的id
     */
    @Column(name = "account_id")
    private Integer accountId;

    /**
     * 三方登录唯一标识
     */
    @Column(name = "third_key")
    private String thirdKey;

    /**
     * 三方登录类型
     */
    @Column(name = "third_type")
    private String thirdType;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联account_bases的id
     *
     * @return account_id - 关联account_bases的id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置关联account_bases的id
     *
     * @param accountId 关联account_bases的id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取三方登录唯一标识
     *
     * @return third_key - 三方登录唯一标识
     */
    public String getThirdKey() {
        return thirdKey;
    }

    /**
     * 设置三方登录唯一标识
     *
     * @param thirdKey 三方登录唯一标识
     */
    public void setThirdKey(String thirdKey) {
        this.thirdKey = thirdKey;
    }

    /**
     * 获取三方登录类型
     *
     * @return third_type - 三方登录类型
     */
    public String getThirdType() {
        return thirdType;
    }

    /**
     * 设置三方登录类型
     *
     * @param thirdType 三方登录类型
     */
    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }
}