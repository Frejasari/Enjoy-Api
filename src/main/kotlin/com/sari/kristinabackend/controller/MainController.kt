package com.sari.kristinabackend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/content")
    fun content(@RequestParam(value = "page", defaultValue = "home", required = false) name: String) = contentMap[name]

    @GetMapping("/header")
    fun header() = contentMap.map { (url, content) -> UrlMapping(url, content.header)}

    @GetMapping("data")
    fun data()= contentMap

}

data class Content(val header: String, val title: String, val text: String, val imageUrl: String)

data class UrlMapping(val url: String, val header: String)

val contentMap = mapOf(
        "/home" to Content("Startseite", "Willkommen auf meiner Pilates - Webseite.",
                """Pilates ist ein ganzheitliches, effektives Übungsprogramm zur Kräftigung der Tiefenmuskulatur. Durch
            Training wird der Körper stark und geschmeidig, ohne große Muskelmasse aufzubauen. Das Pilates
            Trainingskonzept basiert auf philosophischen Grundüberlegungen der Vision von Gesundheit und Wohlbefinden.
            Drei grundlegende Prinzipien der Philosophie Pilates´sind:
            <ul>
              <li>Whole Body Health: Ganzkörpergesundheit - Whole</li>
              <li>Body Commitment: Verpflichtung für den ganzen Körper</li>
              <li>Breath: Atmung (nach Pilates eine "innere Dusche")</li>
            </ul>""", "https://res.cloudinary.com/dqpamj6hy/image/upload/v1543351725/kristina/rollup_300x900.jpg" ),
        "/infos-zu-pilates" to Content("Infos zu Pilates","Infos zu Pilates", """Contrology (Pilates) ist die komplette Koordination von Körper, Verstand und Geist. Pilates ist eine sanftes,
    dennoch besonders effektives ganzheitliches Körpertraining für mehr Kraft, Beweglichkeit und Balance für Menschen
    jeden Alters und jeder Fitnessstufe. Jeder Pilatesstunde liegen die sechs Pilates Prinzipien zu Grunde: Atmung,
    Zentrierung, Kontrolle, Konzentration, Präzision und Bewegungsfluss. Das Training, das fordert, ohne zu überfordern,
    <ul>
      <li>verbindet kontrollierte Bewegung mit bewusster Atmung</li>
      <li>trainiert die tiefliegende Bauch-, Rücken- und Beckenbodenmuskulatur</li>
      <li>stabilisiert die Körpermitte</li>
      <li>korrigiert die Körperhaltung</li>
      <li>schult die Körperwahrnehmung </li>
      <li>steigert das geistige Wohlbefinden</li>
      <li>setzt neue Energien frei</li>
      <li>verbessert die Dehnfähigkeit von Muskeln und Sehnen</li>
      <li>beugt Rückenschmerzen vor</li>
      <li>baut Stress ab und erhöht die Konzentrationsfähigkeit</li>
      <li>verbessert Bewegungsmöglichkeiten des Körpers </li>
    </ul>
    Weiterhin wird die Wirbelsäulen- und Gelenkbeweglichkeit in schonender Weise verbessert, indem bei den Übungen die
    anatomisch-physiologischen Gegebenheiten des Muskel- und Skelettsystems berücksichtigt und das Training mit
    größtmöglicher Konzentration, in fließendem, sehr bewusstem und kontrolliertem Bewegungsablauf ausgeführt werden.
    ""","https://res.cloudinary.com/dqpamj6hy/image/upload/v1543351484/kristina/chaturanga_300x900.jpg" ), "/aktuelles" to Content("Aktuelles", "Aktuelle Information", """Aktuelle Informationen.
<ul><li>Start neuer 10er Kurs! - Am 24. September 2018 startet wieder der neue Kurs in Bad Godesberg, Theaterplatz 3 in den Räumen der physiotherapeutischen Praxis Lisa Steinhage. Uhrzeit 17:45 Uhr oder 19:00 Uhr.</li>
<li>Im Herbst gibt es wieder einen Pilates Power Kurs, dienstags um 18.45 Uhr, Dauer jeweils 90 Minuten. Termine wie folgt: 23.10. / 30.10. / 06.11./ 13.11./ 20.11. und 27.11. 2018. Die Kurse finden im Studio Flow, Weberstr.3 in Bonn statt, Anmeldungen bitte über das Studio Flow via Mail dance-wagner@web.de oder http://www.pilates-in-Bonn.de</li></ul>""",
        "https://res.cloudinary.com/dqpamj6hy/image/upload/v1543351648/kristina/downdog_300x900.jpg"
        ))