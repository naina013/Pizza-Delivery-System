//change1
node(){
	checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[url: 'https://github.com/naina013/Pizza-Delivery-System.git']], branches: [[name: 'refs/tags/*']]]
}
//for grab git tag
String gitTagName(){
	commit = getCommit()
	if(commit){
		desc = sh(script: 'git describe --tag $(git rev-parse --verify refs/remote/origin)', returnStdout: true)?.trim()
		if(isTag(desc)){
			return desc
		}
	}
	return null
	//return commit
}
String getCommit(){
	return sh(script: 'git rev-parse HEAD', returnStdout: true)?.trim()
}

@NonCPS
boolean isTag(String desc){
	match = desc =~ / .+-[0-9]+-g[0-9A-Fa-f]{6,}$/
	result = !match
	match = null // prevent serialisation
	return result
}

pipeline {
    agent any 
	stages{
		stage("build"){
			steps{ 
				echo 'building the application'
				sh 'chmod 755 ${WORKSPACE}/${BUILD_ID}/config/shell/appVersionDev.sh && cd ${WORKSPACE}/${BUILD_ID}/config/shell/ && ./appVersionDev.sh'
			}	
	} 
		stage('Print Build Number') {
			steps { 
				script{ 
					env.GIT_TAG_NAME = gitTagName()
					currentBuild.displayName = "#${BUILD_NUMBER},${JOB_NAME}, ${env.GIT_TAG_NAME}"	
				}
			}
        }
		stage("test"){
			steps{ echo 'testing the application'}	
	} 
		stage("deploy"){
			steps{ echo 'deploying the application'}	
	} 
		
    }
}
