/**
 * @file Group.java
 * @brief This file contains the implementation of the Group feature
 * 
 * More detailed information about the file and its role in the project.
 * @author simon
 * @date December 2, 2024
 */
package gruppo22.rubrica;


public class Group extends ContactList {
    
    private String name;
    private String description;
    
    /**
     * @brief Constructor
     * @param[in] name represents the group name
     * @param[in] description represents the description of the name
     */
    public Group(String name, String description){
        super();
        this.name=name;
        this.description=description;
    }
    
    /**
      * @brief Returns the contact name
      * @return A String that represents the group name
      */
    public String getName(){
        return this.name;
    }
    
     /**
      * @brief Set the contact name
      * @param[in] name A String that represents the group name
      */
    public void setName(String name){
        this.name=name;
    }
    
    /**
      * @brief Return the description of the group
      * @return A String that represent the description of the group
      */
    public String getDescription(){
        return this.description;
    }
    
    /**
      * @brief Set the description of the group
      * @param[in] description A String that represents the description of the group
      */
    public void setDescription(String description){
        this.description=description;
    }
    
    
}
