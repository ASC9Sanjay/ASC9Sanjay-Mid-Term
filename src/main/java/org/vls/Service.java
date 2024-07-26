package org.vls;

import java.sql.SQLException;
import java.util.*;
public class Service {
    private Data data=new Data();
    private List<Course> cart=new ArrayList<>();
    public List<Course> getAvailableCourses() throws SQLException{
        return data.getAllCourse();
    }
    public void addToCart(Course course){
        cart.add(course);
    }
    public void removeFromCart(Course course){
        cart.remove(course);
    }
    public List<Course> getCartContents(){
        return cart;
    }
    public Course searchCourses(String searchParam) throws SQLException{
        return data.findCourseByNameOrAuthor(searchParam);
    }

}
