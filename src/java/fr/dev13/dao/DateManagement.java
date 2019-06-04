/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dev13.dao;

/**
 *
 * @author ESIC
 */
public class DateManagement {
    
        public static java.util.Date dateSql2Java(java.sql.Date dateSql){
        java.util.Date dateJava;
        if (dateSql==null)
             dateJava = null;
        else{
            dateJava = new java.util.Date(dateSql.getTime());
        }
        return dateJava;
    }
    
    public static String currentDateTimeJava2Sql(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
    
    public static String DateTimeJava2Sql(java.util.Date dt){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = sdf.format(dt);
        return dateTime;
    }
    
    public static String DateJava2Sql(java.util.Date dt){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dt);
        return date;
    }
    
    public static String currentDateJava2Sql(){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
}
