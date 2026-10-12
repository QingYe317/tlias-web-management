package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    /**
     * 查询学生信息
     */
    public List<Student> list(StudentQueryParam studentQueryParam);

    /**
     * 添加学员
     * @param student
     */
    void save(Student student);

    /**
     * 根据id查询学员
     * @param id
     * @return
     */
    Student selectById(Integer id);

    /**
     * 修改员工
     * @param student
     */
    void update(Student student);

    /**
     * 根据ids批量删除学员
     */
    void deleteByIds(@Param("ids") List<Integer> ids);

    /**
     * 根据班级ID查询学生数量
     */
    @Select("select count(*) from student where clazz_id = #{clazzId}")
    int countByClazzId(Integer clazzId);

    /**
     * 违纪处理：违纪次数+1，扣分累加
     */
    void updateViolation(@Param("id") Integer id, @Param("score") Integer score);

    /**
     * 统计学员学历信息
     */
    @MapKey("name")
    List<Map> countStudentDegreeData();

    /**
     * 统计每一个班级的人数
     */
    List<Map<String, Object>> countStudentClazzData();
}
