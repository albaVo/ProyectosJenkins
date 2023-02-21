// import jenkins-auto-approve-script.groovy

job('Job-pTienda') {
    description('Job Padre para crear una tarea Hija que despliegue la App Tienda del Corte Ingles')
    scm {
        git('https://github.com/albaVo/PTienda.git', 'master'){ 
            node -> 
                node / gitConfigName('albaVo')
                node / gitConfigEmail('alba12vo@gmail.com')
        }
    }
    triggers {
     //   scm('H/5 * * * *')
        githubPush()
    }
    
    steps {
        shell("bash ./build/install.sh")
    }
}