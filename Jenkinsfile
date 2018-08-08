node {

    def mvnHome

    stage('checkout') {
        scm checkout

        mvnHome = tool 'M3'
    }

    stage('Build & Unit test') {
        bat 'mvn clean verify -DskipITs=true'
        junit '**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.*'
    }


}