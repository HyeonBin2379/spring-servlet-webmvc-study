package com.ssg.webmvc.todo.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    public String getTime() {
        try (Connection conn = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select now()");
             ResultSet rs = pstmt.executeQuery()) {
            rs.next();
            return rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTime2() throws Exception {
        // lombok @CleanUp을 사용한 DB 연동
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getString(1);
    }
}
