interface Printer {
    void printDocument();
}

interface Scanner {
    void scanDocument();
}

interface FaxMachine {
    void faxDocument();
}

class MultifunctionCopier implements Printer, Scanner, FaxMachine {
    @Override
    public void printDocument() {
        System.out.println("MultiFunctionCopier: Printing document...");
    }

    @Override
    public void scanDocument() {
        System.out.println("MultiFunctionCopier: Scanning document...");
    
    }

    @Override
    public void faxDocument() {
        System.out.println("MultiFunctionCopier: faxing document...");
    }
}

class BasicPrinter implements Printer {
    @Override
    public void printDocument() {
        System.out.println("BasicPrinter: Printing document...");
    }
}

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Testing Basic Printer");
        Printer basicPrinter = new BasicPrinter();
        basicPrinter.printDocument();

        System.out.println("\nTesting Multi-Function Copier");
        MultifunctionCopier mfc = new MultifunctionCopier();
        mfc.printDocument();
        mfc.scanDocument();
        mfc.faxDocument();
    }
}
