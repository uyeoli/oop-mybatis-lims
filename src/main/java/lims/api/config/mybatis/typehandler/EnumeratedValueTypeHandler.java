package lims.api.config.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(EnumeratedValueType.class)
public class EnumeratedValueTypeHandler<E extends EnumeratedValueType> extends BaseTypeHandler<E> {

    private final E[] enumConstants;

    public EnumeratedValueTypeHandler(Class<E> type) {
        this.enumConstants = type.getEnumConstants();
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        if (jdbcType == null) {
            preparedStatement.setString(i, e.value());
        } else {
            preparedStatement.setObject(i, e.value(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String value = resultSet.getString(s);
        return enumBy(value);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String value = resultSet.getString(i);
        return enumBy(value);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String value = callableStatement.getString(i);
        return enumBy(value);
    }

    private E enumBy(String s) {
        if (enumConstants == null) {
            return null;
        }
        for (E enumConstant : enumConstants) {
            if (enumConstant.value().equals(s)) {
                return enumConstant;
            }
        }
        return null;
    }

}