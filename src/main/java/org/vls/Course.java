package org.vls;
import java.util.*;
public class Course {
    private long courseId;
    private String courseName;
    private String authorName;
    private long duration;
    private boolean available;
    public Course(long courseId,String courseName, String authorName,long duration,boolean available){
        this.courseId=courseId;
        this.courseName=courseName;
        this.authorName=authorName;
        this.duration=duration;
        this.available=available;

    }
    @Override
    public String toString() {
        return "Course{" + "courseId="+ courseId + ",courseName="+ courseName +'\''+", authorName='"+authorName+'\''+
                "duration=" + duration + ",available="+ available+'}';
    }
}
