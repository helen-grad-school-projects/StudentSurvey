// This assignment was submitted by Helen Glass. This Jenkinsfile is used to deploy build and deploy the containerized
// Tomcat application to a Kubernetes Cluster.

// Create image variable for re-use across stages
def imageName = "helencglass/student-survey-api:${BUILD_TIMESTAMP}"

pipeline {
  agent any

  stages {
    stage('Docker Build') {
      steps {
        // Build the Docker image
        sh "docker build -t ${imageName} ."
      }
    }

    stage('Docker Push') {
      steps {
        // Login to Dockerhub
        sh "docker login -u helencglass -p ${DOCKERHUB_PASS}"
        // Build the Docker image
        sh "docker push ${imageName}"
      }
    }

    stage('Deploy to K8s') {
      steps{
        // Deploy image to K8s cluster
        sh "kubectl set image deployment/springboot-deployment container-0=${imageName}"
      }
    }

  }
}