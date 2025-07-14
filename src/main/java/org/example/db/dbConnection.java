package org.example.db;

import org.example.model.Student;
import java.sql.*;
import java.util.Map;

public class dbConnection {

    private String url;
    private String username;
    private String password;

    public dbConnection(String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    public void createTable(Map<String,String> koloneTip, String tableName) throws SQLException {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(tableName).append(" (");
        for (Map.Entry<String,String> entry : koloneTip.entrySet()){
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
        }
        sb.setLength(sb.length() - 2); // heq presjen dhe hapësirën e fundit
        sb.append(");");

        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sb.toString());
        }
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE IF EXISTS " + tableName;
        try(Connection conn = connect(); Statement stmt = conn.createStatement()){
            stmt.executeUpdate(sql);
        }
    }

    public void insertStudent(Student student) throws SQLException {
        if(student == null ){
            throw new IllegalArgumentException("Student ose ID e studentit nuk mund të jenë null");
        }

        // Kontrollo nëse studenti ekziston:
        if(getStudentById(student.getId()) != null){
            throw new IllegalArgumentException("Studenti me ID " + student.getId() + " ekziston.");
        }

        String sql = "INSERT INTO studentet (id, emri, mbiemri, mosha) VALUES (?, ?, ?, ?)";

        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getEmri());
            pstmt.setString(3, student.getMbiemri());
            pstmt.setInt(4, student.getMosha());
            pstmt.executeUpdate();
        }
    }

    public Student getStudentById(Integer id) throws SQLException {
        if(id == null) return null;

        String sql = "SELECT * FROM studentet WHERE id == ?";
        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new Student(
                        rs.getInt("id"),
                        rs.getString("emri"),
                        rs.getString("mbiemri"),
                        rs.getInt("mosha")
                );
            }
            return null;
        }
    }

    public void updateStudent(Integer id, Student student) throws SQLException {
        if(id == null || student == null){
            throw new IllegalArgumentException("Id ose student nuk mund të jenë null");
        }
        // Kontrollo nëse studenti ekziston:
        if(getStudentById(id) == null){
            throw new IllegalArgumentException("Studenti me ID " + id + " nuk ekziston.");
        }

        String sql = "UPDATE studentet SET emri = ?, mbiemri = ?, mosha = ? WHERE id = ?";

        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, student.getEmri());
            pstmt.setString(2, student.getMbiemri());
            pstmt.setInt(3, student.getMosha());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        }
    }

    public void deleteStudent(Integer id) throws SQLException {
        if(id == null){
            throw new IllegalArgumentException("Id nuk mund të jetë null");
        }

        String sql = "DELETE FROM studentet WHERE id = ?";

        try(Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
