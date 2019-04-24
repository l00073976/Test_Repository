pipeline {
  agent any
  stages {
    stage('Security Scanning') {
	  	steps {
		  	sh '''
			  echo "*************************Running Security scan for open ports*************************"
			  ls -ltr
			  if [ -n "${WORKSPACE:+1}" ]; then
    		 	# Path to virtualenv cmd installed by pip
    			# /usr/local/bin/virtualenv
    			PATH=$WORKSPACE/venv/bin:/usr/local/bin:$PATH
    			if [ ! -d "venv" ]; then
            	    virtualenv -p python3 venv
    			fi
    			    . venv/bin/activate
			  fi
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