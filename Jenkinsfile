
pipeline {
    agent any 
	stages{
		stage("build"){
			steps{ echo 'building the application'}	
	} 
		stage('Print Build Number') {
			steps { 
				script{ 
					if(BUILD_NUMBER >0 && BUILD_NUMBER <= 9){
					NEW_VERSION =  10 + BUILD_NUMBER
					}else{
						NEW_VERSION =  1 + BUILD_NUMBER
					}
				}
				echo " ${NEW_VERSION}"
				echo "${NEW_VERSION[0]} .  ${NEW_VERSION[1]} . ${NEW_VERSION[2]}"
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
