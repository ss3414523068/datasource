package mybatis.mapper;

import mybatis.model.Test2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Test2Mapper {

    /************************************************************分割线************************************************************/
    /* todo CURD */

    int insert(Test2 record);

    int insertSelective(Test2 record);

    int updateByIdSelective(Test2 record);

    int deleteById(Integer id);

    Test2 selectById(Integer id);

    /************************************************************分割线************************************************************/
    /* todo 包装器类 */

    Test2 selectByInt(int id);

    Test2 selectByInteger(Integer id);

    /************************************************************分割线************************************************************/
    /* todo 传入参数（基本类型集合） */

    List<Test2> selectByArray(int[] array2);

    List<Test2> selectByList(List list2);

    List<Test2> selectByMap(Map map2);

    List<Test2> selectByMap2(Map map2);

    /************************************************************半分割线******************************/
    /* todo 传入参数（对象集合） */

    List<Test2> selectByArrayObject(Test2[] array2);

    List<Test2> selectByListObject(List list2);

    List<Test2> selectByMapObject(Map map2);

    List<Test2> selectByMapObject2(Map map2);

    /************************************************************半分割线******************************/
    /* todo 传入参数（对象中的基本类型集合） */

    List<Test2> selectByObjectArray(Test2 record);

    List<Test2> selectByObjectList(Test2 record);

    List<Test2> selectByObjectMap(Test2 record);

    /************************************************************半分割线******************************/
    /* todo 传入参数（对象中的对象集合） */

    List<Test2> selectByObjectListObject(Test2 record);

    List<Test2> selectByObjectMapObject(Test2 record);

    /************************************************************分割线************************************************************/
    /* todo varchar型时间 */

    /*
     * 传入对象+SQL BETWEEN
     * ①在JavaBean Test中增加beginTime/endTime，只用于查询，数据库中没有
     * ②如果查询18-12-26~18-12-27，需要输入18-12-26/18-12-28（相当于18-12-28 00:00:00）
     * */
    List<Test2> selectByCreateTime(Test2 record);

    /* 传入对象+SQL 大于小于转义符 */
    List<Test2> selectByCreateTime2(Test2 record);

    /* 传入多参数（超过1个参数就要使用@Param注解） */
    List<Test2> selectByCreateTime3(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    /*
     * 传入多参数（Map）
     * ①适用于sqlSessionTemplate版，Map相当于JavaBean
     * ②sqlSessionTemplate版可以使用@Param注解，但sqlSessionTemplate无法传入多个参数
     * */
    List<Test2> selectByCreateTime4(Map select);

    /************************************************************分割线************************************************************/
    /* todo MyBatis转义符 */

    /*
     * 直接使用MyBatis转义符
     * ①${}可以和字符串混用（'${}'）
     * ②搭配@Param注解传非SQL字符串（表名/字段名）
     * */
    List<Test2> selectByEscape(Test2 record);

    /* 使用CONCAT()拼接字符串 */
    List<Test2> selectByEscape2(Test2 record);

    /************************************************************分割线************************************************************/
    /* todo select count返回值 */

    /* 只返回count(*)的值 */
    int selectCount();

    /* 将count(*)映射到Test2.count */
    List<Test2> selectCount2();

}
