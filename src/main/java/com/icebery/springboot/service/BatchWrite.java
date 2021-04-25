package com.icebery.springboot.service;

/**
 * @Author: 低调的小码农
 * @Date: 2021/4/25 11:04 AM
 * @Version 1.0
 */

        import java.sql.Connection;
        import java.sql.DatabaseMetaData;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Properties;


public class BatchWrite {
    private static String driverName = "com.aliyun.odps.jdbc.OdpsDriver";

    public static void main(String[] args) {

        try {
            printHelloWorld3();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void printHelloWorld() throws SQLException {

        System.out.println("hello world!");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Properties config = new Properties();
        config.put("access_id", "******");
        config.put("access_key", "************");
        config.put("project_name", "kf_weik_test");
        config.put("charset", "utf-8");
        Connection
                conn = DriverManager.getConnection("jdbc:odps:https://service.odps.aliyun.com/api", config);
        ResultSet rs;

        // create a table
        Statement stmt = conn.createStatement();
        String tableName = "jdbc_test";
        stmt.execute("drop table if exists " + tableName);
        stmt.execute("create table " + tableName + " (key int, value string)");

        // get meta data
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println("product = " + metaData.getDatabaseProductName());
        System.out.println("jdbc version = " + metaData.getDriverMajorVersion() + ", "
                + metaData.getDriverMinorVersion());
        rs = metaData.getTables(null, null, tableName, null);
        while (rs.next()) {
            String name = rs.getString(3);
            System.out.println("inspecting table: " + name);
            ResultSet rs2 = metaData.getColumns(null, null, name, null);
            while (rs2.next()) {
                System.out.println(rs2.getString("COLUMN_NAME") + "\t"
                        + rs2.getString("TYPE_NAME") + "(" + rs2.getInt("DATA_TYPE") + ")");
            }
        }

        // run sql
        String sql;

        // insert a record
        sql = String.format("insert into table %s select 24 key, 'hours' value from (select count(1) from %s) a", tableName, tableName);
        System.out.println("Running: " + sql);
        int count = stmt.executeUpdate(sql);
        System.out.println("updated records: " + count);

        // select * query
        sql = "select * from " + tableName;
        System.out.println("Running: " + sql);
        rs = stmt.executeQuery(sql);
        System.out.println("123");
        while (rs.next()) {
            System.out.println("456");
            System.out.println(String.valueOf(rs.getInt(1)) + "\t" + rs.getString(2));
        }

    }

    public static void printHelloWorld2() throws SQLException {

        System.out.println("hello world!");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Properties config = new Properties();
        config.put("access_id", "*****");
        config.put("access_key", "*****");
        config.put("project_name", "kf_weik_test");
        config.put("charset", "utf-8");
        Connection
                conn = DriverManager.getConnection("jdbc:odps:https://service.odps.aliyun.com/api", config);
        try {

            ResultSet rs;

            // create a table
            Statement stmt = conn.createStatement();
            String tableName = "jdbc_test";

            // run sql
            String sql;

            // insert a record
            sql = String.format("insert into table %s select 24 key, 'hours' value from (select count(1) from %s) a", tableName, tableName);
            System.out.println("Running: " + sql);
            int count = stmt.executeUpdate(sql);
            System.out.println("updated records: " + count);

            // select * query
            sql = "select * from " + tableName;
            System.out.println("Running: " + sql);
            rs = stmt.executeQuery(sql);
            System.out.println("123");
            while (rs.next()) {
                System.out.println("456");
                System.out.println(String.valueOf(rs.getInt(1)) + "\t" + rs.getString(2));
            }
        }
        finally {
            conn.close();
        }


    }

    public static void printHelloWorld3() throws SQLException {

        System.out.println("hello world!");

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Properties config = new Properties();
        config.put("access_id", "LTAIz*******");
        config.put("access_key", "0OUJUderj9*******");
        config.put("project_name", "sc_zj_zrryh");
        config.put("charset", "utf-8");
        Connection connreader = DriverManager.getConnection("jdbc:odps:https://service.odps.aliyun.com/api", config);
        Connection connwrite = DriverManager.getConnection("jdbc:odps:https://service.odps.aliyun.com/api", config);

        try {

            ResultSet rs;

            // create a table
            Statement stmt_reader = connreader.createStatement();

            stmt_reader.setFetchSize(10000);
            String tableName = "zj_sb_zxfjkc_cjxx_zy";

            // run sql
            String sql;

            // select * query
            sql = "select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145699";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000148230 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145700 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145701 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145702 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145703 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145704 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000148149 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000145706 ";
            sql = sql+ " union all select * from " + tableName + " where rfq <> '' and cjlsh <> 1000000000148437 ";
            System.out.println("Running: " + sql);
            rs = stmt_reader.executeQuery(sql);
            //rs.setFetchSize(10);

            //Statement stmt_write = connwrite.createStatement();
            String sqlWrite = "INSERT INTO test_sb_zxfjkc_01 VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = connwrite.prepareStatement(sqlWrite);

            System.out.println("123");
            Integer i = 0;
            Integer j = 0;
            while (rs.next()) {
                i++;
                ps.setLong(1, rs.getLong("cjlsh"));
                ps.setLong(2, rs.getLong("cjxh"));
                ps.setLong(3, rs.getLong("zrrdah"));
                ps.setString(4, rs.getString("zxfjkclx_dm"));
                ps.setString(5, rs.getString("cjrlx_dm"));
                ps.setString(6, rs.getString("cjrdah"));
                ps.setString(7, rs.getString("kjywrlb_dm"));
                ps.setString(8, rs.getString("kjywrdah"));
                ps.setString(9, rs.getString("sbkcnd"));
                ps.setString(10, rs.getString("xxxx"));
                ps.setString(11, rs.getString("kcyxqq"));
                ps.setString(12, rs.getString("kcyxqz"));
                ps.setString(13, rs.getString("cjrq"));
                ps.setString(14, rs.getString("yxbz"));
                ps.setString(15, rs.getString("bz"));
                ps.setString(16, rs.getString("dljgr"));
                ps.setString(17, rs.getString("dlcjrq"));
                ps.setString(18, rs.getString("dljbr"));
                ps.setString(19, rs.getString("dljbrzyzjhm"));
                ps.setString(20, rs.getString("lrr_dm"));
                ps.setString(21, rs.getString("lrrq"));
                ps.setString(22, rs.getString("xgr_dm"));
                ps.setString(23, rs.getString("xgrq"));
                ps.setString(24, rs.getString("sjgsdq"));
                ps.setString(25, rs.getString("sjxgdq"));
                ps.setString(26, rs.getString("slswjg_dm"));
                ps.setString(27, rs.getString("jyqd_dm"));
                ps.addBatch();
                if (i % 10000 == 0) {
                    ps.executeBatch();
                    //connwrite.commit();
                    ps.clearBatch();
                    j++;
                    System.out.println("batch"+j.toString());
                }
                //System.out.println(String.valueOf(rs.getInt(1)) + "\t" + rs.getString(2));
            }
        }
        finally {
            connreader.close();
            connwrite.close();
        }


    }
}
