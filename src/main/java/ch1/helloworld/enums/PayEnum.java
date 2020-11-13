package ch1.helloworld.enums;

/**
 * 支付方式枚举
 */
public enum PayEnum {

    ALI_PAY("ali","支付宝支付", "aliPayStrategy"),

    WECHAT_PAY("wechat","微信支付","weChatStrategy"),

    UNION_PAY("union","银联支付","unionStrategy"),

    XIAO_MI_PAY("xiaomi","小米支付","xiaomiStrategy");

    /**渠道*/
    private String channel;

    /**描述*/
    private String description;

    private String service;

    PayEnum(String channel, String description,String service) {
        this.channel = channel;
        this.description = description;
        this.service = service;
    }

    public static String getServiceByChannel(String channel) {
        PayEnum[] values = values();
        for (PayEnum payEnum : values) {
            if(payEnum.getChannel().equals(channel)){
                return payEnum.getService();
            }
        }
        return null;
    }

    public String getChannel() {
        return channel;
    }

    public String getDescription() {
        return description;
    }

    public String getService() {
        return service;
    }
}
