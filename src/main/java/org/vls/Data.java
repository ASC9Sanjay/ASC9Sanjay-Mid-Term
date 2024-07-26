package org.vls;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
public class Data {
    private static final String URL ="jdbc:mysql://localhost:3306/VLSDB";
    private static final String User="root";
    private static final String Password="Sanjay@5001";
    public List<Course> getAllCourse() throws SQLException{
        List<Course> courses=new ArrayList<>();
        String query="SELECT* FROM COURSES";
        try (Connection con=DriverManager.getConnection(URL,User,Password);
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery(query)) {
            while (rs.next()){
                Course course=new Course(rs.getLong("CourseId"),
                        rs.getString("CourseName"),
                        rs.getString("AuthorName"),
                        rs.getLong("Duration"),
                        rs.getBoolean("Available"));
                courses.add(course);
            }

        }
        return courses;

    }
    public Course findCourseByNameOrAuthor(String searchParam) throws
            SQLException{
        String query="SELECT * FROM Course WHERE CourseName=? OR AuthorName=?";
        Course course=null;
        try(Connection con=DriverManager.getConnection(URL,User,Password);
            PreparedStatement ps=con.prepareStatement(query)){
            ps.setString(1,searchParam);
            ps.setString(2,searchParam);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    course=new Course(
                            rs.getLong("CourseId"),
                            rs.getString("CourseName"),
                            rs.getString("AuthorName"),
                            rs.getLong("Duration"),
                            rs.getBoolean("Available")

                    );
                }
            }

        }
        return course;
    }
}
