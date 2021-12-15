package org.com.ac;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.client.protocol.response.BlockNumber;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static final String configFile = "/Users/sky/IdeaProjects/github.com/bcosNFT/src/main/resources/config.toml";
    public static final String name = "MyNFT";
    public static final String symbol = "NFT";
    public static final String addr = "0xfeed6d6161500ba975ed4893d38b7952e8c4933e";

    public static void main(String[] args) throws ContractException {
        logger.info("hello");

        // 初始化BcosSDK
        BcosSDK sdk =  BcosSDK.build(configFile);
        // 为群组1初始化client
        Client client = sdk.getClient(Integer.valueOf(1));

        // 获取群组1的块高
        BlockNumber blockNumber = client.getBlockNumber();

        // 向群组1部署合约
        CryptoKeyPair cryptoKeyPair = client.getCryptoSuite().getCryptoKeyPair();
        Wines wines = Wines.deploy(client, cryptoKeyPair, name, symbol);

        // 调用合约
        TransactionReceipt receipt = wines.issueWineNFT(addr, BigInteger.ONE, "https://www.tttttt.com/1");

        String tokenURI = wines.tokenURI(BigInteger.ONE);

        logger.info(tokenURI);
    }
}
