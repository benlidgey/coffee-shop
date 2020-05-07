pipeline {
    environment {
        sonarLogin = credentials('sonar')
        sonarHostUrl = "http://192.168.1.145:9000"
    }
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Sonar') { 
            steps {
                sh 'mvn -Dsonar.login=$sonarLogin_PWD -Dsonar.host.url=$sonarHostUrl'
            }
        }
    }
}
