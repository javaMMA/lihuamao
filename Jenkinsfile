pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ed0bc7af-a0cd-475e-afaa-bc4deed669f6', url: 'https://gitee.com/javamma/lihuamao.git']]])
            }
        }
        stage('build project') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('clean project') {
            steps {
                sh '''# #!/bin/bash表示使用系统的bash

                #!/bin/bash

                echo "Restart SpringBootApplication..."

                # 获取demo.jar的后台进程id，并赋值给变量pid

                # ps用于显示进程信息的命令，-ef参数表示显示所有进程和全部格式

                # “|”是一个管道符号，表示ps和grep命令同时执行

                # grep是linux的一个文本搜索工具

                # grep demo.jar表示查找内容包含demo.jar的进程信息

                # grep -v grep表示反向查找，查找不包含grep的内容的进程信息（也就是进行一次过滤）

                # awk是一个强大的文本分析工具，分析并生成报告。\'{print $2}\'表示打印出第二个字段

                pid=`ps -ef | grep lihuamao-0.0.1-SNAPSHOT.jar | grep -v grep | awk \'{print $2}\'`

                # 如果pid不为“”，则kill掉该进程

                if [ -n "$pid" ]
                then
                kill -9 $pid
                fi

                # Jenkins默认会在Build结束后Kill掉所有的衍生进程,

                # BUILD_ID=DONTKILLME就是防止jenkins杀掉衍生的子进程

                BUILD_ID=DONTKILLME

                # 后台启动demo.jar,2>&1表示将标准出错也输出到springboot.log文件中，最后一个&表示该命令在后台执行
                '''
            }
        }
        stage('deploy project') {
            steps {
                sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar /var/lib/jenkins/workspace/test_pipeline3/target/lihuamao-0.0.1-SNAPSHOT.jar  &'
            }
        }
    }
}
