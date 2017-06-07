def run_pipeline_stages() {
  stage("deploy a") {
    sh 'echo "deploy to env a"'
  }
}

return this;
