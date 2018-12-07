public class Usage {

    public static void main(String[] args)
            throws Exception {
        // Signature class initialization with API secret key
        Signature signature = new Signature("08D1230B84123284BD24CAD64B59DF94");
        // Setting parameters
        signature.addParameter("value1");
        signature.addParameter("value2");
        // Signature generation
        String result = signature.generate();
        // Printing result
        System.out.println(result);
    }
}