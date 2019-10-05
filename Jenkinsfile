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
				sh 'mvn install -Dquarkus.http.port=8082'
				}
            }
        }
		
        stage ('Deploy') {
            steps {
				dir("devopsnapratica"){
				echo 'Deploying...'
				zip archive: true, dir: 'target/', glob: '', zipFile: 'devopsnapratica'
                sh 'docker login -u admin -p admin 192.168.2.107:8123'
				sh 'curl -v -u admin:admin123 --upload-file devopsnapratica.zip http://localhost:8082/nexus/content/repositories/snapshots/br/udesc/devopsnapratica.zip'				
				}
            }
        }
		
    }
}

