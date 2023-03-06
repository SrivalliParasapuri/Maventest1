public class PayLoad {
    public static String AddSO(){
        return("{\n" +
                "    \"service_order_type\": \"WKV\",\n" +
                "    \"service_order_category\": \"SAF\",\n" +
                "    \"so_charge_amount\": 0\n" +
                "}");


}
public static String CompleteSO(){
    return ("{\n" +
            "    \"comments\": \"Test\",\n" +
            "    \"action\": \"complete\",\n" +
            "    \"so_completed_by\": \"SRPARASAPU\",\n" +
            "    \"so_charge_amount\": 0\n" +
            "}");
    }
    public static String AddSO2(){
        return("{\n" +
                "    \"service_order_type\": \"DCP\",\n" +
                "    \"service_order_category\": \"SAF\",\n" +
                "    \"comments\": \"Test 2.\",\n" +
                "    \"so_charge_amount\": 0\n" +
                "}");
    }
    public static String ApproveSO(){
        return("{\n" +
                "    \"comments\": \"Test 2.\",\n" +
                "    \"action\": \"approve\",\n" +
                "    \"approved_by\": \"Test\"\n" +
                "}");
    }
    public static String AddSO3(){
        return("{\n" +
                "    \"service_order_type\": \"360\",\n" +
                "    \"service_order_category\": \"SAF\",\n" +
                "    \"comments\": \"Test 3\",\n" +
                "    \"so_charge_amount\": 0\n" +
                "}");
    }
    public static String RejectSO(){
        return("{\n" +
                "    \"comments\": \"Test Reject SO.\",\n" +
                "    \"action\": \"reject\"\n" +
                "}");
    }
    public static String AddSO4(){
        return("{\n" +
                "    \"service_order_type\": \"ADD\",\n" +
                "    \"service_order_category\": \"SAF\",\n" +
                "    \"comments\": \"Test 4\",\n" +
                "    \"so_charge_amount\": 1\n" +
                "}");
    }
    public static String DeleteS0(){
        return("{\n" +
                "    \"action\": \"delete\"\n" +
                "}");
    }
}