/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jan
 */
@ManagedBean
@RequestScoped
public class Process_Login {
    private String username, password, response;
    
    
    /**
     * Connects to db to check if the user is even there and also if the user has supplied the correct password
     * @throws SQLException thrown when the sql fubars
     */
    public void ProcessLogin() throws SQLException{
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {         
            if(isUser()){
                if(isAuth()){
                    String type = getType();
                    if(type.equals("a")){
                        ec.redirect("admin?username="+getUsername());
                    } 
                    else
                    if(type.equals("i")){
                        ec.redirect("instructor.jsp?username="+getUsername());
                    } 
                    else
                    if(type.equals("s")){
                        ec.redirect("student.jsp?username="+getUsername());
                    } 
                    else{
                       response = "Invalid user type " + type; 
                    }
                    
                }
                else{
                    response = "Incorrect password for " + getUsername() + ".";
                }
            }
            else {
                response = getUsername() + " is not found.";
            }
        } catch (ClassNotFoundException ex) {
            response = ex.toString();
        } catch (SQLException ex) {
            response = ex.toString();
        } catch (IOException ex){
            response = ex.toString();
        }
    }
    private boolean isUser() throws SQLException, ClassNotFoundException{
        ResultSet r = db.DB.connects("select u from g1users where u='"+
                getUsername()+"'");
        if(r.next()){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isAuth() throws SQLException, 
            ClassNotFoundException{
        ResultSet r = db.DB.connects("select u from g1users where u='"+
                getUsername()+"' and p='"+getPassword()+"'");
        if(r.next()){
            return true;
        }
        else{
            return false;
        }
    }
    private String getType() throws SQLException,ClassNotFoundException{
        ResultSet r = db.DB.connects("select t from g1users where u='"
                +getUsername()+"'");
        if(r.next()){
            return r.getString(1);
        }
        else{
            return null;
        }
    }    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        if(username != null){
            if(username.length() != 0){
               if(password.length() != 0){
                    try {                    
                        ProcessLogin();
                    } catch (SQLException ex) {
                        response = ex.toString();
                    }
                }          
            }          
        }
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
}
