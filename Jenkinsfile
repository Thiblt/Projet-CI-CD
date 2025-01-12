pipeline {
    agent any
    tools{
        maven 'Maven 3.8.1'
    }

  
    environment {
        // Variables d'environnement
        DOCKER_REGISTRY = "docker.io"  // Docker Hub
        DOCKER_REPO = "ci-cd" // Repo Docker Hub
        SONARQUBE_URL = "http://localhost:9000" // URL serveur SonarQube
        SONARQUBE_CREDENTIALS = "Sonar-Global-Analysis" // Credential Jenkins pour SonarQube
        DOCKER_CREDENTIALS = "Docker-Hub" // Credential Jenkins pour Docker Hub
    }

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source
                echo 'Checkout'
            }
        }
        stage('Build') {
            steps {
                // Construire le projet
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    def mvnHome = tool 'Maven 3.8.1' //
                    withSonarQubeEnv('SonarQ') {
                        sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=ci-cd -Dsonar.projectName='ci-cd'"
                    }

                }
            }
        }
    }

    post {
        always {
            // Nettoyer l'environnement de travail après l'exécution du pipeline
            cleanWs()
        }
    }
}
