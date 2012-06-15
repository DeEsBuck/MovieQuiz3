//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.06.14 at 06:00:21 PM MESZ 
//


package de.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="quizfrage" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="bild">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="antwort" maxOccurs="4">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}time" />
 *                 &lt;attribute name="nr" type="{http://www.example.org/moviequiz}question_nr" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="highscore">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="score" type="{http://www.example.org/moviequiz}score_typ"/>
 *                   &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
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
    "quizfrage",
    "highscore"
})
@XmlRootElement(name = "quizgame")
public class Quizgame {

    @XmlElement(required = true)
    protected List<Quizgame.Quizfrage> quizfrage;
    @XmlElement(required = true)
    protected Quizgame.Highscore highscore;

    /**
     * Gets the value of the quizfrage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the quizfrage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuizfrage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Quizgame.Quizfrage }
     * 
     * 
     */
    public List<Quizgame.Quizfrage> getQuizfrage() {
        if (quizfrage == null) {
            quizfrage = new ArrayList<Quizgame.Quizfrage>();
        }
        return this.quizfrage;
    }

    /**
     * Gets the value of the highscore property.
     * 
     * @return
     *     possible object is
     *     {@link Quizgame.Highscore }
     *     
     */
    public Quizgame.Highscore getHighscore() {
        return highscore;
    }

    /**
     * Sets the value of the highscore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Quizgame.Highscore }
     *     
     */
    public void setHighscore(Quizgame.Highscore value) {
        this.highscore = value;
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
     *         &lt;element name="score" type="{http://www.example.org/moviequiz}score_typ"/>
     *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "score",
        "from"
    })
    public static class Highscore {

        @XmlElement(required = true)
        protected BigInteger score;
        @XmlElement(required = true)
        protected String from;

        /**
         * Gets the value of the score property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getScore() {
            return score;
        }

        /**
         * Sets the value of the score property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setScore(BigInteger value) {
            this.score = value;
        }

        /**
         * Gets the value of the from property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFrom() {
            return from;
        }

        /**
         * Sets the value of the from property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFrom(String value) {
            this.from = value;
        }

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
     *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="bild">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="antwort" maxOccurs="4">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}time" />
     *       &lt;attribute name="nr" type="{http://www.example.org/moviequiz}question_nr" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "genre",
        "bild",
        "antwort"
    })
    public static class Quizfrage {

        @XmlElement(required = true)
        protected String genre;
        @XmlElement(required = true)
        protected Quizgame.Quizfrage.Bild bild;
        @XmlElement(required = true)
        protected List<Quizgame.Quizfrage.Antwort> antwort;
        @XmlAttribute
        @XmlSchemaType(name = "time")
        protected XMLGregorianCalendar time;
        @XmlAttribute
        protected Integer nr;

        /**
         * Gets the value of the genre property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGenre() {
            return genre;
        }

        /**
         * Sets the value of the genre property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGenre(String value) {
            this.genre = value;
        }

        /**
         * Gets the value of the bild property.
         * 
         * @return
         *     possible object is
         *     {@link Quizgame.Quizfrage.Bild }
         *     
         */
        public Quizgame.Quizfrage.Bild getBild() {
            return bild;
        }

        /**
         * Sets the value of the bild property.
         * 
         * @param value
         *     allowed object is
         *     {@link Quizgame.Quizfrage.Bild }
         *     
         */
        public void setBild(Quizgame.Quizfrage.Bild value) {
            this.bild = value;
        }

        /**
         * Gets the value of the antwort property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the antwort property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAntwort().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Quizgame.Quizfrage.Antwort }
         * 
         * 
         */
        public List<Quizgame.Quizfrage.Antwort> getAntwort() {
            if (antwort == null) {
                antwort = new ArrayList<Quizgame.Quizfrage.Antwort>();
            }
            return this.antwort;
        }

        /**
         * Gets the value of the time property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTime() {
            return time;
        }

        /**
         * Sets the value of the time property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTime(XMLGregorianCalendar value) {
            this.time = value;
        }

        /**
         * Gets the value of the nr property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getNr() {
            return nr;
        }

        /**
         * Sets the value of the nr property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setNr(Integer value) {
            this.nr = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="result" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Antwort {

            @XmlValue
            protected String value;
            @XmlAttribute
            protected Boolean result;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the result property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isResult() {
                return result;
            }

            /**
             * Sets the value of the result property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setResult(Boolean value) {
                this.result = value;
            }

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
         *       &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Bild {

            @XmlAttribute
            @XmlSchemaType(name = "anyURI")
            protected String link;

            /**
             * Gets the value of the link property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLink() {
                return link;
            }

            /**
             * Sets the value of the link property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLink(String value) {
                this.link = value;
            }

        }

    }

}
