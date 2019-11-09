package pl.sda.commons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetCommonApi {

    public static void select(Connection connect, String sql, ResultSetHandler resultSetHandler) throws SQLException {
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                resultSetHandler.handle(rs);
            }
        }
    }
}
