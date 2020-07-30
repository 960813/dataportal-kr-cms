package kr.dataportal.cms.domain;

public enum MemberRole {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;

    MemberRole(String role_member) {
        this.value = role_member;
    }

    public String getValue() {
        return value;
    }
}
