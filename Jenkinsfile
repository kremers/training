      def mvnHome
   stage('Build') {
     node {
       checkout scm
       println "Current branch ${env.BRANCH_NAME}"
       mvnHome = tool 'M3'
       ansiColor('xterm') {
         sh "export MAVEN_COLOR=true; ${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"
       }
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
     }
   }
   
   stage('Deploy') {
     node {
       sh 'sleep 10'
     }
   }


