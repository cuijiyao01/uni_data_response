node {
    //构建版本的名称
    def tag = "latest"
    //docker地址
    def docker_url = "https://index.docker.io"
    //docker项目名称
    def docker_project_name = "jetanex"
    //docker的凭证
    def docker_auth = "b50aec70-d279-493e-88c1-ebc12247dc0c"
    def project_name = "uni_data_response"

    stage('pull code') {
        checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '8ef8f501-5664-43bb-bb71-fa2fe0ad2929', url: 'git@github.com:cuijiyao01/uni_data_response.git']]])
    }
    stage('build image') {
//         定义镜像名称
        def imageName = "${project_name}:${tag}"
        //编译，构建本地镜像
        sh "mvn clean package dockerfile:build"
        //给镜像打标签
        sh "docker tag ${imageName} ${docker_project_name}/${imageName}"
        //登录docker，并上传镜像
        withCredentials([usernamePassword(credentialsId: 'b50aec70-d279-493e-88c1-ebc12247dc0c', passwordVariable: 'password', usernameVariable: 'username')]) {
            //登录
            sh "docker login -u ${username} -p ${password} ${docker_url}"
            //上传镜像
            sh "docker push ${docker_project_name}/${imageName}"
            sh "echo 镜像上传成功!"
        }

        //删除本地镜像
        sh "docker rmi -f ${imageName}"
        sh "docker rmi -f ${docker_project_name}/${imageName}"
        sh "echo 删除本地镜像成功!"

        sshPublisher(publishers: [sshPublisherDesc(configName: 'aliyun_server', 
        transfers: [sshTransfer(cleanRemote: false, excludes: '', 
        execCommand: '/opt/jenkins_shell/deploy.sh $docker_url $docker_project_name $project_name $tag $port', 
        execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, 
        patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', 
        sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
    }
}
