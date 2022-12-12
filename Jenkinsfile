pipeline {

  agent any

  parameters {
//     gitParameter branchFilter: 'origin.*/(.*)', defaultValue: 'develop', name: 'branch', type: 'PT_BRANCH'
    choice name: 'environment', choices: "dev\nstaging", description: 'deploy environment'
  }

  options {
    skipDefaultCheckout(true)
  }

  stages {

    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: "develop"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kesavakimmich/flywaydemo.git']]])
        script {
            env.commit_id = "${sh(script:'git rev-parse --short HEAD', returnStdout: true).trim()}"
            env.tag = "${params.branch}-${env.commit_id}"
        }
      }
    }

    stage('Build') {
      steps {
        sh "./mvnw package -DskipTests"
      }
    }

    stage('ECR push') {
      steps {
        sh "docker build -f Dockerfile -t kesavakimmich/flyway-demo:${env.tag} ."
        sh "docker push kesavakimmich/flyway-demo:${env.tag}"
      }
    }

    stage('Deploy') {

    }

  }

}
