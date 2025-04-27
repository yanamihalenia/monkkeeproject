pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
    triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }

   stages {
      stage('Testing') {
         steps {
            // Get some code from a GitHub repository
            git branch: "${params.BRANCH}", url: 'https://github.com/yanamihalenia/monkkeeproject.git'

            // Run Maven on a Unix agent.
            //sh "mvn clean test"

            // To run Maven on a Windows agent, use
            script{
                try {
                     bat "mvn clean -Dusername=${user} -Dpassword=${password} test"
                } catch (Exception e) {
                     currentBuild.result = 'FAILURE'
                     // Логируем ошибку, но не останавливаем пайплайн
                     echo "Tests failed, proceeding with report generation."
                    }
                }
            }
         }
      }
   }
      stage('Reporting') {
         steps {
             script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
             }
         }
      }
   }
