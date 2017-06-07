def run_pipeline_stages() {
   def mvnHome
   stage('Preparation') { // for display purposes
      checkout scm
      mvnHome = tool 'M3'
   }
   stage('Build') {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
      stash includes:'target/*.jar',name:'build_artifact'
   }
}

def dummy_stages() {
  stage('Preparation') {
    this.result = 'NOT_EXECUTED'
  }
  stage('Build') {
    this.result = 'NOT_EXECUTED'
  }
  stage('Results') {
    this.result = 'NOT_EXECUTED'
  }
}

return this;
