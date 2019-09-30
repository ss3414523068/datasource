package mybatis.model.rbac;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String userName;

    private String userPassword;

    /************************************************************分割线************************************************************/

    private Role role; /* RBAC中，将用户的角色作为属性存放在用户实体类中 */

}
