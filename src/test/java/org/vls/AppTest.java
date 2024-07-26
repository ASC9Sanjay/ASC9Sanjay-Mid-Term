package org.vls;

import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
//import org.junit.jupiter.api.Beforeach.*;

public class AppTest {
    Service service = new Service();

    @Test
    void addToCart() {
        Course course = new Course(1, "java", "sanjay", 10, true);
        service.addToCart(course);
        List<Course> cart = service.getCartContents();
        assertTrue(cart.contains(course), "The cart should contain the course");
    }

    @Test
    void removeFromCart() {
        Course course = new Course(1, "java", "sanjay", 10, true);
        service.addToCart(course);
        service.removeFromCart(course);
        List<Course> cart = service.getCartContents();
        assertFalse(cart.contains(course), "The cart should not contain the course after removal");
    }
}

