pipeline {
    agent any 
    stages {
        stage ('Build Backend') {
            steps {
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage ('Unit Test') {
            steps{
                bat 'mvn test'
            }
        }
        stage ('Sonar Analysis') {
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                    bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http:/localhost:9000 -Dsonar.login=2004132d0573fa07b732edb1f975b926dcb7dc1c -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/scr/test/**,**/model/**,**Application.java"
                }
            }
        }
        stage ('Deploy backend') {
            steps {
                deploy adapters: [tomcat8(credentialsId: 'TomCatLogin', path: '', url: 'http://localhost:8080/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'
            }
        }
    }
}

