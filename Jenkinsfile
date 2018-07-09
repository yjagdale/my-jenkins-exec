pipeline {
    agent any

    stages {
        stage ('Build Application') {

            steps {
                    sh 'mvn clean compile'
            }
        }

        stage ('Execute Selenium') {

            steps {
                    sh 'mvn test'
            }
        }


        stage ('Cluster Start') {

            steps {
               
                sh 'mvn fabric8:cluster-start'
            }
        }

         stage ('Deploy docker Image') {

                    steps {
                        sh 'docker run -d --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start'
 
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
