#!/usr/bin/env groovy

pipelines.jenkins_shared_libraries.vars

def Acceptance_Test(ENDPOINT) {
    sh '''
        echo "*************************Testing connection to the Endpoint*************************"
        if curl -v ${ENDPOINT} 2>&1 | grep "HTTP/1.1 200 OK"
        then
	        echo "Deployment Successful!"
          else
	          echo "Endpoint Test not successful, please investigate!"
	          exit 1
          fi
      '''
}