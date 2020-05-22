package com.srik.springconfigcloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer  // to enable server and view via onlin url http://{host}/:={spring-application-name}/{profiling}
@SpringBootApplication
public class SpringConfigCloudServerApplication {

	/*
	 * create a local git repo in folder "local-git-repor"
	 * link that to spring cloud project by clikcing on link sourece option of project and intaiizing
	 * it by browsing its folder
	 * create a properties file in local git repo with name same as application name of limit service project
	 * and add the minLimit and maxlimit variables there with different values.
	 * now to connect spring-cloud-config server to local repo 
	 * application.properties file make an entry
	 * spring.cloud.config.server.git.uri=file:///Z:\Spring_boot_cloud_microservices_udemy\Projects\local-git-repo
	 * this can be local or deployed git url
	 * since we are using local one we have added file://
	 * 
	 */
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SpringConfigCloudServerApplication.class, args);
	}

}
