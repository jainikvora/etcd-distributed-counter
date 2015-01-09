package app.conrollers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import java.net.URI
import com.justinsb.etcd.EtcdResult
import app.config.EtcdConfig
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.HttpStatus


@RequestMapping(value = Array("/api/v1"))
@RestController
class EtcdController {
  
  @RequestMapping(method = Array(RequestMethod.GET), value = Array("/counter"))
  @ResponseStatus(HttpStatus.OK)
  def getCounter(): Any = {
    var key: String = "/010028941/counter"
    var result : EtcdResult = EtcdConfig.getEtcdClient.get(key)
    var counter : Int = result.node.value.toInt
    counter += 1
    result = EtcdConfig.getEtcdClient.set(key, counter.toString)
  	return result.node.value;
  }
  
  @RequestMapping(method = Array(RequestMethod.GET), value = Array("/checkstatus"))
  @ResponseStatus(HttpStatus.OK)
  def checkStatus(): Any = {
    return "Server is running";
  } 
}