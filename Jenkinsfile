pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '8ef8f501-5664-43bb-bb71-fa2fe0ad2929', url: 'git@github.com:cuijiyao01/uni_data_response.git']]])
            }
        }
        stage('build project') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
    }
}
