
node {
    stage('checkout') {
        git url:'https://github.com/spring-projects/spring-petclinic.git'
    }
    
    stage('build') {
        def mvnHome = tool 'M3'
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
    }
}
