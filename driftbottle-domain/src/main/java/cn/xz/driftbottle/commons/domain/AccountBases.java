package cn.xz.driftbottle.commons.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "account_bases")
public class AccountBases implements Serializable {
    /**
     * 用户id 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 环信登录id
     */
    @Column(name = "em_id")
    private String emId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 头像
     */
    @Column(name = "head_portrait")
    private String  headPortrait;

    /**
     * 个人信息卡片背景图
     */
    @Column(name = "card_picture")
    private String cardPicture;

    /**
     * 捡瓶子数量
     */
    @Column(name = "get_bottle_count")
    private Integer getBottleCount;

    /**
     * 捞瓶子数量
     */
    @Column(name = "put_bottle_count")
    private Integer putBottleCount;

    /**
     * 关注数量
     */
    @Column(name = "attention_count")
    private Integer attentionCount;

    /**
     * 粉丝数量
     */
    @Column(name = "fans_count")
    private Integer fansCount;

    /**
     * 创建时间
     */
    @Column(name = "creat_date")
    private Date creatDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 违规警告次数
     */
    @Column(name = "warning_count")
    private Integer warningCount;

    /**
     * 最近登录时间
     */
    @Column(name = "lately_login_date")
    private Date latelyLoginDate;

    /**
     * 获取用户id 自增
     *
     * @return id - 用户id 自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id 自增
     *
     * @param id 用户id 自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取环信登录id
     *
     * @return em_id - 环信登录id
     */
    public String getEmId() {
        return emId;
    }

    /**
     * 设置环信登录id
     *
     * @param emId 环信登录id
     */
    public void setEmId(String emId) {
        this.emId = emId;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取个性签名
     *
     * @return signature - 个性签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置个性签名
     *
     * @param signature 个性签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取所在城市
     *
     * @return city - 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在城市
     *
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取头像
     *
     * @return head_portrait - 头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 设置头像
     *
     * @param headPortrait 头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    /**
     * 获取个人信息卡片背景图
     *
     * @return card_picture - 个人信息卡片背景图
     */
    public String getCardPicture() {
        return cardPicture;
    }

    /**
     * 设置个人信息卡片背景图
     *
     * @param cardPicture 个人信息卡片背景图
     */
    public void setCardPicture(String  cardPicture) {
        this.cardPicture = cardPicture;
    }

    /**
     * 获取捡瓶子数量
     *
     * @return get_bottle_count - 捡瓶子数量
     */
    public Integer getGetBottleCount() {
        return getBottleCount;
    }

    /**
     * 设置捡瓶子数量
     *
     * @param getBottleCount 捡瓶子数量
     */
    public void setGetBottleCount(Integer getBottleCount) {
        this.getBottleCount = getBottleCount;
    }

    /**
     * 获取捞瓶子数量
     *
     * @return put_bottle_count - 捞瓶子数量
     */
    public Integer getPutBottleCount() {
        return putBottleCount;
    }

    /**
     * 设置捞瓶子数量
     *
     * @param putBottleCount 捞瓶子数量
     */
    public void setPutBottleCount(Integer putBottleCount) {
        this.putBottleCount = putBottleCount;
    }

    /**
     * 获取关注数量
     *
     * @return attention_count - 关注数量
     */
    public Integer getAttentionCount() {
        return attentionCount;
    }

    /**
     * 设置关注数量
     *
     * @param attentionCount 关注数量
     */
    public void setAttentionCount(Integer attentionCount) {
        this.attentionCount = attentionCount;
    }

    /**
     * 获取粉丝数量
     *
     * @return fans_count - 粉丝数量
     */
    public Integer getFansCount() {
        return fansCount;
    }

    /**
     * 设置粉丝数量
     *
     * @param fansCount 粉丝数量
     */
    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    /**
     * 获取创建时间
     *
     * @return creat_date - 创建时间
     */
    public Date getCreatDate() {
        return creatDate;
    }

    /**
     * 设置创建时间
     *
     * @param creatDate 创建时间
     */
    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取违规警告次数
     *
     * @return warning_count - 违规警告次数
     */
    public Integer getWarningCount() {
        return warningCount;
    }

    /**
     * 设置违规警告次数
     *
     * @param warningCount 违规警告次数
     */
    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    /**
     * 获取最近登录时间
     *
     * @return lately_login_date - 最近登录时间
     */
    public Date getLatelyLoginDate() {
        return latelyLoginDate;
    }

    /**
     * 设置最近登录时间
     *
     * @param latelyLoginDate 最近登录时间
     */
    public void setLatelyLoginDate(Date latelyLoginDate) {
        this.latelyLoginDate = latelyLoginDate;
    }
}