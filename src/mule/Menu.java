/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mule;

/**
 *
 * @author dengel6
 */
public class Menu implements View {

    private ViewHandler handler;
    
    @Override
    public void setParentScreen(ViewHandler handler) {
       this.handler=handler;
    }
    
    
    
}
