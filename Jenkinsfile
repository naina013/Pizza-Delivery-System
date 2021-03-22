
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
						new_version = Integer.toString(NEW_VERSION)
					
				}
				echo " ${NEW_VERSION}"
				echo "${new_version[0]} .  ${new_version[1]} . ${new_version[2]}"
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
