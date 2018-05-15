node {
  stage('checkout') {
    git url:'https://github.com/spring-projects/spring-petclinic.git'
    //git url:'https://github.com/Accenture/spring-petclinic.git'
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
      sh "'${mvnHome}/bin/mvn' cobertura:cobertura"
    }
  }
  
  stage('archive artifacts') {
      junit '**/target/surefire-reports/*.xml'
      archive 'target/spring-petclinic-*.jar'
  }
  
  stage('sonar') {
    ansiColor('xterm') {
      withSonarQubeEnv('SonarQubeServer') {
        def scannerHome = tool 'sonarqubescanner';
	sh "${scannerHome}/bin/sonar-scanner"
      }
    }
  }
}

