job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/macloujulian/nodejsapp.git', 'master') { node ->
            node / gitConfigName('cc')
            node / gitConfigEmail('cc@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs_26')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('ccruzax97/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('5f03ffb6-fecb-4d8e-a341-98ddde2b076d')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
