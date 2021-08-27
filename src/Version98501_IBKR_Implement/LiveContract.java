package Version98501_IBKR_Implement;

import com.ib.client.Contract;

public class LiveContract {

    Contract contract;
    String symbol;
    double initialMargin;
    double maintMargin;
    int contract_ID;
    double perTrade_10forGod;
    int HistData_ReqID;
    int TickByTick_ReqID;
    
       public LiveContract(Contract contract, String symbol, double initialMargin, double maintMargin, int contract_ID, double perTrade_10forGod, int HistData_ReqID, int TickByTick_ReqID) {
        this.contract = contract;
        this.symbol = symbol;
        this.initialMargin = initialMargin;
        this.maintMargin=maintMargin;
        this.contract_ID = contract_ID;
        this.perTrade_10forGod=perTrade_10forGod;
        this.HistData_ReqID = HistData_ReqID;
        this.TickByTick_ReqID = TickByTick_ReqID;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(double initialMargin) {
        this.initialMargin = initialMargin;
    }

    public double getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(double maintMargin) {
        this.maintMargin = maintMargin;
    }

    public int getContract_ID() {
        return contract_ID;
    }

    public void setContract_ID(int contract_ID) {
        this.contract_ID = contract_ID;
    }

    public double getperTrade_10forGod() {
        return perTrade_10forGod;
    }

    public void setperTrade_10forGod(double perTrade_10forGod) {
        this.perTrade_10forGod = perTrade_10forGod;
    }

    public int getHistData_ReqID() {
        return HistData_ReqID;
    }

    public void setHistData_ReqID(int HistData_ReqID) {
        this.HistData_ReqID = HistData_ReqID;
    }

    public int getTickByTick_ReqID() {
        return TickByTick_ReqID;
    }

    public void setTickByTick_ReqID(int TickByTick_ReqID) {
        this.TickByTick_ReqID = TickByTick_ReqID;
    }
       
    
    
}




