node {
  stage('checkout') {
    git url:'https://github.com/spring-projects/spring-petclinic.git'
  }
  stage('build') {
    ansiColor('xterm') {
      def mvnHome = tool 'M3'
      sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
  }

  stage('Cubertura') {
    ansiColor('xterm') {
      def mvnHome = tool 'M3'
      sh "'${mvnHome}/bin/mvn' cobertura:cobertura -Dcobertura.report.format=xml"
    }
  }

  stage('archive artifacts') {
      junit '**/target/surefire-reports/*.xml'
      archive 'target/spring-petclinic-*.jar'
  }
  stage('sonar') {

   sh '''echo "sonar.projectKey=petclinic" >> sonar-project.properties
   echo "sonar.projectName=petclinic" >> sonar-project.properties
   echo "sonar.projectVersion=1.0" >> sonar-project.properties
   echo "sonar.sources=src/main/java/" >> sonar-project.properties
   echo "sonar.language=java" >> sonar-project.properties
   echo "sonar.java.binaries=**/target/classes" >> sonar-project.properties'''

   def scannerHome = tool 'SonarQubeScanner';
    ansiColor('xterm') {
      withSonarQubeEnv('SonarQubeServer') {
        sh "${scannerHome}/bin/sonar-scanner"
      }
    }
  }
}
