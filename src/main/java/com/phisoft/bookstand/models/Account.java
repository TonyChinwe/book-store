package com.phisoft.bookstand.models;
import com.phisoft.bookstand.authentication.Permission;
import com.phisoft.bookstand.authentication.Role;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ACCOUNT_ID", nullable=false)
    private Long id;

    @Column(name="IN_ENABLED")
    private boolean isEnabled;

    @Column(name="IN_NOT_EXPIRED")
    private boolean isNotExpired;

    @Column(name="IN_NOT_LOCKED")
    private boolean isNotLocked;

    @Column(name="IN_CREDENTIAL_NOT_EXPIRED")
    private boolean isCredentialNotExpired;

    @Getter @Setter
    @Column(name="PASSWORD", nullable=false)
    private String password;

    @Getter @Setter
    @Column(name="USERNAME",unique = true, nullable=false)
    private String username;


    @Setter @Getter
    @ElementCollection(targetClass = Permission.class)
    @Enumerated(EnumType.STRING)
    @Column(name="PERMISSION")
    private List<Permission> permissions=new ArrayList<>();


    @Getter @Setter
    @Column(name="ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;




}
