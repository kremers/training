node("master") {
  checkout scm

  def rootDir = pwd() 
  def p1 = load "${rootDir}@script/Jenkinsfile_Build.groovy"  
  if(params.BUILD != "false") {
    p1.run_pipeline_stages()
  } else {
    p1.dummy_stages()
  }

  def p2 = load "${rootDir}@script/Jenkinsfile_Deploy.groovy"
  p2.run_pipeline_stages()

}
