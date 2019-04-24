pipeline {
  agent any
  stages {
    stage('Security Scanning') {
	  	steps {
		  	sh '''
			  echo "*************************Running Security scan for open ports*************************"
			  ls -ltr
			  ./vars/Staging_security_port_scanning.py
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