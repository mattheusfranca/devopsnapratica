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
						
				}

            }
        }
		
        stage ('Sonar') {
            steps {
				dir("devopsnapratica"){
					echo 'Deploying...'
					sh 'mvn sonar:sonar -Dsonar.host.url=http://172.17.0.1:9000 -Dsonar.login=6984cd079479b179aa967b2184113cbc72b2dc19
				}

            }
        }
		
    }
}

