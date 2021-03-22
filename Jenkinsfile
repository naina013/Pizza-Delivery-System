//static def printbn() {
  //  sh '''
    //#!/usr/bin/env bash

    //echo ${BUILD_NUMBER} 
    // directly access any Jenkins build-in environment variable
    //'''
//}
pipeline {
    agent any 
	stages{
		stage("build"){
			steps{ echo 'building the application'}	
	} 
		stage('Print Build Number') {
			steps { echo "${BUILD_NUMBER}" }
        }
		stage("test"){
			steps{ echo 'testing the application'}	
	} 
		stage("deploy"){
			steps{ echo 'deploying the application'}	
	} 
		
    }
}
