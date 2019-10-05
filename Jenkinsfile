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
				sh 'mvn install -Dquarkus.http.port=8084'
				}
            }
        }
		
        stage ('Deploy') {
            steps {
				dir("devopsnapratica"){
					echo 'Deploying...'
					script{
						zip archive: true, dir: 'target/', glob: '', zipFile: 'devopsnapratica.zip'
					}
					sh 'curl -v -u admin:admin --upload-file devopsnapratica.zip http://192.168.2.105:8082/nexus/content/repositories/snapshots/br/udesc/devopsnapratica.zip'				
				}
				post {
                   always {
                        deleteDir()
                   }
                }

            }
        }
		
    }
}

