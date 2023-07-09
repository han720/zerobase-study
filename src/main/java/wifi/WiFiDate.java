package wifi;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WiFiDate {

    public List<DbWIFI> list () {
        String url = "jdbc:mariadb://192.168.0.27:3306/test";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";
        List<DbWIFI> list = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "select XSWIFIMGRNO , XSWIFIWRDOFC , XSWIFIMAINNM , XSWIFIADRES1 ,XSWIFIADRES2 " +
                    ", XSWIFIINSTLFLOOR , XSWIFIINSTLTY , XSWIFIINSTLMBY , XSWIFISVCSE , XSWIFICMCWR " +
                    ", XSWIFICNSTCYEAR , XSWIFIINOUTDOOR , XSWIFIREMARS3 , LAT , LNT , WORKDTTM " +
                    "from wifi_information wi ";

            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                DbWIFI wifi = new DbWIFI();
                wifi.setxSwifiMgrNo(rs.getString("XSWIFIMGRNO"));
                wifi.setxSwifiWrdofc(rs.getString("XSWIFIWRDOFC"));
                wifi.setxSwifiMaimNm(rs.getString("XSWIFIMAINNM"));
                wifi.setxSwifiAdres1(rs.getString("XSWIFIADRES1"));
                wifi.setxSwifiAdres2(rs.getString("XSWIFIADRES2"));
                wifi.setxSwifiInstlFloor(rs.getString("XSWIFIINSTLFLOOR"));
                wifi.setxSwifiInstlTy(rs.getString("XSWIFIINSTLTY"));
                wifi.setxSwifiInstlMby(rs.getString("XSWIFIINSTLMBY"));
                wifi.setxSwifiSvcSe(rs.getString("XSWIFISVCSE"));
                wifi.setxSwifiCmcwr(rs.getString("XSWIFICMCWR"));
                wifi.setxSwifiCnstcYear(rs.getString("XSWIFICNSTCYEAR"));
                wifi.setxSwifiInoutDoor(rs.getString("XSWIFIINOUTDOOR"));
                wifi.setxSwifiRemars3(rs.getString("XSWIFIREMARS3"));
                wifi.setLnt(rs.getString("LNT"));
                wifi.setLat(rs.getString("LAT"));
                wifi.setWorkDttm(rs.getString("WORKDTTM"));
                list.add(wifi);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public void dbInsert (DbWIFI dbWifi) {
        String url = "jdbc:mariadb://192.168.0.27:3306/test";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "insert into wifi_information\n" +
                    "(XSWIFIMGRNO ,XSWIFIWRDOFC , XSWIFIMAINNM , XSWIFIADRES1 ,XSWIFIADRES2 \n" +
                    ", XSWIFIINSTLFLOOR , XSWIFIINSTLTY , XSWIFIINSTLMBY , XSWIFISVCSE , XSWIFICMCWR \n" +
                    ", XSWIFICNSTCYEAR , XSWIFIINOUTDOOR , XSWIFIREMARS3 , LAT , LNT , WORKDTTM )\n" +
                    "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dbWifi.getxSwifiMgrNo());
            preparedStatement.setString(2, dbWifi.getxSwifiWrdofc()); // 자치구
            preparedStatement.setString(3, dbWifi.getxSwifiMaimNm()); // 와이파이명
            preparedStatement.setString(4, dbWifi.getxSwifiAdres1()); // 도로명 주소
            preparedStatement.setString(5, dbWifi.getxSwifiAdres2()); // 상세주소
            preparedStatement.setString(6, dbWifi.getxSwifiInstlFloor()); // 설치 위치(층)
            preparedStatement.setString(7, dbWifi.getxSwifiInstlTy()); // 설치 유형
            preparedStatement.setString(8, dbWifi.getxSwifiInstlMby()); // 설치 기관
            preparedStatement.setString(9, dbWifi.getxSwifiSvcSe()); // 서비스 구분
            preparedStatement.setString(10, dbWifi.getxSwifiCmcwr()); // 망종류
            preparedStatement.setString(11, dbWifi.getxSwifiCnstcYear()); // 설치년도
            preparedStatement.setString(12, dbWifi.getxSwifiInoutDoor()); // 실내외구분
            preparedStatement.setString(13, dbWifi.getxSwifiRemars3()); // WIFI 접속 환경
            preparedStatement.setString(15, dbWifi.getLat()); // x좌표
            preparedStatement.setString(14, dbWifi.getLnt()); // y좌표
            preparedStatement.setString(16, dbWifi.getWorkDttm());

            int affencted = preparedStatement.executeUpdate();
            if (affencted > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public List<DbHistory> historySelect() {
        String url = "jdbc:mariadb://192.168.0.27:3306/test";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<DbHistory> list = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            String sql = " select ID , XLAT , YLNT ,DATETIME " +
                    "from history  ;";

            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                DbHistory dbHistory = new DbHistory();
                dbHistory.setId(Integer.parseInt(rs.getString("ID")));
                dbHistory.setMyLnt(rs.getString("XLAT"));
                dbHistory.setMyLat(rs.getString("YLNT"));
                dbHistory.setDate(rs.getString("DATETIME"));
                list.add(dbHistory);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void historyInsert(Double x, Double y) {
        String url = "jdbc:mariadb://192.168.0.27:3306/test";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";
        String lat = String.valueOf(x);
        String lnt = String.valueOf(y);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            int max = 1;
            WiFiDate wd = new WiFiDate();
            for (DbHistory h : wd.historySelect()) {
                if (max >= h.getId()) {
                    max = h.getId();
                }
            }
            if (max != 1) {
                max += 1;
            }

            String sql = "insert into  history " +
                    " (ID, XLAT, YLNT, `DATETIME`) " +
                    " values (?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(max));
            preparedStatement.setString(2, lat);
            preparedStatement.setString(3, lnt);
            preparedStatement.setString(4, String.valueOf(LocalDateTime.now()));

            int affendted = preparedStatement.executeUpdate();
            if (affendted > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void historyDelete (String id) {

        String url = "jdbc:mariadb://192.168.0.27:3306/test";
        String dbUserId = "testuser";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);
            String sql = "delete from history where ID = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            int affendted = preparedStatement.executeUpdate();
            if (affendted > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}














