package lims.api.user.entity;

import lombok.Builder;

@Builder
public class User {
    private int uid;
    private String id;
    private String name;
    private String password;
}
