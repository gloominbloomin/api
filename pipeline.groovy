pipeline {
    agent any
     environment {
        timestamp = "${sh(script:'(date +%Y%m%d%H%M%S)', returnStdout: true)}"
    }
    stages {
        stage('Git clone') {
            steps {
            git branch: 'master',
                // credentialsId: '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',
                url: 'git@github.com:gloominbloomin/api.git'
            }
        }
        stage ('Node') {
            steps {
                sh 'node --version'
            }
        }
        stage('Build') {
            steps {
                echo "Building  ${env.timestamp}..."
                sh('docker build -t $timestamp .')
            }
        }
        stage('Test') {
            steps {
                echo 'Testing... TODO!'
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying Docker Container ${env.timestamp}"
                sh "docker run -p 5000:8080 ${env.timestamp}"
            }
        }
    }
}

/*
pipeline {
    agent any
     environment {
        LS = "${sh(script:'$(date +%Y%m%d%H%M%S)', returnStdout: true)}"
    }
    stages {
        stage ('Generate Tag') {
            steps {
                // T = {$sh((script:'tag=node.$(date +%Y%m%d%H%M%S)'))}
                // sh 'tag=node.$(date +%Y%m%d%H%M%S)'
                // echo 'Generated tag: ${tag}'
                echo 'before'
                echo "${env.LS}"
                echo 'after'
            }
        }
        stage ('Node') {
            steps {
                // echo 'Node? tag: $tag'
                sh 'node --version'
            }
        }
        stage('Build') {
            steps {
                // echo 'Building "$tag" ...'
                // sh 'docker build -t $tag .'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                // echo 'Deploying Docker Container "$node_name"'
                // sh 'docker run -p 5000:8080 $tag'
            }
        }
    }
}
*/