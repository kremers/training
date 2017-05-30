node {
   def mvnHome
   stage('Preparation') {
     //git branch: 'alternative_jenkinsfile1', url: 'https://github.com/kremers/training.git'
     //git 'https://github.com/kremers/training.git'
     checkout scm
     //git 'https://github.com/jglick/simple-maven-project-with-tests.git'
     mvnHome = tool 'M3'
   }
   stage('Build') {
     sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package" 
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
      deleteDir()
   }
}
