pipeline {
    agent any

    stages {
        stage ('Build Application') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Execute Selenium') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Cluster Start') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn fabric8:cluster-start'
                }
            }
        }

         stage ('Deploy docker Image') {

                    steps {
                        withMaven(maven : 'maven_3_5_0') {
                            sh 'mvn fabric8:deploy'
                        }
                    }
                }
    }
    post {
      always {
        junit "target/surefire-reports/**.xml"
      }
      success {
            archive "target/**/*"
      }
    }
}