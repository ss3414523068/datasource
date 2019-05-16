package mybatis.mapper;

import mybatis.model.Test1;
import mybatis.model.rbac.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Test1Mapper {

    /************************************************************分割线************************************************************/
    /* todo 《MyBatis从入门到精通》系统学习 */

    /*
     * ①MyBatis 2.x：使用sqlSessionTemplate调用方法
     * ②MyBatis 3.x：使用Java的动态代理直接通过接口调用方法
     *
     * ①SQL XML的id不能重复
     * ②接口方法却可以重载（同名方法中增加一个RowBound类型参数用于分页）
     *
     * ①#{id}：预编译参数
     * ②如果传入的参数是对象，可以通过对象.属性取值，例如#{test.id}
     *
     * ①sqlSessionTemplate+XML
     * ②接口+XML
     * ③接口+MyBatis注解（不推荐）
     * */

    /************************************************************半分割线******************************/
    /* todo CURD */

    int insert(Test1 record);

    /*
     * ①主键自增，不需要id
     * ②可选插入，JavaBean为null时使用数据库字段默认值（搭配XML trim使用）
     * */
    int insertSelective(Test1 record);

    /*
     * ①根据主键可选更新
     * ②id一定要设置
     * */
    int updateByIdSelective(Test1 record);

    int deleteById(Integer id);

    Test1 selectById(Integer id);

    /************************************************************半分割线******************************/
    /* todo 主键自增 */

    /* 适用于支持主键自增的数据库 */
    int insertGeneratedKey(Test1 record);

    /* 都支持 */
    int insertSelectKey(Test1 record);

    /************************************************************半分割线******************************/
    /* todo MyBatis 注解方式 */

    /*
     * ①SQL不应当写在Java代码中
     * ②MyBatis XML强大的功能都没法用
     * ③以Spring为例：Spring2.x时代全XML？Spring3.x时代XML+注解，Spring4.x时代（配置可以全Java代码+注解）
     * */
    @Insert("INSERT INTO test (parent_id, create_time)" +
            "VALUES (#{parentId}, NOW())")
    int insert2(Test1 record);

    @Update("UPDATE test " +
            "set parent_id = #{parentId},create_time = NOW() " +
            "WHERE id = #{id}")
    int updateById2(Test1 record);

    @Delete("DELETE FROM test " +
            "WHERE id = #{id}")
    int deleteById2(Integer id);

    @Select("SELECT * " +
            "FROM test " +
            "WHERE id = #{id}")
    Test1 selectById2(Integer id);

    /************************************************************分割线************************************************************/
    /* todo 强大的动态SQL */

    /*
     * if
     * ①insert/update/where中的if
     * ②<if test=>判断参数是否为null/为''/长度
     * */

    /*
     * choose+when+otherwise
     * ①强化版if，类似Java中的switch
     * */

    /*
     * where+set+trim
     * */
    List<Test1> selectByWhere(Test1 record);

    int updateBySet(Test1 record);

    List<Test1> selectByTrim(Test1 record);

    /* foreach（自行总结-传入参数） */

    /* bind（bind：绑定） */
    List<Test1> selectByBind(Test1 record);

    /************************************************************分割线************************************************************/
    /* todo 映射 */

    /* 一对一映射 */
    User selectUserAndRoleById(Integer id);

}
