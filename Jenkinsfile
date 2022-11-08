pipeline {
  agent any
  stages {
    stage('Inicializando') {
      steps {
        echo 'Inciando novo pipeline'
      }
    }

    stage('Build') {
      steps {
        dir(path: 'devopsnapratica') {
          echo 'Construindo'
          sh 'mvn clean package'
        }

      }
    }

    stage('Test') {
      steps {
        dir(path: 'devopsnapratica') {
          echo 'Testando'
          sh 'mvn test'
        }

      }
    }

    stage('Implanta��o') {
      steps {
        sh 'mvn sonar:sonar'
      }
    }

    stage('Finalizando') {
      steps {
        echo 'Integra��o conclu�da'
      }
    }

  }
  tools {
    jdk 'jdk_1.8.0'
    maven 'Maven'
  }
}