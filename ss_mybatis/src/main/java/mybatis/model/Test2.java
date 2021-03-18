package mybatis.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Test2 {

    private Integer id;

    private Integer parentId;

    private String createTime;

    /************************************************************分割线************************************************************/

    /* 基本类型/对象集合（不需要指定泛型） */
    private int[] selectArray;

    private List selectList;

    private Map selectMap;

    /************************************************************分割线************************************************************/

    /* 用于varchar型时间查询，数据库中没有 */
    private String beginTime;

    private String endTime;

    /************************************************************分割线************************************************************/

    /* 用于count(*)返回值映射 */
    private Integer count;

}
