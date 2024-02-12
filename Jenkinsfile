pipeline {
    agent any
    stages {
        stage('stage 1 github') {
            steps {
                checkout scm
            }
        }

        stage('stage 2 compiler') {
            steps {
                sh 'mvn clean compile'
            }
        }

stage('stage 3 sonarqube') {
               steps {
                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=aziz'
                     }

        }
             stage('stage 4 JUNIT/MOCKITO') {
                                              steps {
                                                      sh 'mvn test'
                                                    }
                                                }
         stage('stage 5 nexus') {
                                 steps {
                                        sh 'mvn deploy -DskipTests=true'
                                             }
                                      }

stage('stage 6 Docker images')
                 {
                      steps {
                         sh 'docker build -t kaddemimage:v${BUILD_NUMBER} -f Dockerfile ./'
                               }

                 }
                 stage('dockerhub') {
                                                              steps {

                                                         sh "docker login -u azizjaziri48 -p Azizjaziri2000"
                                                         sh "docker tag kaddemimage:v${BUILD_NUMBER} azizjaziri48/azizjaziri48-5infini2-g1-kaddem:kaddemimage"
                                                         sh "docker push  azizjaziri48/azizjaziri48-5infini2-g1-kaddem:kaddemimage"
                                                              }
                                        }

 }

    post {
            success {
                mail bcc: '',
                body: '''
                'Dear Aziz ,
                we are happy to inform you that your pipeline build was successful.
                Great work!
                    -Jenkins Team - ''',
                cc: '',
                from: 'jaziri.aziz@yahoo.com',
                replyTo: '',
                subject: 'Build Finished - Success',
                to: 'jaziri.aziz@yahoo.com'
            }

            failure {
                mail bcc: '',
                body: '''
                'Dear Aziz,
                we are sorry to inform you that your pipeline build failed.
                Keep working!
                    -Jenkins Team - ''',
                cc: '',
                from: 'jaziri.aziz@yahoo.com', replyTo: '',
                subject: 'Build Finished - Failure', to: 'jaziri.aziz@yahoo.com'
            }

            always {
                emailext attachLog: true, body: '', subject: 'Build finished', from: 'jaziri.aziz@yahoo.com', to: 'jaziri.aziz@yahoo.com'
                cleanWs()
            }

        }


 }