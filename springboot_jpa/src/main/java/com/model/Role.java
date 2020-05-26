package com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

//    @Column(name = "user_id")
//    private Integer userId;

    /* 多对多 */
//    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
//    private Set<User> userList;

    @Override
    public String toString() {
        return "";
    }

}
