node(){
	dir("${env.BUILD_ID}"){
		
		//checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[credentialsId: 'GITHUB-cred', url: '<https://github.com/naina013/Pizza-Delivery-System/tree/Jenkinsfile>']],
		//branches: [[name: 'refs/tags/*']]]
		
		env.GIT_TAG_NAME = gitTagName()
		currentBuild.displayName = "#${BUILD_NUMBER}, ${JOB_NAME}, ${env.GIT_TAG_NAME}"
		
		tool name: 'Golang Installer', type: 'go'
		
		try{
				stage('BUILD'){
					echo 'Build'
					
					sh 'chmod 755 ${WORKSPACE}/${BUILD_ID}/config/shell/appVersion.sh && cd ${WORKSPACE}/${BUILD_ID}/config/shell/ && ./appVersionDev.sh'
					
				}
				}catch(e){
				currentBuild.result = "FAILED"
				throw e
				}finally{
					notifyBuild(currentBuild.result)	
		}
	}
}
	


//for grab git tag
String gitTagName(){
	commit = getCommit()
	if(commit){
		desc = sh(script: "git describe --tags ${commit}", returnStdout: true)?.trim()
		if(isTag(desc)){
			return desc
		}
	}
	return null
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
			steps{ echo 'building the application'}	
	} 
		stage('Print Build Number') {
			steps { 
				script{ 
					
						NEW_VERSION =  100 + Integer.parseInt(BUILD_NUMBER)
						hun = (int)(NEW_VERSION / 100)
						tens = (int)((NEW_VERSION % 100)/10)
						ones = (int)((NEW_VERSION % 100)%10)
					
				}
				echo " ${NEW_VERSION}"
				echo " ${hun} . ${tens} . ${ones}"
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
