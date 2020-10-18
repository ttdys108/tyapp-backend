package com.ttdys.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "account_no")
    private String accountNo;

    @Column
    private String avatar;

    @Column
    private String nickname;

    @Column
    private String mobile;

    @Column
    private String email;

    @Column
    private UserStatus status;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}
