pipeline {
    agent any 
	tools { 
        jdk 'jdk_1.8.0'
        maven 'Maven' 
    }   
    stages {
        stage ('Initialize') {
            steps {
                 echo 'Inciando...'
            }
        }

        stage ('Build') {
            steps {
				dir("devopsnapratica"){
                echo 'Esse é um pipeline de exemplo'
				sh 'mvn install'
				sh 'docker build -f src/main/docker/Dockerfile.jvm -t quarkus/devopsnapratica-jvm .'
				}
            }
        }
		
    }
}