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
    					extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/${SCM_Dir}"]], 
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
		  	sh 'echo "*************************Build/Tar Package*************************"'
				sh 'tar -cvf doodle_build-${BUILD_NUMBER}.tar ${WORKSPACE}/src/POC/*'
		  }	
	  }
  	stage('Artifactory Load') {
  		steps {
			  sh 'echo "*************************Artifactory Load*************************"'
 		  }	
	  }
  }
}
