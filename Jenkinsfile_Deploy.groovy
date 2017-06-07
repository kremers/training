def run_pipeline_stages() {
  def extWorkspace = null
  if(params.RETRY_FROM != "") {
    def run = selectRun job: 'training_pipeline', selector: buildNumber(params.RETRY_FROM)
    extWorkspace = exwsAllocate selectedRun: run
  } else {
    extWorkspace = exwsAllocate 'diskpool1'
  }
    exws (extWorkspace) {
      stage("deploy a") {
        if(params.RETRY_FROM == "") unstash 'build_artifact'
        sh 'echo "deploy to env a"'
        sh 'ls'
      }
    }
}
return this;


