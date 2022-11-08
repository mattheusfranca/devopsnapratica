pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'Inciando novo pipeline'
      }
    }

    stage('Build') {
      steps {
        dir(path: 'devopsnapratica') {
          echo 'Esse é um pipeline de exemplo'
          sh 'mvn clean build'
        }

      }
    }

    stage('Test') {
      steps {
        dir(path: 'devopsnapratica') {
          echo 'Deploying...'
          sh 'mvn test'
        }

      }
    }

  }
  tools {
    jdk 'jdk_1.8.0'
    maven 'Maven'
  }
}