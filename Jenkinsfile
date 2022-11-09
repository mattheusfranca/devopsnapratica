pipeline {
  agent any
  stages {
    stage('Inicializando') {
      steps {
        echo 'Inciando novo pipeline'
        sh 'ls'
      }
    }

    stage('Build') {
      steps {
        dir(path: 'devopsnapratica') {
          echo 'Construindo'
          sh 'mvn clean package -DskipTests'
          sh 'ls'
          dir(path: 'target') {
            sh 'ls'
          }

        }

      }
    }

  }
  tools {
    jdk 'jdk_1.8.0'
    maven 'Maven'
  }
}