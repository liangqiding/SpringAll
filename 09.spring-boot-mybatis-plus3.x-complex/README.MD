# mybatis-plus 复杂查询
## 目录

## 简介
> pom、yml等均和08项目相同，xml 自定义sql的方式完成mysql多表连接查询、分页、模糊、嵌套等查询
## 1 起步
### 1.1 项目基本配置
> 复制08项目中的起步依赖和yml中的配置以及GlobalConfigs
>运行GlobalConfigs 一键生成代码模板

## 2 增删改查简单测试
### 2.1 dao层接口编写
> 编辑数据接口
```java
public interface QdOrderMapper extends BaseMapper<QdOrder> {

    /**
     *  todo 查询单个
     * @param orderId id
     * @return one
     */
    QdOrder getQdOrderById(Integer orderId);

    /**
     * todo 查询多个
     * @return list
     */
    List<QdOrder> listQdOrder();

    /**
     * todo 删除单个
     * @param orderId id
     * @return int
     */
    int deleteQdOrderById(Integer orderId);

    /**
     * todo 增加单个
     * @param qdOrder
     * @return
     */
    int InsertQdOrder(QdOrder qdOrder);

    /**
     * todo 更新多个
     * @param qdOrder
     * @return  ·
     */
    int updateQdOrder(QdOrder qdOrder);

}
```
> 编写xml文件，完成sql语句和dao层绑定
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="spring.boot.pagehelper.dao.QdOrderMapper">

    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="spring.boot.pagehelper.domain.QdOrder">
        <id column="order_id" property="orderId"/>
        <result column="order_time" property="orderTime"/>
        <result column="order_status" property="orderStatus"/>
        <result column="user_id" property="userId"/>
    </resultMap>

    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
        order_id, order_time, order_status, user_id
    </sql>

    <!--    1.1 -->
    <select id="getQdOrderById" parameterType="Integer" resultType="QdOrder">
        select
        <include refid="Base_Column_List"></include>
        from qd_order
        where order_id=#{orderId}
    </select>
    <!--1.2 -->
    <select id="listQdOrder" resultType="QdOrder">
        select
        <include refid="Base_Column_List"></include>
        from qd_order
    </select>
    <!--1.3-->
    <insert id="InsertQdOrder" parameterType="QdOrder">
        INSERT INTO
        qd_order
        (order_time, order_status, user_id, order_user_id)
        VALUES
        (#{orderTime}, #{orderStatus}, #{userId}, #{orderUserId});
    </insert>
    <!--1.4-->
    <update id="updateQdOrder" parameterType="QdOrder">
        UPDATE qd_order
        <set>
            <if test="orderTime !=null ">
                order_time= #{orderTime},
            </if>
            <if test="orderStatus !=null and orderStatus!=''">
                order_status= #{orderStatus},
            </if>
            <if test="userId !=null">
                user_id= #{userId},
            </if>
            <if test="orderUserId !=null">
                order_user_id= #{orderUserId},
            </if>
        </set>
        WHERE
        `order_id` = #{orderId};
    </update>
    <!--1.5-->
    <delete id="deleteQdOrderById" parameterType="Integer">
       DELETE FROM qd_order WHERE order_id = #{orderId}
    </delete>

</mapper>
```
### 2.2测试类编写
> 导入数据库，sql文件在项目路径下
> 编写测试类,测试数据CURD
```java

@SpringBootTest
class PagehelperApplicationTests {
@Autowired
    QdOrderMapper qdOrderMapper;

    // todo 1.1 根据id查询单个
    @Test
    void getQdOrderById() {
        QdOrder qdOrderById = qdOrderMapper.getQdOrderById(1);
        System.out.println(qdOrderById);
    }

    // todo 1.2 查询多个
    @Test
     void listQdOrder() {
        List<QdOrder> qdOrders = qdOrderMapper.listQdOrder();
        System.out.println(qdOrders);
    }

    // todo 1.3 添加单条数据
    @Test
    void InsertQdOrder() {
        Date date = new Date();
        int i = qdOrderMapper.InsertQdOrder(
                new QdOrder()
                        .setOrderTime(date)
                        .setUserId(1010)
                        .setOrderUserId(2020)
                        .setOrderStatus("待支付")
        );
        System.out.println(i);
    }

    // todo 1.4 更新数据
    @Test
    void updateQdOrder() {
        int i = qdOrderMapper.updateQdOrder(
                new QdOrder()
                        .setOrderTime(new Date())
                        .setOrderStatus("已支付")
                        .setOrderId(6)
        );
        System.out.println(i);
    }
    // todo 1.5 删除单条数据
    @Test
    void deleteQdOrderById() {
        int i = qdOrderMapper.deleteQdOrderById(6);
        System.out.println(i);
    }
}
```
