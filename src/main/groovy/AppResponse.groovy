// package codes.orel

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import java.security.MessageDigest
import java.text.SimpleDateFormat

class AppResponse {

  String resp

  AppResponse(req) {
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText(req.body())
    object.first_name = "$object.first_name " + generateMD5(object.first_name)
    object.last_name = "$object.last_name " + generateMD5(object.last_name)
    object.current_time = date()
    object.say = 'Just try Groovy!'
    resp = JsonOutput.toJson(object)
  }

  def date() {
    def curr = new Date()
    def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
    sdf.format(curr)
  }
      
  def generateMD5(String s){
    if (s == null) s = '';
    MessageDigest.getInstance("MD5").digest(s.bytes).encodeHex().toString()
  }

}
