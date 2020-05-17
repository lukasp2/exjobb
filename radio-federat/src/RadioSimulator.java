public class RadioSimulator {

    private final HlaWorld _hlaWorld;

    public RadioSimulator() {
        _hlaWorld = HlaWorld.Factory.create(new HlaSettings() {
        });
    }

    public void simulate() throws HlaBaseException {
        _hlaWorld.connect();

        Hla
            
        try {    
            File myObj = new File("DATAFILE.txt");
            Scanner scanner = new Scanner(myObj);
            scanner.useLocale(Locale.US);
    
            while (scanner.hasNext()) {
                int comType = scanner.nextInt();
                int fromNode = scanner.nextInt();
                int toNode = scanner.nextInt();
                int transactionID = scanner.nextInt();
                
                
            }
            scanner.close();
        }
            catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        _hlaWorld.disconnect();
    }
    
    public static void main(String[] args) throws HlaBaseException {
        new RadioSimulator().simulate();
    }
}