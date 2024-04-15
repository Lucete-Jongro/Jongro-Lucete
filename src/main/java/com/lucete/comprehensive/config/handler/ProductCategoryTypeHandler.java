package com.lucete.comprehensive.config.handler;

import com.lucete.comprehensive.product.model.dto.ProductCategoryDTO;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryTypeHandler extends BaseTypeHandler<ProductCategoryDTO> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ProductCategoryDTO parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getProdCategory());
    }

    @Override
    public ProductCategoryDTO getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int prodCategory = rs.getInt(columnName);
        // ProductCategoryDTO 객체를 생성하고 필요한 값을 설정하여 반환
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setProdCategory(prodCategory);
        return categoryDTO;
    }

    @Override
    public ProductCategoryDTO getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int prodCategory = rs.getInt(columnIndex);
        // ProductCategoryDTO 객체를 생성하고 필요한 값을 설정하여 반환
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setProdCategory(prodCategory);
        return categoryDTO;
    }

    @Override
    public ProductCategoryDTO getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int prodCategory = cs.getInt(columnIndex);
        // ProductCategoryDTO 객체를 생성하고 필요한 값을 설정하여 반환
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setProdCategory(prodCategory);
        return categoryDTO;
    }
}
