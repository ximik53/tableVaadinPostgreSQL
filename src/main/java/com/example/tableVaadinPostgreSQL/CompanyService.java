package com.example.tableVaadinPostgreSQL;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyService {

    @Select("SELECT * FROM company ORDER BY id")
    List<Company> findAll();

    @Update("UPDATE company SET name = #{name}, surname = #{surname}, email = #{email} WHERE id = #{id}")
    void update(Company company);

    @Delete("DELETE FROM company WHERE id = #{id}")
    void delete(Company delCompany);

    @Insert( "INSERT INTO company(name,surname,email) VALUES (#{name},#{surname},#{email})")
    void insert(Company newCompany);

}