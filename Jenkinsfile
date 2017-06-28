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
   stage('Results') {
     node {
       dir("target") {       
         unstash 'pack'
       }
       junit '**/target/surefire-reports/TEST-*.xml'
       archive 'target/*.jar'
       deleteDir()
     }
   }

