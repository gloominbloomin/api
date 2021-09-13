pipeline {
    agent any
    stages {
        stage ('Generate Tag') {
            sh 'tag=node.$(date +%Y%m%d%H%M%S)'
        }
        stage ('Node') {
            steps {
                sh 'node --version'
            }
        }
        stage('Build') {
            steps {
                echo 'Building $tag ...'
                sh 'docker build -t $tag .'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying Docker Container $node_name'
                sh 'docker run -p 5000:8080 $tag'
            }
        }
    }
}