package test

class SaleAd {

    String descShort
    String descLong
    String title
    Float price
    Date dateCreated
    Date lastUpdated

    // Illustrations

    static hasMany = [illustrations:Illustration]



    static constraints = {
        title nullable:false, blank : false,size:5..200
        descShort nullable:false, blank:false
        descLong nullable:false, blank:false
        price nullable:false
        illustrations nullable:false

    }

    static mapping = {
        descLong type:'text'
    }
}