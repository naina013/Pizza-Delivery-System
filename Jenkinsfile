
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
						Integer hun = (NEW_VERSION / 100)
						Integer tens = (NEW_VERSION % 100)/10
						Integer ones = (NEW_VERSION % 100)%10
					
				}
				echo " ${NEW_VERSION}"
				echo "${hun} .  ${tens} . ${ones}"
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
