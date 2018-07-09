pipeline {
    agent any

    stages {
      

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
