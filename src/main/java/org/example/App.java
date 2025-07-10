package org.example;

import java.sql.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/internship";
        String user = "postgres";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // a.
            ResultSet rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'");
            while (rs.next()) {
                String tableName = rs.getString("table_name");
                String abbreviatedName = StringUtils.abbreviate(tableName, 10);
                System.out.println("Abbreviated table name: " + abbreviatedName);
            }

            // b. Read all rows from the kursi table
            rs = stmt.executeQuery("SELECT * FROM kursi");
            while (rs.next()) {
                String id = ObjectUtils.defaultIfNull(rs.getString("id"), "N/A");
                String emri = rs.getString("emri");
                String kursi = rs.getString("kursi");
                Timestamp kohezgjatja = rs.getTimestamp("kohezgjatja");
                // Example:  ToStringBuilder
                String courseDetails = new ToStringBuilder(null)
                        .append("id", id)
                        .append("emri", emri)
                        .append("kursi", StringUtils.defaultString(kursi, "No Course"))
                        .append("kohezgjatja", kohezgjatja)
                        .toString();
                System.out.println(courseDetails);
            }

            // c. Query students with more than 10 points
            rs = stmt.executeQuery("SELECT * FROM studentet WHERE pike > 10");
            while (rs.next()) {
                String emri = ObjectUtils.defaultIfNull(rs.getString("emri"), "Unknown");
                String email = rs.getString("email");
                int pike = rs.getInt("pike");
                // Shembull: Formatimi i emrit dhe emailit duke perdorur  StringUtils
                String formattedName = StringUtils.capitalize(emri) + " (" + StringUtils.substringBefore(email, "@") + ")";
                System.out.println(formattedName + " - " + pike + " points");
            }

            // d. Add a student
            String insertSql = "INSERT INTO studentet (emri, email, birth_date, phone_number, pike) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, "idna");
            pstmt.setString(2, "idna.ademi@example.com");
            pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setString(4, "123-456-7890");
            pstmt.setInt(5, 15);

            pstmt.executeUpdate();

            // e.
            String updateSql = "UPDATE studentet SET pike = ? WHERE emri = ? AND email = ?";
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setInt(1, 20);
            pstmt.setString(2, "idna");
            pstmt.setString(3, "idna.ademi@example.com");
            pstmt.executeUpdate();

            // f.
            String deleteSql = "DELETE FROM studentet WHERE emri = ? AND email = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, "idna");
            pstmt.setString(2, "idna.ademi@example.com");
            pstmt.executeUpdate();

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //Mesazhi i exceptionit   me ane te StringUtils
            System.err.println("SQL Error: " + StringUtils.defaultString(e.getMessage(), "Unknown error"));
        }
    }
}