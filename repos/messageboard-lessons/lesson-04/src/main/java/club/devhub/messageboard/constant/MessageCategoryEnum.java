package club.devhub.messageboard.constant;

/**
 * 留言类别
 */
public enum MessageCategoryEnum {
    /**
     * 未知
     */
    UNKNOWN(0),
    /**
     * 学习
     */
    STUDY(1),
    /**
     * 生活
     */
    LIFE(2),
    /**
     * 娱乐
     */
    ENTERTAINMENT(3),
    /**
     * 其他
     */
    OTHER(4);
    private final int code;

    MessageCategoryEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
