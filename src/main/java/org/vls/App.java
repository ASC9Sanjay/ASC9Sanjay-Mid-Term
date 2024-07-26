package org.vls;
import java.sql.SQLException;
import java.util.*;
public class App {
    public static void main (String [] args){
        Service service=new Service();
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.println("Available courses:");
            for(Course course: service.getAvailableCourses()){
                System.out.println(course);

            }
            System.out.println("Search for a course:");
            String searchParam=scanner.nextLine();
            Course foundCourse=service.searchCourses(searchParam);
            if(foundCourse !=null){
                System.out.println("Found Course:" + foundCourse);

            }else{
                throw new CourseNotFoundException("Course not found.");

            }
            System.out.println("\n Add to cart:");
            service.addToCart(foundCourse);
            System.out.println("\nCart Contents:");
            for(Course course: service.getCartContents()){
                System.out.println(course);
            }
        } catch(SQLException | CourseNotFoundException x){
            System.err.println("Error:" + x.getMessage());
        }finally{
            scanner.close();
        }
    }
}
