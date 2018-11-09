/*
 * Very simple HTTP server using http://sparkjava.com/
 *
 * Start the server with "groovy server.groovy".
 */

@Grab( group = 'com.sparkjava', module = 'spark-core', version = '2.1' )
import static spark.Spark.*
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import java.security.MessageDigest
import java.text.SimpleDateFormat

staticFileLocation '.'

post '/', { req, res -> build_res(req) }

def date() {
    curr = new Date()
    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    sdf.format(curr)
}
    
def build_res(req) {
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(req.body())
    object.first_name = "$object.first_name " + generateMD5(object.first_name)
    object.last_name = "$object.last_name " + generateMD5(object.last_name)
    object.current_time = date()
    object.say = 'Just try Groovy!'
    def json = JsonOutput.toJson(object)
    json
}

def generateMD5(String s){
    if (s == null) s = '';
    MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
}

println 'Enter to exit'
System.in.newReader().readLine()
println "Done"
stop()
