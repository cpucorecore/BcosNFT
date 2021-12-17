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

    public static final String configFile = "/Users/sky/IdeaProjects/github.com/BcosNFT/src/main/resources/config.toml";
    public static final String name = "MyNFT";
    public static final String symbol = "NFT";
    public static final String addr = "0xfeed6d6161500ba975ed4893d38b7952e8c4933e";

    public static void main(String[] args) throws ContractException {
        BcosSDK sdk = BcosSDK.build(configFile);
        Client client = sdk.getClient(Integer.valueOf(1));

        BlockNumber blockNumber = client.getBlockNumber();
        logger.info("blockNumber:{}", blockNumber.getBlockNumber());

        CryptoKeyPair cryptoKeyPair = client.getCryptoSuite().getCryptoKeyPair();
        Wines wines = Wines.deploy(client, cryptoKeyPair, name, symbol);

        TransactionReceipt receipt = wines.issueWineNFT(addr, BigInteger.ONE, "https://www.tttttt.com/1");
        BigInteger totalSupply = wines.totalSupply();
        logger.info("totalSupply: {}", totalSupply);

        wines.issueWineNFT(addr, BigInteger.valueOf(100), "https://www.tttttt.com/100");
        totalSupply = wines.totalSupply();
        logger.info("totalSupply: {}", totalSupply);

        String tokenURI = wines.tokenURI(BigInteger.ONE);


        logger.info(tokenURI);

        blockNumber = client.getBlockNumber();
        logger.info("blockNumber:{}", blockNumber.getBlockNumber());

        client.stop();
        sdk.stopAll();
    }
}
