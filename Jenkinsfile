   def mvnHome
   stage('Build') {
     node {
       checkout scm
       mvnHome = tool 'M3'
       sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
       dir("target") {
         stash 'pack'
       }
       deleteDir()
     }
   }
   
   checkpoint 'continue_after_build'
   
   stage('Archive results') {
     node {
       dir("target") {       
         unstash 'pack'
       }
       junit '**/target/surefire-reports/TEST-*.xml'
       archive 'target/*.jar'
       deleteDir()
     }
   }

parallel ( 
   "Static code test" : { 
     stage('Static code test') {
         sleep 10
     } 
   },
   "Integration test" : { 
     stage('Integration test') {
       sleep 10
     } 
   }
)
   checkpoint 'continue_after_test'
   
   stage('Deploy') {
       input 'do you really want to deploy?'
       sleep 10
   }

