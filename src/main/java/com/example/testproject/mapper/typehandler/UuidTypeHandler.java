package com.example.testproject.mapper.typehandler;


import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.UUID;

/**
 * Handler for UUID types.
 *
 * @see UUID
 */
@MappedTypes({UUID.class})
public class UuidTypeHandler implements TypeHandler<UUID> {
    private static final Logger LOG = LoggerFactory.getLogger(UuidTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setObject(i, null, Types.OTHER);
        } else {
            ps.setObject(i, parameter.toString(), Types.OTHER);
        }

    }

    @Override
    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
        return toUUID(rs.getString(columnName));
    }

    @Override
    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
        return toUUID(rs.getString(columnIndex));
    }

    @Override
    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toUUID(cs.getString(columnIndex));
    }

    private static UUID toUUID(String val) {
        return UUID.fromString(val);
//        if (!Strings.isNullOrEmpty(val)) {
//            try {
//                return UUID.fromString(val);
//            } catch (IllegalArgumentException e) {
//                LOG.warn("Bad UUID found: {}", val);
//            }
//        }
//        return null;
    }

}