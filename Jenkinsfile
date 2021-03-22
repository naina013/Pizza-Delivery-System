
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
						hun = Integer.parseInt(NEW_VERSION / 100)
						tens = Integer.parseInt((NEW_VERSION % 100)/10)
						ones = Integer.parseInt((NEW_VERSION % 100)%10)
					
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
