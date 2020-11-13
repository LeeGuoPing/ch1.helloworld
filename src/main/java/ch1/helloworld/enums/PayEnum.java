package ch1.helloworld.enums;

/**
 * 支付方式枚举
 */
public enum PayEnum {

    ALI_PAY("ali","支付宝支付"),

    WECHAT_PAY("wechat","微信支付"),

    UNION_PAY("union","银联支付"),

    XIAO_MI_PAY("xiaomi","小米支付");

    /**渠道*/
    private String channel;

    /**描述*/
    private String description;

    PayEnum(String channel, String description) {
        this.channel = channel;
        this.description = description;
    }

    public String getChannel() {
        return channel;
    }

    public String getDescription() {
        return description;
    }
}
