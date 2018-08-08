node {
    def mvnHome
    stage('checkout') {
        git 'https://github.com/lukmir/JenkinsPipelineExample.git'
        mvnHome = tool 'M3'
    }

    stage('Build & Unit test') {
        if (isUnix()) {
            sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
        } else {
            bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
        junit '**/target/surefire-reports/TEST-*.xml'
    }

    stage('Archive') {
        archive 'target/*.jar'
    }

    stage ('Publish in artifactory'){
        def server = Artifactory.newServer url: 'http://localhost:8081/artifactory/example-project/', credentialsId: 'artfactory-account'
        def uploadSpec = """{
      "files": [
        {
          "pattern": "target/*.war",
          "target": "example-project/${BUILD_NUMBER}/",
          "props": "Integration-Tested=Yes;Performance-Tested=No"
        }
      ]
    }"""
        server.upload(uploadSpec)
    }
}