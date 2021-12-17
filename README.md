- 合约结构：https://app.yinxiang.com/fx/4fb45c35-7e46-4517-b790-986c80573a84

- 配置节点证书
```shell
# 假设SDK证书位于~/fisco/nodes/127.0.0.1/sdk/目录
mkdir -p conf && cp -r ~/fisco/nodes/127.0.0.1/sdk/* conf
```

- 安装fisco bcos console
必须安装jdk14，高于jdk14会导致连不上区块链，报不支持曲线secp256k1曲线
```shell
$ mkdir -p ~/fisco && cd ~/fisco
# 获取控制台
$ curl -#LO https://github.com/FISCO-BCOS/console/releases/download/v2.8.0/download_console.sh

# 若因为网络问题导致长时间无法执行以上命令，请尝试以下命令：
$ https://osp-1257653870.cos.ap-guangzhou.myqcloud.com/FISCO-BCOS/console/releases/v2.8.0/download_console.sh

# -v 0.6指定solidity版本号 0.6.x，否则会导致合约编译报错
$ bash download_console.sh -v 0.6
$ cd ~/fisco/console
```

- 准备合约
```shell
cp ./contracts/* ~/fisco/console/contracts/solidity/
```

- 生成合约的java接口
```shell
# -p 指定生成java文件所在的包名
cd ~/fisco/console && bash sol2java.sh -p org.com.ac

# 将编译出的java文件拷贝到项目中
cp -r ~/fisco/console/contracts/sdk/java/org ./src/main/java/
```

- NFT相关api见api.md