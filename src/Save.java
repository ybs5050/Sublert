/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youngmin
 */
public class Save implements Display{
    
    private String saveFileDirectory = "";
    private String saveFileName = "";
    
    public Save(String saveFileDirectory, String saveFileName) {
        this.saveFileDirectory = saveFileDirectory;
        this.saveFileName = saveFileName;
    }
    
    public String getSaveFileDirectory() {
        return saveFileDirectory;
    }
    
    public String getSaveFileName() {
        return saveFileName;
    }
    
    public void setSaveFileDirectory(String saveFileDirectory) {
        this.saveFileDirectory = saveFileDirectory;
    }
    
    public void setSaveFileName(String saveFileName) {
        this.saveFileName = saveFileName;
    }

    @Override
    public void showInformation() {
        System.out.println("Current Save Data Directory: "+saveFileDirectory);
        System.out.println("Current Save Data Name: "+saveFileName);
    }

    @Override
    public void checkNull() {
        String result = (saveFileDirectory.length() == 0 || saveFileName.length() == 0) ? "Empty" : "Not Empty";
        System.out.println("Save class is "+result);
    }
    
}
