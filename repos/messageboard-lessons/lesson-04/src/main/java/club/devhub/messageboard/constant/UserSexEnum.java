package club.devhub.messageboard.constant;

public enum UserSexEnum {
    UNKNOWN(0),
    MALE(1),
    FEMALE(2);

    public int getCode() {
        return code;
    }

    private final int code;

    UserSexEnum(int code) {
        this.code = code;
    }
}
