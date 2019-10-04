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
				uploadArtifact("servidor-dev", "/target", "devopsnapratica-1.0-SNAPSHOT-runner.jar", 'java -jar devopsnapratica-1.0-SNAPSHOT-runner.jar')
				}
            }
        }
		
    }
}

def uploadArtifact(String configurationName, String sourcePath, String artifactName, String command = '') {
	sshPublisher(publishers: [
		sshPublisherDesc(configName: configurationName,
		transfers: [
			sshTransfer(cleanRemote: false, excludes: '', execCommand: command, execTimeout: 600000,
				flatten: false, makeEmptyDirs: true, noDefaultExcludes: false, patternSeparator: '[, ]+',
				remoteDirectorySDF: false, removePrefix: sourcePath, sourceFiles: "${sourcePath}${artifactName}"
			)
		], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)
	])
}
