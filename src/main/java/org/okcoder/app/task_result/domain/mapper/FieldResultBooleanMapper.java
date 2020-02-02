package org.okcoder.app.task_result.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.okcoder.app.task_result.domain.entity.FieldResultBoolean;
import org.okcoder.app.task_result.domain.entity.FieldResultBooleanCondition;

public interface FieldResultBooleanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    long countByExample(FieldResultBooleanCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int deleteByExample(FieldResultBooleanCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int deleteByPrimaryKey(@Param("resultId") Long resultId, @Param("fieldId") Integer fieldId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int insert(FieldResultBoolean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int insertSelective(FieldResultBoolean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    List<FieldResultBoolean> selectByExample(FieldResultBooleanCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    FieldResultBoolean selectByPrimaryKey(@Param("resultId") Long resultId, @Param("fieldId") Integer fieldId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int updateByExampleSelective(@Param("record") FieldResultBoolean record, @Param("example") FieldResultBooleanCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int updateByExample(@Param("record") FieldResultBoolean record, @Param("example") FieldResultBooleanCondition example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int updateByPrimaryKeySelective(FieldResultBoolean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FIELD_RESULT_BOOLEAN
     *
     * @mbg.generated Sun Feb 02 18:19:38 JST 2020
     */
    int updateByPrimaryKey(FieldResultBoolean record);
}