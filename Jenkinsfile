pipeline {
  agent any
  stages {
    stage('GitHub Pull') {
	  	steps {
		  	sh 'echo "*************************GitHub Pull*************************"'
			script {
				checkout([$class: 'GitSCM', 
   		   	branches: [[name: '*/master']], 
    			doGenerateSubmoduleConfigurations: false, 
    			extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src/POC"]], 
    			submoduleCfg: [], 
   			 userRemoteConfigs: [[url: 'git@github.com:rlennon/doodle']]
    		])
			}
		}	
	}
  	stage('Sonar Testing') {
  		steps {
			 sh 'echo "*************************Sonar Testing*************************"'
		  }	
	  }
				stage('Build/Tar Package') {
	  	steps {
			build_Label = doodle_build-${BUILD_NUMBER}
		  sh 'echo "*************************Build/Tar Package*************************"'
			sh 'tar -cvf ${build_label}.tar ${WORKSPACE}/src/POC/*'
			sh 'ls -ltr'
		}	
	  }
  	stage('Artifactory Load') {
  		steps {
			sh 'echo "*************************Artifactory Load*************************"'
			sh 'echo "curl command pushes new build package into artifactory"
			sh 'curl -u ${ARTIFACTORY_USER}:${ARTIFACTORY_PASSWORD} -X PUT "http://172.28.25.122:8081/artifactory/doodle-release-local/com/doodle/build/${build_label}/${build_label}.tar" -T ${WORKSPACE}/${build_label}.tar'
		  }	
	  }
  }
}
