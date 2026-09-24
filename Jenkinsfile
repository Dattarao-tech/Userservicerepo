pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t userservice-app .'
            }
        }

        stage('Docker Deploy') {
            steps {
                bat 'docker rm -f userservice-container'
                bat 'docker run -d -p 8080:8080 --name userservice-container userservice-app'
            }
        }
    }
}