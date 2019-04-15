pipeline {
  agent any
  stages {
    stage('GitHub Pull') {
	  	steps {
		  	sh 'echo "*************************GitHub Pull*************************"'
			script {
			    scm_checkout.SCM_checkout(src/POC)
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
			# curl command pushes new build package into artifactory 
			sh "curl -u ${ARTIFACTORY_USER}:${ARTIFACTORY_PASSWORD} -X PUT "http://172.28.25.122:8081/artifactory/doodle-release-local/com/doodle/build/${build_label}/${build_label}.tar" -T ${WORKSPACE}/${build_label}.tar"
			# curl command to add metadata to build on artifactory
      # sh "curl -X PUT -u ${ARTIFACTORY_USER}:${ARTIFACTORY_PASSWORD} 'http://172.28.25.122:8081/artifactory/doodle-release-local/com/doodle/build/${build_label}/'/';ProjectName='${build_label}'"

 		}	
	}
  }
}
