/* Copyright (C) 2019 Interactive Brokers LLC. All rights reserved. This code is subject to the terms
 * and conditions of the IB API Non-Commercial License or the IB API Commercial License, as applicable. */
package Version98501_IBKR_Implement;

import java.util.*;
import com.ib.client.*;
import java.util.concurrent.TimeUnit;

public class Main {

    int intValidId;

    public static void main(String[] args) throws InterruptedException {

        EWrapper_Implementation wrapper = new EWrapper_Implementation();
        Processor_HashMap_Synchronizer HMS = new Processor_HashMap_Synchronizer();
        Processor_HistoricalData P_HD = new Processor_HistoricalData();
        Processor_HashMap_Position_Discloser HPPD = new Processor_HashMap_Position_Discloser();
        Processor_DesiredReturn PDR = new Processor_DesiredReturn();

        final EClientSocket m_client = wrapper.getClient();
        final EReaderSignal m_signal = wrapper.getSignal();
        //! [connect]
        m_client.eConnect("127.0.0.1", 7497, 0);
        //! [connect]
        //! [ereader]
        final EReader reader = new EReader(m_client, m_signal);

        reader.start();
        //An additional thread is created in this program design to empty the messaging queue
        new Thread(() -> {
            while (m_client.isConnected()) {
                m_signal.waitForSignal();
                try {
                    reader.processMsgs();
                } catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        }).start();
        //! [ereader]
        // A pause to give the application time to establish the connection
        // In a production application, it would be best to wait for callbacks to confirm the connection is complete
        Thread.sleep(1000);

        LiveContract liveContract_00 = new LiveContract(Contracts_BOX_202109_SEP.MXP_FXFutureContract(), "MXP", 1876.0, 1501.0, 403994843, 14.0, 3000, 19000);
        LiveContract liveContract_01 = new LiveContract(Contracts_BOX_202109_SEP.NZD_FXFutureContract(), "NZD", 2746.0, 2197.0, 410757247, 19.0, 3001, 19001);
        LiveContract liveContract_02 = new LiveContract(Contracts_BOX_202109_SEP.AUD_FXFutureContract(), "AUD", 2891.0, 2313.0, 248025740, 19.0, 3002, 19002);
        LiveContract liveContract_03 = new LiveContract(Contracts_BOX_202109_SEP.CAD_FXFutureContract(), "CAD", 3026.0, 2421.0, 248716017, 20.0, 3003, 19003);
//LiveContract liveContract_04 = new LiveContract(Contracts_BOX_202109_SEP.ZAR_FXFutureContract(), "ZAR", 3618.0, 2895.0, 379444672, 23.0, 3004, 19004);
//LiveContract liveContract_05 = new LiveContract(Contracts_BOX_202109_SEP.JPY_FXFutureContract(), "JPY", 4266.0, 3413.0, 248025805, 26.0, 3005, 19005);
//LiveContract liveContract_06 = new LiveContract(Contracts_BOX_202109_SEP.CHF_FXFutureContract(), "CHF", 5220.0, 4176.0, 248025757, 30.0, 3006, 19006);
//LiveContract liveContract_07 = new LiveContract(Contracts_BOX_202109_SEP.GBP_FXFutureContract(), "GBP", 5513.0, 4410.0, 248025679, 32.0, 3007, 19007);
//LiveContract liveContract_08 = new LiveContract(Contracts_BOX_202109_SEP.EUR_FXFutureContract(), "EUR", 5690.0, 4552.0, 248025791, 33.0, 3008, 19008);
//LiveContract liveContract_09 = new LiveContract(Contracts_BOX_202109_SEP.RUR_FXFutureContract(), "RUR", 6216.0, 4973.0, 247884455, 35.0, 3009, 19009);

        ArrayList<LiveContract> activeContracts = new ArrayList<>();
        activeContracts.add(liveContract_00);
        activeContracts.add(liveContract_01);
        activeContracts.add(liveContract_02);
        activeContracts.add(liveContract_03);
//        activeContracts.add(liveContract_04);
//        activeContracts.add(liveContract_05);
//        activeContracts.add(liveContract_06);
//        activeContracts.add(liveContract_07);
//        activeContracts.add(liveContract_08);
//        activeContracts.add(liveContract_09);

        //tickByTickOperations(wrapper.getClient());
        //tickDataOperations(wrapper.getClient());
        //tickOptionComputations(wrapper.getClient());
        //optionsOperations(wrapper.getClient());
        //orderOperations(wrapper.getClient(), wrapper.getCurrentOrderId());
        //contractOperations(wrapper.getClient());
        //hedgeSample(wrapper.getClient(), wrapper.getCurrentOrderId());
        //testAlgoSamples(wrapper.getClient(), wrapper.getCurrentOrderId());
        //bracketSample(wrapper.getClient(), wrapper.getCurrentOrderId());
        //bulletins(wrapper.getClient());
        //fundamentals(wrapper.getClient());
        //marketScanners(wrapper.getClient());
//        marketDataType(wrapper.getClient());
//        historicalDataRequests(wrapper.getClient());
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("  ");

        Map<String, Double> outgoingPositions = new HashMap<>();

        outgoingPositions = wrapper.getPositions();

        TreeMap<String, Double> doneTreeMap = HMS.synchMethod(outgoingPositions);

        System.out.println("|------- DONE ----  " + doneTreeMap);

        pnl(wrapper.getClient());
        TimeUnit.SECONDS.sleep(4);

        TimeUnit.SECONDS.sleep(4);
        Map<String, Double> returnedPositions = wrapper.getPositions();
        PDR.return_PerTradeMethod(returnedPositions);

        TimeUnit.SECONDS.sleep(4);
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("Current Unrealized PNL versus Desired 10% per Open Trades totaling # of Contracts");
        System.out.println();
        System.out.println("Unrealized PNL            :  " + wrapper.getoverallUnrealizedPNL());
        System.out.println("Desired 10% per Open Trade:  " + PDR.return_PerTradeMethod(returnedPositions));
        System.out.println("# of contracts [/open/]-  :  " + HPPD.AbsolutePosition_Discloser(doneTreeMap));
        System.out.println();
        System.out.println("==============================================================");
        System.out.println();

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println();

        OrderPlacer OOP = new OrderPlacer(wrapper.getClient(), wrapper.getCurrentOrderId());
        marketDataType(wrapper.getClient());

        for (int cr = 0; cr < activeContracts.size(); cr++) {
            Contract currentContract = activeContracts.get(cr).getContract();
            String currentSymbolFUT = activeContracts.get(cr).getSymbol();
            int reqID_HistoricalData = activeContracts.get(cr).getHistData_ReqID();


            System.out.println("          ");
            System.out.println("          ");
            Thread.sleep(10000);

            if (HPPD.Position_Discloser(doneTreeMap, currentSymbolFUT) == 0.00) {

                HistoricalData_MainOPERATIONS(reqID_HistoricalData, wrapper.getClient(), currentContract);
                TimeUnit.SECONDS.sleep(10);

                if (wrapper.getBarsHistDataArrayList().size() != 0) {
                    wrapper.getBarsHistDataArrayList();
                    ArrayList<Bar> incomingBarInput = wrapper.getBarsHistDataArrayList();
                    TimeUnit.SECONDS.sleep(8);

                    double Tick = wrapper.getLastTick();

                    String determinedDecision = P_HD.simpleDecisionDeterminer_UsingTick(incomingBarInput, Tick);

                    TimeUnit.SECONDS.sleep(6);
                    incomingBarInput.clear();

                    System.out.println(" ");

                    TimeUnit.SECONDS.sleep(5);

                    System.out.println(" ");
                    System.out.println(" ");

                    if ("BUY".equals(determinedDecision) || "SELL".equals(determinedDecision)) {
                        OOP.placeOrder(currentContract, OrderTypes.MarketOrder(determinedDecision, 1));
                    }
                }

            }
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println();
        }

        TimeUnit.SECONDS.sleep(10);


        //accountOperations(wrapper.getClient());
        //newsOperations(wrapper.getClient());
        //marketDepthOperations(wrapper.getClient());
        //rerouteCFDOperations(wrapper.getClient());
        //marketRuleOperations(wrapper.getClient());
        //tickDataOperations(wrapper.getClient());
        //pnlSingle(wrapper.getClient());
        //continuousFuturesOperations(wrapper.getClient());
        //pnlSingle(wrapper.getClient());
        //histogram(wrapper.getClient());
        //whatIfSamples(wrapper.getClient(), wrapper.getCurrentOrderId());
        //historicalTicks(wrapper.getClient());
        //financialAdvisorOperations(wrapper.getClient());
        System.out.println();
        System.out.println("&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&==&&&");
        System.out.println();

        TimeUnit.SECONDS.sleep(5);
        //Thread.sleep(100000);  //55 minutes
        m_client.eDisconnect();
    }

    public static void HistoricalData_MainOPERATIONS(int reqID_HistData, EClientSocket client, Contract FXFuture00000) throws InterruptedException {
        System.out.println();
        
        
        
        List<TagValue> chartOptions = new ArrayList<TagValue>();

        for (TagValue chartOption : chartOptions) {
            System.out.println("Car name is: " + chartOption.m_tag);
        }
    

        client.reqHistoricalData(reqID_HistData, FXFuture00000, "", "2400 s", "30 mins", "TRADES", 0, 1, false, chartOptions);
        
                Thread.sleep(4000);
        client.cancelHistoricalData(reqID_HistData);

        System.out.println("");
        System.out.println("");
    }
    


    private static void marketDataType(EClientSocket client) {

        //! [reqmarketdatatype]
        /**
         * * Switch to live (1) frozen (2) delayed (3) or delayed frozen (4)**
         */
        client.reqMarketDataType(1);
        //! [reqmarketdatatype]

    }


 
    private static void pnl(EClientSocket client) throws InterruptedException {
        //! [reqpnl]
        client.reqPnL(17001, "DU999999", "");
        //! [reqpnl]
        Thread.sleep(1000);
        //! [cancelpnl]
        client.cancelPnL(17001);
        //! [cancelpnl]
    }

}







