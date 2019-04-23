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
			  }
		  }	
	  }
	stage('Package Prep') {
	 	steps {
		  	sh '''
			  	echo "*************************Staging package*************************"
				cd ${WORKSPACE}
				mkdir package
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
	stage('Build/Tar Package') {
	  	steps {
		  sh '''
						echo "*************************Build/Tar Package*************************"
						cd ${WORKSPACE}
						tar -cvf doodle_build-${BUILD_NUMBER}.tar ${WORKSPACE}/package/*
						ls -ltr
				  '''
	  	}	
	 }
	} 
	post {
		always {
			cleanWs() 
		}
	}
}