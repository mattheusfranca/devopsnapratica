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

    stage('Implantacao') {
      steps {
        echo 'Pulando implantação'
      }
    }

    stage('Finalizando') {
      steps {
        echo 'Pipeline executado com sucesso!'
      }
    }

  }
  tools {
    jdk 'jdk_1.8.0'
    maven 'Maven'
  }
}