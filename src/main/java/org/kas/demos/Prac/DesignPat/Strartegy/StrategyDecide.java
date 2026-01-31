package org.kas.demos.Prac.DesignPat.Strartegy;

class StrategyDecide{
    int amount;

    PaymentStrategy ps;
    public StrategyDecide(PaymentStrategy ps,int amount) {
        this.ps = ps;
        this.amount =amount;
    }
    void checkout(int amount){
        ps.pay(amount);
    }


}
