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
    			  extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: "rlennon/doodle/src"]], 
    			  submoduleCfg: [], 
   			    userRemoteConfigs: [[url: 'git@github.com:rlennon/doodle']]
    		  ])
			sh 'pwd'
				}
  		}	
	}
	stage('Package Prep') {
	 	steps {
		  	sh '''
			  	echo "*************************Staging package*************************"
				cd ${WORKSPACE}
				mkdir package
				cd package
				mkdir ui
				mkdir services
				cd ${WORKSPACE}/rlennon/doodle/src/src
				cp services ${WORKSPACE}/package/doodle/src/src/services ${WORKSPACE}/package
				cp ui ${WORKSPACE}/package/doodle/src/src/ui ${WORKSPACE}/package
				cp requirements.txt ${WORKSPACE}/package
				cp config.json ${WORKSPACE}/package
				cd ${WORKSPACE}/package
				ls -ltr
			'''
  		}	
	}
  }
}