    //   NOTES

//      client.reqHistoricalData(reqID_HistData, FXFuture00000, formatted, "3600 S", "15 mins", "TRADES", 0, 1, false, chartOptions);
//1.5hrs=90min =5400seconds
//2hrs=120min =7200seconds
//void reqHistoricalData(int tickerId, Contract contract, string endDateTime, string durationStr, string barSizeSetting, string whatToShow,
//		int useRTH, int formatDate, bool keepUpToDate, List< TagValue > chartOptions )
        /*

15 minutes = 900 seconds
30 minutes = 1800 seconds
40 minutes = 2400 seconds
45 minutes = 2700 seconds
60 minutes = 3600 seconds

TRADES
MIDPOINT
BID
ASK
BID_ASK
        
void reqHistoricalData(int tickerId,
		Contract contract,
		string endDateTime,
		string durationStr,
		string barSizeSetting,
		string whatToShow,
		int useRTH,
		int formatDate,
		bool keepUpToDate,
		List< TagValue > chartOptions 
	)

client.reqHistoricalData(4001, ContractSamples, formatted, "1 M", "1 day", "MIDPOINT", 1, 1, false, null);
client.reqHistoricalData(tickerId, contract, endDateTime, durationStr, barSizeSetting, whatToShow, useRTH, formatDate,keepUpToDate, List<TagValue>chartOptions); 

         */
 /* Error. Id: 4001, Code: 321, Msg: Error validating request:-'bI' : cause - Historical data bar size setting is invalid. 
        Legal ones are: 1 secs, 5 secs, 10 secs, 15 secs, 30 secs, 1 min, 2 mins, 3 mins, 5 mins, 10 mins, 15 mins, 20 mins, 30 mins, 1 hour, 2 hours, 3 hours, 4 hours, 8 hours, 1 day, 1W, 1M
         */

    