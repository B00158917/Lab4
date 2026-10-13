public class PrintJob {
    private String id;
    private String doc_name;
    private String pages;
    
    public PrintJob(String id, String doc_name, String pages) {
        this.id = id;
        this.doc_name = doc_name;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public String getPages() {
        return pages;
    }
    
    public String toString(){
        return getDoc_name();
    }
    
}
