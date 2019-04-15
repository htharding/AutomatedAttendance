package sample;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.opencv.videoio.VideoCapture;

import utilities.Utilities;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.FaceDetectionController;

public class Engine {
    private int timer2;
    private int faceSum;
    private int faceNum;
    private boolean active;
    private String lastName;
    private String lastNum;

    public Engine() {
        this.timer2=0;
        this.faceSum = 0;
        this.faceNum = 0;
        this.lastName = "";
        this.lastNum = "9999";
        this.active = true;

    }

    public void newData(int numberOfFaces, String className, String classNum, LocalDateTime date){
        if ((this.active == true && className != this.lastName) || (this.active == true && classNum != this.lastNum)){
            if (timer2 <= 270) {
                this.faceSum += numberOfFaces;
                this.faceNum += 1;
                this.timer2++;
                System.out.println("Saw: " + this.faceSum + " faces over: " + this.faceNum + " iterations.");

            } else {
                this.active = false;
                System.out.println(this.faceSum / this.faceNum);
                this.lastName = className;
                this.lastNum = classNum;
                this.sendData(this.faceSum / this.faceNum, className, classNum, date);
                this.timer2 = 0;
                this.faceSum = 0;
                this.faceNum = 0;

            }
        } else if(!(className.equals(this.lastName)) || !(classNum.equals(this.lastNum))){
            System.out.println(className + " was not equal to " + this.lastName + " or " + classNum + " was not equal to " + this.lastNum  );
            this.active = true;
        }

    }

    public void sendData(Integer result, String className, String classNum, LocalDateTime date) {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/EMP";

        //  Database credentials
        final String USER = "username";
        final String PASS = "password";

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Attendance " +
                "VALUES(" + className + ", " +
                        classNum + ", " +
                        date + ")";

            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL Execution ran");

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");


    }


}


