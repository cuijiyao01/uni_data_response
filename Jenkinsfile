pipeline {
    agent any

    //构建版本的名称
    def tag = "latest"
    //Harbor私服地址
    def harbor_url = "https://hub.docker.com"
    //Harbor的项目名称
    def harbor_project_name = "uni_data_response"
    //Harbor的凭证
    def harbor_auth = "ef499f29-f138-44dd-975e-ff1ca1d8c933"

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '8ef8f501-5664-43bb-bb71-fa2fe0ad2929', url: 'git@github.com:cuijiyao01/uni_data_response.git']]])
            }
        }
        stage('build project') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('build image') {
            //定义镜像名称
            // def imageName = "${project_name}:${tag}"
            //编译，构建本地镜像
            sh "mvn -f ${project_name} clean package dockerfile:build"
            //给镜像打标签
            // sh "docker tag ${imageName}
            // ${harbor_url}/${harbor_project_name}/${imageName}"
            // //登录Harbor，并上传镜像
            // withCredentials([usernamePassword(credentialsId: "${harbor_auth}",passwordVariable: 'password', usernameVariable: 'username')]) {
            //     //登录
            //     sh "docker login -u ${username} -p ${password} ${harbor_url}"
            //     //上传镜像
            //     sh "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
            // }
            // //删除本地镜像
            // sh "docker rmi -f ${imageName}"
            // sh "docker rmi -f ${harbor_url}/${harbor_project_name}/${imageName}"
        }
    }
}
