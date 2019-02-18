package pl.piotr.skoczylas.vehiclerental.constant

import spock.lang.Specification

class ColorSpec extends Specification {
    def "classShouldKeepGivenColor"() {
        expect:
            Color.fromShortName(shortName) == constant
        where:
            shortName || constant
            "G"       || Color.GREEN
            "B"       || Color.BLUE
            "R"       || Color.RED
    }
}
