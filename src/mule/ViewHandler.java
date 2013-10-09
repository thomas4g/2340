/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
/**
 *
 * @author dengel6
 */
class ViewHandler extends StackPane {
    
    private HashMap<String, Node> screens = new HashMap<>();
    
    public void addScreen(String name, Node screen){
        System.out.println("Adding " + name);
        System.out.println(screen);
        screens.put(name, screen);
    }
    
    public boolean loadScreen(String name,String resource) throws IOException{
        try{
     
            Parent loadScreen = FXMLLoader.load(getClass().getResource(resource));
            
            //View view = myLoader.getController();
            //view.setParentScreen(this);
            addScreen(name, loadScreen);
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean setScreen(String name){
       if(screens.get(name)!=null){
            
           

       //Is there is more than one screen
            if(!getChildren().isEmpty()){

               getChildren().remove(0);    
               getChildren().add(0, screens.get(name));
            }
            else{
           	//no one else been displayed, then just show
                getChildren().add(screens.get(name));
             }
       return true;
       } 
       else {
         System.out.println("screen hasn't been loaded!\n");
         return false;
       } 
            
    }
        
     public boolean unloadScreen(String name) {
        if(screens.remove(name) == null) {
          System.out.println("Screen didn't exist");
          return false;
        } 
        else {
          return true;
        }
     }
     
   }
    
