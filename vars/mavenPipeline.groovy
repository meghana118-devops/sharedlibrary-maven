import com.mylearning.builds.Mvn

def call(Map pipelineParams) {
    // an instance of the Calculator class 
    Mvn mvn_new = new Mvn(this)
    pipeline {
        agent {
            label 'java-slave'
        }
        environment {
            APPLICATION_NAME = "${pipelineParams.appName}"
        }
        tools {
            maven 'Maven_3.9.0'
        }
        stages {
            stage ('Build') {
                steps {
                    echo "Building the project"
                    echo "************ In Build Stage for ${env.APPLICATION_NAME}  ************"
                    script {
                        mvn_new.run('mvn clean install')

                    }
                }
            }
            stage ('Test') {
                steps {
                    echo "Testing the project"
                }
            }
            stage ('DevDeploy') {
                steps {
                    echo "Deploying the project to Dev environment"
                }
            }
            stage ('TestDeploy') {
                steps {
                    echo "Deploying the project to Test environment"
                }
            }
            stage ('ProdDeploy') {
                steps {
                    echo "Deploying the project to Prod environment"
                }
            }
        }
    }
}
