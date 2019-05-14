/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Gaya 3
 */
public abstract class Role {
    
    public enum RoleType{
        THCSAdmin("THCS Admin"),
        THCSDataAnalyser("THCS Data Analyser"),
        THCSDataCollector("THCS Data Collector"),
        THCSManager("THCS Manager"),
        GovtAdmin("Government Admin"),
        GovtEmployee("Government Employee"),
        Customer("Customer"),
        HospitalAdmin("Hospital Admin"),
        HospitalEmployee("Hospital Employee");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business, Network network);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}