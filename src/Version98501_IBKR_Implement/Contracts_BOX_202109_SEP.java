/* Copyright (C) 2019 Interactive Brokers LLC. All rights reserved. This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */
package Version98501_IBKR_Implement;


import com.ib.client.Contract;

public class Contracts_BOX_202109_SEP {


    Contract setContract(String symbol) {
        Contract contract = new Contract();
        contract.symbol(symbol);
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth("20210913");  //
        return contract;
    }

        Contract setContract(String symbol, String lastTradeOrMonth, String contract_ID) {
        Contract contract = new Contract();
        contract.symbol(symbol);
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth(lastTradeOrMonth);
        contract.conid(Integer.parseInt(contract_ID));   ///<<<--------------------------------------------
        return contract;
    }
    
    Contract setContract(String symbol, String lastTradeOrMonth, Integer contract_ID) {
        Contract contract = new Contract();
        contract.symbol(symbol);
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth(lastTradeOrMonth);
        contract.conid(contract_ID);
        return contract;
    }

        
        public static Contract FXFuture(String symbolIn, String currencyStringIn, String dateStringIn) {
        //! [futcontract]
        Contract contract = new Contract();
        contract.symbol(symbolIn);
        contract.secType("FUT");
        contract.currency(currencyStringIn);
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth(dateStringIn);
        //! [futcontract]
        return contract;
    }

    
    public static Contract AUD_FXFutureContract() {
        Contract contract = new Contract();
        contract.symbol("AUD");
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth("20210913");
        contract.conid(248025740);
        return contract;
    }

//    public static Contract CHF_FXFutureContract() {
//        Contract contract = new Contract();
//        contract.symbol("CHF");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210913");
//        contract.conid(248025757);
//        return contract;
//    }
//
//    public static Contract EUR_FXFutureContract() {
//        Contract contract = new Contract();
//        contract.symbol("EUR");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210913");
//        contract.conid(248025791);
//        return contract;
//    }
//
//    public static Contract GBP_FXFutureContract() {
//        Contract contract = new Contract();
//        contract.symbol("GBP");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210913");
//        contract.conid(248025679);
//        return contract;
//    }
//
//    public static Contract JPY_FXFutureContract() {
//        Contract contract = new Contract();
//        contract.symbol("JPY");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210913");
//        contract.conid(248025805);
//        return contract;
//    }

    
        public static Contract MXP_FXFutureContract() {
        Contract contract = new Contract();
        contract.symbol("MXP");
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth("20210913");
        contract.conid(403994843);
        return contract;
    }

        public static Contract NZD_FXFutureContract() {
        Contract contract = new Contract();
        contract.symbol("NZD");
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth("20210913");
        contract.conid(410757247);
        return contract;
    } 
        
        
        
        public static Contract CAD_FXFutureContract() {
        Contract contract = new Contract();
        contract.symbol("CAD");
        contract.secType("FUT");
        contract.currency("USD");
        contract.exchange("GLOBEX");
        contract.lastTradeDateOrContractMonth("20210914");
        contract.conid(248716017);
        return contract;
    } 
        
//        public static Contract RUR_FXFutureContract(){
//        Contract contract = new Contract();
//        contract.symbol("RUR");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210915");
//        contract.conid(247884455);
//        return contract;
//    } 


//        public static Contract ZAR_FXFutureContract() {
//        Contract contract = new Contract();
//        contract.symbol("ZAR");
//        contract.secType("FUT");
//        contract.currency("USD");
//        contract.exchange("GLOBEX");
//        contract.lastTradeDateOrContractMonth("20210913");
//        contract.conid(379444672);
//        return contract;
//    } 
//        
        
}


/*

   https://interactivebrokers.github.io/tws-api/rtd_complex_syntax.html
LastTradeDateOrContractMonth	"exp="	Format 'YYYYMMDD' is used for defining the Last Trade Date, while format 'YYYYMM' is used for defining the Contract Month. 

*/
