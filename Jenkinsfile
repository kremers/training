node {
  def p1 = load("Jenkinsfile_Build")
  p1.run_pipeline_stages()

  def p2 = load("Jenkinsfile_Deploy")
  p2.run_pipeline_stages()
}
