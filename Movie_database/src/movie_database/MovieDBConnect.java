/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie_database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Date;
/**
 *
 * @author calpo
 */
public class MovieDBConnect extends DBConnection {
    /**
     * Creates a new instance of the connection class, and creates a
     * connection to the named database
     * @param dbName Service name of database
     */
    public MovieDBConnect(final String dbName) {
        this.connectDatabase(dbName);
    }

    /**
     * Insert a new movie record into the database
     * @param id
     * @param budget
     * @param homepage
     * @param original_language
     * @param original_title
     * @param overview
     * @param popularity
     * @param release_date
     * @param revenue
     * @param runtime
     * @param release_status
     * @param tagline
     * @param title
     * @param vote_average
     * @param vote_count
     */
    public void insertMovie(final int id, final int budget,
            final String homepage, final String original_language, final String original_title,
            final String overview, final float popularity, final Date release_date, final int revenue,
            final int runtime, final String release_status, final String tagline, final String title,
            final float vote_average, final int vote_count) {
        final String insertStmt = "INSERT INTO movie (id, budget, homepage, original_language, original_title, overview, popularity, release_date, revenue, runtime, release_status, tagline, title, vote_average, vote_count) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try  {
            PreparedStatement pstmt = getConnection().prepareStatement(insertStmt);
            pstmt.setInt(1, id);
            pstmt.setInt(2, budget);
            pstmt.setString(3, homepage);
            pstmt.setString(4, original_language);
            pstmt.setString(5, original_title);
            pstmt.setString(6, overview);
            pstmt.setFloat(7, popularity);
            pstmt.setDate(8, release_date);
            pstmt.setInt(9, revenue);
            pstmt.setInt(10, runtime);
            pstmt.setString(11, release_status);
            pstmt.setString(12, tagline);
            pstmt.setString(13, title);
            pstmt.setFloat(14, vote_average);
            pstmt.setInt(15, vote_count);
            pstmt.executeUpdate();
        }  catch (SQLException sqle) {
            System.out.println("Exception when inserting new movie record: " + sqle.toString());
        }
    }

    /**
     * Delete a movie record from the database
     * @param id movie identifier
     */
    public void deleteMovie(final int id) {
        final String deleteStmt = "DELETE FROM movie WHERE id = ?";
        try  {
            PreparedStatement pstmt = getConnection().prepareStatement(deleteStmt);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }  catch (SQLException sqle) {
            System.out.println("Exception when deleteting movie record: " + sqle.toString());
        }
    }
    
    /**
     * Print out all the records contained in the student table.   Prints
     * to System.out. 
     */
    public void printAllMovies() {
        final String retrieveQuery = "SELECT * from movie";
        this.setQuery(retrieveQuery);
        this.runQuery();
        ResultSet output = this.getResultSet();
        try  {
            if (null != output)  {
                while(output.next()) {
                    String id = output.getString(0);
                    String fname = output.getString(2);
                    String sname = output.getString(3);
                    String studid = output.getString(4);
                    System.out.println(id + ":" + fname + " " + sname + " " + studid);
                }
            }
        } catch (SQLException sqle) {
            System.out.println("Exception when printing all students: " + sqle.toString());
        }
    }
    
    /**
     * update a movie record
     * @param id
     * @param budget
     * @param homepage
     * @param original_language
     * @param original_title
     * @param overview
     * @param popularity
     * @param release_date
     * @param revenue
     * @param runtime
     * @param release_status
     * @param tagline
     * @param title
     * @param vote_average
     * @param vote_count
     */
    public void updateMovie(final int id, final int budget,
            final String homepage, final String original_language, final String original_title,
            final String overview, final float popularity, final Date release_date, final int revenue,
            final int runtime, final String release_status, final String tagline, final String title,
            final float vote_average, final int vote_count) {
            final String updateStmt = "UPDATE movie set id=?, budget=?, homepage=?, original_language=?, original_title=?, overview=?, popularity=?, release_date=?, revenue=?, runtime=?, release_status=?, tagline =?, title= ?, vote_average=?, vote_count=? WHERE id = " + id;
        try  {
            PreparedStatement pstmt = getConnection().prepareStatement(updateStmt);
            pstmt.setInt(1, id);
            pstmt.setInt(2, budget);
            pstmt.setString(3, homepage);
            pstmt.setString(4, original_language);
            pstmt.setString(5, original_title);
            pstmt.setString(6, overview);
            pstmt.setFloat(7, popularity);
            pstmt.setDate(8, release_date);
            pstmt.setInt(9, revenue);
            pstmt.setInt(10, runtime);
            pstmt.setString(11, release_status);
            pstmt.setString(12, tagline);
            pstmt.setString(13, title);
            pstmt.setFloat(14, vote_average);
            pstmt.setInt(15, vote_count);
            pstmt.executeUpdate();
        }  catch (SQLException sqle) {
            System.out.println("Exception when updating movie record: " + sqle.toString());
        }
    }
}