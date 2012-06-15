//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.14 at 06:00:12 PM MESZ 
//


package de.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="player" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://www.example.org/moviequiz_player}name"/>
 *                   &lt;element ref="{http://www.example.org/moviequiz_player}wins"/>
 *                   &lt;element ref="{http://www.example.org/moviequiz_player}loss"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.example.org/moviequiz_player}id_type" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "player"
})
@XmlRootElement(name = "players")
public class Players {

    @XmlElement(required = true)
    protected List<Players.Player> player;

    /**
     * Gets the value of the player property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the player property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlayer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Players.Player }
     * 
     * 
     */
    public List<Players.Player> getPlayer() {
        if (player == null) {
            player = new ArrayList<Players.Player>();
        }
        return this.player;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://www.example.org/moviequiz_player}name"/>
     *         &lt;element ref="{http://www.example.org/moviequiz_player}wins"/>
     *         &lt;element ref="{http://www.example.org/moviequiz_player}loss"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.example.org/moviequiz_player}id_type" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "wins",
        "loss"
    })
    public static class Player {

        @XmlElement(required = true)
        protected String name;
        protected int wins;
        protected int loss;
        @XmlAttribute(required = true)
        protected int id;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the wins property.
         * 
         */
        public int getWins() {
            return wins;
        }

        /**
         * Sets the value of the wins property.
         * 
         */
        public void setWins(int value) {
            this.wins = value;
        }

        /**
         * Gets the value of the loss property.
         * 
         */
        public int getLoss() {
            return loss;
        }

        /**
         * Sets the value of the loss property.
         * 
         */
        public void setLoss(int value) {
            this.loss = value;
        }

        /**
         * Gets the value of the id property.
         * 
         */
        public int getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(int value) {
            this.id = value;
        }

    }

}