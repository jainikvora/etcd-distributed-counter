package app.config

import com.justinsb.etcd.EtcdClient
import java.net.URI

object EtcdConfig {
	def getEtcdClient : EtcdClient = {
	  return new EtcdClient(URI.create("http://54.67.21.96:4001"))
	}
}