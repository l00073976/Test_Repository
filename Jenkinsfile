@Library('utils') _

pipeline {
  agent any
  stages {
    stage('GitHub Pull') {
	  	steps {
		  	sh 'echo "*************************GitHub Pull*************************"'
				script {
						utils.SCM_checkout(vars/POC)
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
