class week4qs2{
    public static void main(String args[]){
        int[] p1= {7,1,5,3,6,4};
        System.out.println(Profit(p1));
        int[] p2= {7,6,4,3,1};
        System.out.println(Profit(p2));
    }


    public static int Profit(int[] prices){
        int min=prices[0];
        int maxprofit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            else if(prices[i]-min>maxprofit){
                maxprofit=prices[i]-min;
            }
        }
        return maxprofit;
    }
}

