pipeline {
    agent any

    environment {
        DOCKERHUB_CREDS = credentials('dockerhub-creds')
        DOCKER_USER = "rajeevreddy1511"
    }

    stages {

        stage('Build Backend') {
            steps {
                dir('backend') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker build -t $DOCKER_USER/backend-devops ./backend'
                sh 'docker build -t $DOCKER_USER/frontend-devops ./frontend'
            }
        }

        stage('Push Images') {
            steps {
                sh 'docker login -u $DOCKER_USER -p $DOCKERHUB_CREDS_PSW'
                sh 'docker push $DOCKER_USER/backend-devops'
                sh 'docker push $DOCKER_USER/frontend-devops'
            }
        }

        stage('Deploy to Minikube') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}

