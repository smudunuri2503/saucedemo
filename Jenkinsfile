pipeline 
{
    agent any

    triggers 
    {
        cron('H 7 * * *')  // Run daily at 7 AM
    }

    tools 
    {
        maven 'Maven 3.9'    // Use the Maven installation name configured in Jenkins
        jdk 'JDK 17'         // Use the JDK installation name configured in Jenkins
    }

    


    stages 
    {
        stage('Checkout Code')
        {
            steps 
            {
                git 'git@github.com:smudunuri2503/saucedemo.git'  // Replace with your repo SSH URL
            }
        }

        stage('Build & Test') 
        {
            steps 
            {
                sh 'mvn clean test'
            }
        }

        stage('Publish Reports') 
        {
            steps 
            {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Publish Extent Report') {
        steps {
        publishHTML(target: [
            reportDir: 'test-output/ExtentReports', // Update this path
            reportFiles: 'ExtentReport.html',       // Main report file
            reportName: 'Extent Report',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: true ])
            }
    }
    }

post {
        always 
        {
            echo 'Finished running tests'
            archiveArtifacts artifacts: '**/test-output/**/*.*', allowEmptyArchive: true

        }
    }

}
