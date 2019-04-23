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
  	stage('Code Coverage Testing - Python Builder') {
  		steps {
			 sh '''
			 			echo "*************************Running Nosetests with Python Builder*************************"
						if [ -n "${WORKSPACE:+1}" ]; then
    						  # Path to virtualenv cmd installed by pip
    						  # /usr/local/bin/virtualenv
    						  PATH=$WORKSPACE/venv/bin:/usr/local/bin:$PATH
    						  if [ ! -d "venv" ]; then
            					    virtualenv -p python3 venv
    						  fi
    						  . venv/bin/activate
						fi
						pip install -r src/pipelines/requirements.txt 
						cd ${WORKSPACE}/package/src
						nosetests --with-coverage --cover-package=services
						pylint --disable=C0103 services/api.py || exit 0
					'''
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