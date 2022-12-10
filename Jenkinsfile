pipeline {

  agent any

  parameters {
    gitParameter branchFilter: 'origin.*/(.*)', defaultValue: 'develop', name: 'branch', type: 'PT_BRANCH'
    choice name: 'environment', choices: "dev\nstaging", description: 'deploy environment'
  }

  options {
    skipDefaultCheckout(true)
  }

  stages {

    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: "${params.branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'git@github.com:kesavakimmich/flywaydemo.git']]])
        script {
            env.commit_id = "${sh(script:'git rev-parse --short HEAD', returnStdout: true).trim()}"
            env.tag = "${params.branch}-${env.commit_id}"
        }
      }
    }

  }

}
