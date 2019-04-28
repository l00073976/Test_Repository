pipeline {
  agent any
  stages {
    stage('Testing') {
      steps {
            Acceptance_Test(${STAGING_ENDPOINT})
      }
    }
  }
	post {
		always {
			cleanWs()
		}
	}
}
