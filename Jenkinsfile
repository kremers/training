   def mvnHome
   stage('Build') {

     node {
       checkout scm
       
       println "Current branch ${env.BRANCH_NAME}"
       
       if(env.BRANCH_NAME == "ue2") {
         sh 'echo "I am on a test branch"'
       } else {
         sh 'echo "I am not on a test branch"'
       }
     
       mvnHome = tool 'M3'
       ansiColor('xterm') {
         sh "export MAVEN_COLOR=true; ${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"
       }
       dir("target") {
         stash 'pack'
       }
     }
   }
   
   stage('Results') {
     node {
       unstash 'pack'
       junit '**/target/surefire-reports/TEST-*.xml'
       archive 'target/*.jar'
     }
   }
   
   stage('Deploy') {
     node {
       sh 'sleep 10'
     }
   }


