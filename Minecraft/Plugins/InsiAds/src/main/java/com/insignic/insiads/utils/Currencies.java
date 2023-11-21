package com.insignic.insiads.utils;

public enum Currencies {

    AED("United Arab Emirates Dirham", "AED", "\tد.إ"),
    AFN("Afghan Afghani", "AFN", "؋"),
    ALL("Albanian Lek", "ALL", "lek"),
    AMD("Armenian Dram", "AMD", "֏"),
    ANG("Netherlands Antillean Guilder", "ANG", "ƒ"),
    AOA("Angolan Kwanza", "AOA", "Kz"),
    ARS("Argentine Peso", "ARS", "$"),
    AUD("Australian Dollar", "AUD", "$"),
    AWG("Aruban Florin", "AWG", "Afl."),
    AZN("Azerbaijani Manat", "AZN", "\t₼"),
    BAM("Bosnia-Herzegovina Convertible Mark", "BAM", "KM"),

    private String currencyName;
    private String currency;
    private String symbols;

    Currencies(String currencyName, String currency, String symbols){

        this.currencyName = currencyName;
        this.currency = currency;
        this.symbols = symbols;

    }

}
