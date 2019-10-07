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
				sh 'mvn clean install -Dquarkus.http.port=8084'
				}
            }
        }
		
        stage ('Deploy') {
            steps {
				dir("devopsnapratica"){
					echo 'Deploying...'
					script{
						zip archive: true, dir: 'target/', glob: '', zipFile: 'target/devopsnapratica.zip'
					}
					sh 'curl -v -u admin:admin123 --upload-file target/devopsnapratica.zip http://10.0.75.1:8082/nexus/content/repositories/snapshots/br/udesc/devopsnapratica.zip'				
				}

            }
        }
		
        stage ('Sonar') {
            steps {
				dir("devopsnapratica"){
					echo 'Deploying...'
					sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.2.107:9000 -Dsonar.username=admin -Dsonar.password=admin'				
				}

            }
        }
		
    }
}

