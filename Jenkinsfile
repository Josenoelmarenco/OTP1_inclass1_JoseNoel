pipeline {
    agent any

    // Use the Maven installation configured in "Manage Jenkins > Tools" (named Maven3).
    // This is what prevents the "Cannot run program mvn" error.
    tools {
        maven 'Maven3'
    }

    environment {
        // Make Docker (and Homebrew tools) reachable from the Jenkins service on macOS.
        // Jenkins starts with a minimal PATH, so we prepend the usual install locations.
        PATH = "/usr/local/bin:/opt/homebrew/bin:${PATH}"
        // Docker Hub namespace/repository for the image
        IMAGE = "jnmarenco/temperature-converter"
    }

    stages {
        stage('Checkout') {
            steps {
                // Uses the Git repo configured in the job (Pipeline script from SCM)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }

        stage('Docker Build') {
            steps {
                // Build the image and tag it twice: with the build number and 'latest'
                sh 'docker build -t $IMAGE:$BUILD_NUMBER -t $IMAGE:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                // 'dockerhub' is a Username/Password credential created in Jenkins
                withCredentials([usernamePassword(
                        credentialsId: 'dockerhub',
                        usernameVariable: 'DH_USER',
                        passwordVariable: 'DH_PASS')]) {
                    sh 'echo "$DH_PASS" | docker login -u "$DH_USER" --password-stdin'
                    sh 'docker push $IMAGE:$BUILD_NUMBER'
                    sh 'docker push $IMAGE:latest'
                }
            }
        }
    }

    post {
        always {
            // Best-effort logout at the end of every run
            sh 'docker logout || true'
        }
    }
}
