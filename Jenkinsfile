
pipeline {
    agent any 
	stages{
		stage("build"){
			steps{ echo 'building the application'}	
	} 
		stage('Print Build Number') {
			steps { 
				script{
					NEW_VERSION = " 100 + ${BUILD_NUMBER} " ;
				}
				
				echo "${NEW_VERSION[0]} + '.' + ${NEW_VERSION[1]} + '.' + ${NEW_VERSION[2]}"
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
