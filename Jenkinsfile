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
				dir("target")
					sh 'java -jar devopsnapratica-1.0-SNAPSHOT-runner.jar'
				}
            }
        }
		
    }
}