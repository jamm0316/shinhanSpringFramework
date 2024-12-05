package com.shinhan.myapp.model;

import com.shinhan.myapp.model.util.DBUtil;
import com.shinhan.myapp.vo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository  //@Component + DAO의 기능 == Bean객체
public class MemberDAO {

    @Autowired
    @Qualifier("dataSource")
    DataSource ds;

    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    String sql_selectLogin = "select * from members where member_id=?";

    public MemberDTO login(String member_id, String member_pass) {
        MemberDTO memberDTO = null;
        try {
            conn = ds.getConnection();
            st = conn.prepareStatement(sql_selectLogin);
            st.setString(1, member_id);
            rs = st.executeQuery();
            if (rs.next()) {
                String getPass = rs.getString("member_pass");
                if (getPass.equals(member_pass)) {
                    memberDTO = MemberDTO.builder()
                            .member_id(member_id)
                            .member_pass(member_pass)
                            .member_name(rs.getString("member_name"))
                            .member_email(rs.getString("member_email"))
                            .build();
                } else {
                    memberDTO = MemberDTO.builder()
                            .member_id("ErrorPassWord")
                            .build();
                }
            }
            } catch(SQLException e){
                throw new RuntimeException(e);
            }

            return memberDTO;
        }
    }
