```java
public class Wines {
    /**
     * 查询nft的数量
     * @param   owner   链上地址，例如："0xfeed6d6161500ba975ed4893d38b7952e8c4933e"
     * @return  nft的数量
     */
    BigInteger balanceOf(String owner) throws ContractException;

    /**
     * 查询nft的所有者
     * @param   tokenId   nft的tokenId，最大为256bit的数字
     * @return  链上地址，例如："0xfeed6d6161500ba975ed4893d38b7952e8c4933e"
     */
    public String ownerOf(BigInteger tokenId) throws ContractException;

    /**
     * 查询nft合约的名字，在创建合约的时候指定
     * @return  nft名字
     */
    public String name() throws ContractException;

    /**
     * 查询nft合约的符号，在创建合约的时候指定
     * @return  nft符号
     */
    public String symbol() throws ContractException;

    /**
     * 查询nft URI
     * @param   tokenId   nft的tokenId，最大为256bit的数字
     * @return  链上地址，例如："ipfs:cid/filename"
     */
    public String tokenURI(BigInteger tokenId) throws ContractException;

    /**
     * 查询 baseURI
     * @return  例如："ipfs:cid/"
     */
    public String baseURI() throws ContractException;

    /**
     * 根据链上地址和该地址拥有的nft下标查抄tokenId
     * @param   owner   链上地址，例如："0xfeed6d6161500ba975ed4893d38b7952e8c4933e"
     * @param   index   0 <= index < balanceOf(owner)
     * @return  tokenId
     */
    public BigInteger tokenOfOwnerByIndex(String owner, BigInteger index) throws ContractException;

    /**
     * 查询合约发行的总nft数量
     * @return  nft数量
     */
    public BigInteger totalSupply() throws ContractException;

    /**
     * 根据合约中nft下标查询tokenId
     * @param   index   0 <= index < totalSupply()
     * @return  tokenId
     */
    public BigInteger tokenByIndex(BigInteger index) throws ContractException;

    /**
     * 将tokenId授权给to地址，有对应异步接口
     * @param   to   链上地址，例如："0xfeed6d6161500ba975ed4893d38b7952e8c4933e"
     * @param   tokenId   nft对应的tokenId
     * @return  交易回执
     */
    public TransactionReceipt approve(String to, BigInteger tokenId);

    /**
     * 查询tokenId授权给的地址
     * @param   tokenId   nft对应的tokenId
     * @return  链上地址
     */
    public String getApproved(BigInteger tokenId) throws ContractException;

    /**
     * 将所有nft授权/撤销授权给某个地址，有对应异步接口
     * @param   operator   被授权/撤销授权的地址
     * @param   approved   true/false
     * @return  交易回执
     */
    public TransactionReceipt setApprovalForAll(String operator, Boolean approved);

    /**
     * 查询授权
     * @param   owner   nft所有者
     * @param   operator   nft被授权者
     * @return  是否授权
     */
    public Boolean isApprovedForAll(String owner, String operator) throws ContractException;

    /**
     * nft转账，有异步版本接口
     * @param   from   原地址
     * @param   to   目标地址
     * @param   tokenId   转移的nft tokenId
     * @return  交易回执
     */
    public TransactionReceipt transferFrom(String from, String to, BigInteger tokenId);

    /**
     * nft转账，有异步版本接口，如果to地址是合约地址，会检查合约是否实现了onERC721Received，如果没有实现转账会失败
     * @param   from   原地址
     * @param   to   目标地址
     * @param   tokenId   转移的nft tokenId
     * @return  交易回执
     */
    public TransactionReceipt safeTransferFrom(String from, String to, BigInteger tokenId);

    /**
     * nft转账，有异步版本接口，如果to地址是合约地址，会检查合约是否实现了onERC721Received，如果没有实现转账会失败
     * @param   from   原地址
     * @param   to   目标地址
     * @param   tokenId   转移的nft tokenId
     * @param   _data   转账时候附带数据，最终会在调用onERC721Received函数的时候传入
     * @return  交易回执
     */
    public TransactionReceipt safeTransferFrom(String from, String to, BigInteger tokenId, byte[] _data);

    /**
     * 发行nft
     * @param   to   目标地址
     * @param   tokenId   tokenId
     * @param   tokenURI    nft对应的metadata URI
     * @return  交易回执
     */
    public TransactionReceipt issueWineNFT(String to, BigInteger tokenId, String tokenURI);

    /**
     * 销毁nft
     * @param   tokenId   要销毁的nft
     * @return  交易回执
     */
    public TransactionReceipt burnWineNFT(BigInteger tokenId);
}

```
