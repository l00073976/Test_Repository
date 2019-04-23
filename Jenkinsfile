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
				cd ${WORKSPACE}/rlennon/doodle/src/src
				mv services ${WORKSPACE}/package
				mv ui ${WORKSPACE}/package
				mv requirements.txt ${WORKSPACE}/package
				mv config.json ${WORKSPACE}/package
				cd ${WORKSPACE}/package
				ls -ltr
			'''
  		}	
	}
  }
}