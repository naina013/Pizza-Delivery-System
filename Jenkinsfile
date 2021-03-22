
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
						int hun = (NEW_VERSION / 100)
						int tens = (NEW_VERSION % 100)/10
						int ones = (NEW_VERSION % 100)%10
					
				}
				echo " ${NEW_VERSION}"
				println hun
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
