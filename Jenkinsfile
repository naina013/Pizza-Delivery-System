//change1
node(){
	dir("${env.BUILD_ID}"){
	checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[url: 'https://github.com/naina013/Pizza-Delivery-System.git']], branches: [[name: 'refs/tags/*']]]
	
	env.GIT_TAG_NAME = gitTagName()
	currentBuild.displayName = "#${BUILD_NUMBER},${JOB_NAME}, ${env.GIT_TAG_NAME}"
	try{
		stage('BUILD'){
			echo 'BUILD'
			sh 'chmod 755 ${WORKSPACE}/${BUILD_ID}/appVersionDev.sh && cd ${WORKSPACE}/${BUILD_ID}/ && ./appVersionDev.sh'
		}
	}catch(e){
		currentBuild.result = "Failed"
		throw e
	} finally{
		notifyBuild(currentBuild.result)
	}
	}
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
def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus = buildStatus ?: 'SUCCESS'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }

  // Send notifications
 // slackSend (color: colorCode, message: summary)

 // hipchatSend (color: color, notify: true, message: summary)

 // emailext (
   //   subject: subject,
     // body: details,
      //recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    //)
}

//pipeline {
  //  agent any 
//	stages{
//		stage("build"){
//			steps{ 
//				echo 'building the application'
//		}
//	}
		
		//stage('Print Build Number') {
			//steps { 
				//script{ 
					//env.GIT_TAG_NAME = gitTagName()
					//currentBuild.displayName = "#${BUILD_NUMBER},${JOB_NAME}, ${env.GIT_TAG_NAME}"	
				//}
			//}
      //  }
//		stage("test"){
//			steps{ echo 'testing the application'}	
//	} 
	//	stage("deploy"){
	//		steps{ echo 'deploying the application'}	
	//} 
		
    //}
//}
