// package codes.orel

// @Grab( group = 'com.sparkjava', module = 'spark-core', version = '2.1' )
import static spark.Spark.*
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import java.security.MessageDigest
import java.text.SimpleDateFormat

// import codes.orel.AppResponse

public class App {

  static void main(String[] args) {
    post '/', { req, res -> new AppResponse(req).resp }
    
    println 'Enter to exit'
    System.in.newReader().readLine()
    println "Done"
    
    stop()
  }

}
