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
    					extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src/poc/Pythonclient"]], 
    					submoduleCfg: [], 
    					userRemoteConfigs: [[url: 'git@github.com:rlennon/doodle']]
    				])
					checkout([$class: 'GitSCM', 
   						branches: [[name: '*/master']], 
    					doGenerateSubmoduleConfigurations: false, 
    					extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src/poc/DoodleUI"]], 
    					submoduleCfg: [], 
    					userRemoteConfigs: [[url: 'git@github.com:rlennon/doodle']]
    				])
						checkout([$class: 'GitSCM', 
   						branches: [[name: '*/master']], 
    					doGenerateSubmoduleConfigurations: false, 
    					extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src/poc/PythonAPI"]], 
    					submoduleCfg: [], 
    					userRemoteConfigs: [[url: 'git@github.com:rlennon/doodle']]
    				])
						checkout([$class: 'GitSCM', 
   						branches: [[name: '*/master']], 
    					doGenerateSubmoduleConfigurations: false, 
    					extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src/ui"]], 
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
			sh 'cd ${WORKSPACE}/rlennon'
			sh 'ls -ltr '
			sh 'tar -cvf doodle_build-${BUILD_NUMBER}.tar ${WORKSPACE}/rlennon/doodle/src/*'
			sh 'ls -ltr'
		  }	
	  }
  	stage('Artifactory Load') {
  		steps {
			  sh 'echo "*************************Artifactory Load*************************"'
 		  }	
	  }
  }
}
