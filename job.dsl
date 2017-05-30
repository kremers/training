job('nice_training') {
  logRotator(-1, 5)
  steps {
    shell('echo "Nice training"')
  }
}

listView('training') {
    jobs { regex('.*ain.*') }
    columns {
      status()
      weather()
      name()
      lastFailure()
      lastSuccess()
      lastDuration()
      nextLaunch()
      buildButton()
      lastBuildConsole()
}}


pipelineJob('training_pipeline_1') {
    definition {
        cpsScm {
          scriptPath('Jenkinsfile')
          scm {
           git('https://github.com/kremers/training.git','master')
          }
        }
    }
}
