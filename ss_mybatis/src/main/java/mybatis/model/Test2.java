package mybatis.model;

import java.util.List;
import java.util.Map;

public class Test2 {

    private Integer id;
    private Integer parentId;
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /************************************************************分割线************************************************************/

    /* 基本类型/对象集合（不需要指定泛型） */
    private int[] selectArray;
    private List selectList;
    private Map selectMap;

    public int[] getSelectArray() {
        return selectArray;
    }

    public void setSelectArray(int[] selectArray) {
        this.selectArray = selectArray;
    }

    public List getSelectList() {
        return selectList;
    }

    public void setSelectList(List selectList) {
        this.selectList = selectList;
    }

    public Map getSelectMap() {
        return selectMap;
    }

    public void setSelectMap(Map selectMap) {
        this.selectMap = selectMap;
    }

    /************************************************************分割线************************************************************/

    /* 用于varchar型时间查询，数据库中没有 */
    private String beginTime;
    private String endTime;

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /************************************************************分割线************************************************************/

    /* 用于count(*)返回值映射 */
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    /************************************************************分割线************************************************************/

    /* 重写toString()/equals()/hashCode() */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Test2 other = (Test2) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

}
