package org.aptech.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
    private static DataSource ds = null;
    static {
        Properties p = new Properties();
        try {
            p.load(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("jdbc.properties"));
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static Connection getConnection() {
        try {
            System.out.println();
            return ds.getConnection();
        } catch (SQLException e) {
            System.out.println();
        }
        return null;
    }

    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println();
        }finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                System.out.println();
            }finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    System.out.println();
                }
            }
        }
    }
}
