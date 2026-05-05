package club.devhub.messageboard.constant;

/**
 * 举报种类
 */
public enum ReportTypeEnum {
    /**
     * 留言
     */
    MESSAGE(0),
    /**
     * 评论
     */
    COMMENT(1);
    private final int code;

    ReportTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
